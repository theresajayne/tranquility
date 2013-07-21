package com.github.theresajayne.tranquility.common;

import net.vidageek.mirror.dsl.Mirror;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 15/07/13
 * Time: 17:16
 */
@Component
@SuppressWarnings("unchecked")
public class ConverterImpl<F extends FormBean, V extends ValueObject> implements Converter<F, V> {
    private static Logger LOG = Logger.getLogger(ConverterImpl.class);
    private static final String DOT = ".";
    private static final String FORM_BEANS = ".formbeans";
    private static final String VALUE_BEANS = ".model.beans";
    private static final String FORM_BEAN_SUFFIX = "FB";
    private static final String VALUE_BEAN_SUFFIX = "VO";

    /**
     * Returns value object of form bean with copied properties including nested properties.
     *
     * @param fb - An object of type FormBean
     * @return vo - An object of type ValueObject
     */
    public V toValueObject(F fb) {
        if (fb == null) return null;
        String voName = getName(fb);
        V v = null;
        try {
            Class<V> voClass = (Class<V>) Class.forName(voName);
            v = voClass.newInstance();
            copyFbToVo(fb, v);
        } catch (Exception e) {
            LOG.error(e);
        } finally {
            //Copy nested Form Bean to Value Object
            copyNestedFB(fb, v);
        }
        return v;
    }

    /**
     * Returns form bean of value object with copied properties including nested properties.
     *
     * @param vo - An object of type ValueObject
     * @return fb - An object of type FormBean
     */
    public F toFormBean(V vo) {
        if (vo == null) return null;
        String fbName = getName(vo);
        F fb = null;
        try {
            Class<F> voClass = (Class<F>) Class.forName(fbName);
            fb = voClass.newInstance();
            copyVoToFb(vo, fb);
        } catch (Exception e) {
            LOG.error(e);
        } finally {
            //Copy nested Form Bean to Value Object
            copyNestedVO(vo, fb);
        }
        return fb;
    }

    private void copyVoToFb(V vo, F fb) {
        Mirror source = new Mirror();
        Mirror target = new Mirror();
        Field[] fields = fb.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                Object fieldValue = source.on(vo).invoke().getterFor(field);
                if (fieldValue != null) {
                    target.on(fb).invoke().setterFor(field).withValue(fieldValue);
                }
            } catch (Exception e) {
                //Don't care exception as we are trying to copy of <ValueObject> type object into <FormBean>
                //So this method will definitely throw exception, so catch the exception and copy other fields
                //LOG.warn(e);
            }
        }
    }

    private void copyNestedVO(V vo, F f) {
        try {
            nestedValueObject(vo, f);
        } catch (Exception e) {
            LOG.error("Converter is failed",e);
        }
    }

    private void nestedValueObject(V vo, F fb) throws Exception {
        //All Value Object fields
        Field[] fields = vo.getClass().getDeclaredFields();

        for (Field voField : fields) {
            //Filter on Value Object filed
            if (ValueObject.class.isAssignableFrom(voField.getType())) {
                //Get nested Value Object
                V nestedVO = (V) PropertyUtils.getNestedProperty(vo, voField.getName());
                if (nestedVO != null) {
                    //Get nested Form Bean name from nested Value Object
                    String nestedFbName = getName(nestedVO);
                    //Instantiate nested Form Bean class
                    Class<F> nestedFbClass = (Class<F>) Class.forName(nestedFbName);
                    //Instantiate nested equivalent Form Bean
                    F nestedF = nestedFbClass.newInstance();
                    //Populate nested form bean with nested Value object
                    PropertyUtils.copyProperties(nestedF, nestedVO);

                    //Set nested property in parent value object
                    try {
                        //When fields name in both <FormBean> and <ValueObject> are same.
                        new Mirror().on(fb).invoke().setterFor(voField).withValue(nestedF);
                    } catch (Exception e) {
                        //When fields name in both <FormBean> and <ValueObject> are different.
                        PropertyUtils.setNestedProperty(fb, StringUtils.uncapitalize(StringUtils.substringAfterLast(nestedFbName, DOT)), nestedF);
                    }

                    //Recursive call until nested form beans over
                    nestedValueObject(nestedVO, nestedF);
                }
            }
            nestedValueObjectCollectionType(vo, fb, voField);
        }
    }

    private void nestedValueObjectCollectionType(V vo, F fb, Field voField) throws Exception {
        //If fields are of type Collection<ValueObject>
        if (Collection.class.isAssignableFrom(voField.getType()) && ValueObject.class.isAssignableFrom(getFieldGenericType(voField))) {

            List<V> listOfVos = (List<V>) new Mirror().on(vo).invoke().getterFor(voField);

            if (listOfVos != null) {

                List<FormBean> newListOfFbs = new ArrayList<FormBean>(listOfVos.size());

                for (V v : listOfVos) {

                    if( v != null)
                    {
                        String fbName = getName(v);

                        Class<F> fbClass = (Class<F>) Class.forName(fbName);

                        F f = fbClass.newInstance();

                        try {
                            PropertyUtils.copyProperties(f, v);
                        } catch (Exception e) {
                            //Don't care as It has to copy other fields in loop
                        }

                        //Collection object can have another collection objects of Value Object type
                        nestedValueObject(v, f);

                        newListOfFbs.add(f);
                    }
                }

                new Mirror().on(fb).invoke().setterFor(voField).withValue(newListOfFbs);
            }
        }
    }

    private void copyNestedFB(F fb, V v) {
        try {
            nestedFormBeans(fb, v);
        } catch (Exception e) {
            LOG.error(e);
        }
    }

    private void nestedFormBeans(F fb, V v) throws Exception {
        //All form Beans fields
        Field[] fields = fb.getClass().getDeclaredFields();

        for (Field fbField : fields) {
            //Filter on form bean filed
            if (FormBean.class.isAssignableFrom(fbField.getType())) {
                //Get nested form bean value
                F nestedFB = (F) PropertyUtils.getNestedProperty(fb, fbField.getName());
                if (nestedFB != null) {
                    //Get nested Value object name from nested Form Bean
                    String nestedVoName = getName(nestedFB);
                    //Instantiate nested Value Object class
                    Class<V> nestedVoClass = (Class<V>) Class.forName(nestedVoName);
                    //Create nested equivalent value object
                    V nestedV = nestedVoClass.newInstance();
                    //Populate nested Value object with nested form bean
                    PropertyUtils.copyProperties(nestedV, nestedFB);
                    //Set nested property in parent value object

                    try {
                        //When fields name in both <FormBean> and <ValueObject> are same.
                        new Mirror().on(v).invoke().setterFor(fbField).withValue(nestedV);
                    } catch (Exception e) {
                        //When fields name in both <FormBean> and <ValueObject> are different.
                        PropertyUtils.setNestedProperty(v, StringUtils.uncapitalize(StringUtils.substringAfterLast(nestedVoName, DOT)), nestedV);
                    }

                    //Recursive call until nested form beans over
                    nestedFormBeans(nestedFB, nestedV);
                }
            }
            nestedFormBeanCollectionType(fb, v, fbField);
        }
    }

    private void nestedFormBeanCollectionType(F fb, V v, Field fbField) throws Exception {
        //If fields are of type Collection<FormBean>
        if (Collection.class.isAssignableFrom(fbField.getType()) && FormBean.class.isAssignableFrom(getFieldGenericType(fbField))) {

            Collection<F> listOfFb = (Collection<F>) new Mirror().on(fb).invoke().getterFor(fbField);

            if (listOfFb != null) {
                //Create same type of collection class
                Collection<ValueObject> newListOfVo = listOfFb.getClass().newInstance();

                for (F f : listOfFb) {

                    String voName = getName(f);

                    Class<V> voClass = (Class<V>) Class.forName(voName);

                    V vc = voClass.newInstance();

                    try {
                        PropertyUtils.copyProperties(vc, f);
                    } catch (Exception e) {
                        //Don't care for exception as It has to copy other fields in loop
                    }

                    //Current collection object can have child collection object of type Value Object
                    nestedFormBeans(f, vc);

                    newListOfVo.add(vc);
                }

                new Mirror().on(v).invoke().setterFor(fbField).withValue(newListOfVo);
            }
        }
    }

    public Class getFieldGenericType(Field field) {
        if (ParameterizedType.class.isAssignableFrom(field.getGenericType().getClass())) {
            ParameterizedType genericType = (ParameterizedType) field.getGenericType();
            return ((Class) (genericType.getActualTypeArguments()[0])).getSuperclass();
        }
        //Returns dummy Boolean Class to compare with ValueObject & FormBean
        return Boolean.class;
    }

    private void copyFbToVo(F fb, V v) {
        Mirror source = new Mirror();
        Mirror target = new Mirror();
        Field[] fields = fb.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                Object fieldValue = source.on(fb).invoke().getterFor(field);
                if (fieldValue != null) {
                    target.on(v).invoke().setterFor(field).withValue(fieldValue);
                }
            } catch (Exception e) {
                //Don't care exception as we are trying to copy of <FormBean> type object into <ValueObject>
                //So this method will definitely throw exception, so catch the exception and copy other fields
                //LOG.warn(e);
            }
        }
    }

    private String getName(Object fb)
    {
        String fbPackage = fb.getClass().getPackage().getName();
        String source;
        String dest;
        String sourceSuffix;
        String destSuffix;
        if(fbPackage.endsWith(FORM_BEANS))
        {
            source = FORM_BEANS;
            dest = VALUE_BEANS;
            sourceSuffix = FORM_BEAN_SUFFIX;
            destSuffix = VALUE_BEAN_SUFFIX;
        }
        else
        {
            dest = FORM_BEANS;
            source = VALUE_BEANS;
            destSuffix = FORM_BEAN_SUFFIX;
            sourceSuffix = VALUE_BEAN_SUFFIX;
        }
        String voPackage = StringUtils.replaceOnce(fbPackage, source, dest);
        String fbName = StringUtils.substringAfterLast(fb.getClass().getName(), DOT);
        String voName = StringUtils.substringBeforeLast(fbName, sourceSuffix) + destSuffix;

        return voPackage + DOT + voName;
    }

}
