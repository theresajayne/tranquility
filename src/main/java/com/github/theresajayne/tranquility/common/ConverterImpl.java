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
public class ConverterImpl<FB extends FormBean, VO extends ValueObject> implements Converter<FB, VO> {
    private static Logger LOG = Logger.getLogger(ConverterImpl.class);


    public VO toValueObject(FB fb) {
        if (fb == null) return null;
        String voName = getName(fb);
        VO vo = null;
        try {
            @SuppressWarnings("unchecked")
            Class<VO> voClass = (Class<VO>) Class.forName(voName);
            vo = voClass.newInstance();
            copyFbToVo(fb, vo);
        } catch (Exception e) {
            LOG.error(e);
        } finally {
            //Copy nested Form Bean to Value Object
            copyNestedFB(fb, vo);
        }
        return vo;
    }

    /**
     * Returns form bean of value object with copied properties including nested properties.
     *
     * @param vo - An object of type ValueObject
     * @return fb - An object of type FormBean
     */
    public FB toFormBean(VO vo) {
        if (vo == null) return null;
        String fbName = getName(vo);
        FB fb = null;
        try {
            @SuppressWarnings("unchecked")
            Class<FB> voClass = (Class<FB>) Class.forName(fbName);
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

    private void copyVoToFb(VO vo, FB fb) {
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

    private void copyNestedVO(VO vo, FB FB) {
        try {
            nestedValueObject(vo, FB);
        } catch (Exception e) {
            LOG.error("Converter is failed",e);
        }
    }

    private void nestedValueObject(VO vo, FB fb) throws Exception {
        //All Value Object fields
        Field[] fields = vo.getClass().getDeclaredFields();

        for (Field voField : fields) {
            //Filter on Value Object filed
            if (ValueObject.class.isAssignableFrom(voField.getType())) {
                //Get nested Value Object
                @SuppressWarnings("unchecked")
                VO nestedVO = (VO) PropertyUtils.getNestedProperty(vo, voField.getName());
                if (nestedVO != null) {
                    //Get nested Form Bean name from nested Value Object
                    String nestedFbName = getName(nestedVO);
                    //Instantiate nested Form Bean class
                    @SuppressWarnings("unchecked")
                    Class<FB> nestedFbClass = (Class<FB>) Class.forName(nestedFbName);
                    //Instantiate nested equivalent Form Bean
                    @SuppressWarnings("unchecked")
                    FB nestedF = nestedFbClass.newInstance();
                    //Populate nested form bean with nested Value object
                    PropertyUtils.copyProperties(nestedF, nestedVO);

                    //Set nested property in parent value object
                    try {
                        //When fields name in both <FormBean> and <ValueObject> are same.
                        new Mirror().on(fb).invoke().setterFor(voField).withValue(nestedF);
                    } catch (Exception e) {
                        //When fields name in both <FormBean> and <ValueObject> are different.
                        PropertyUtils.setNestedProperty(fb, StringUtils.uncapitalize(StringUtils.substringAfterLast(nestedFbName, Constants.CONVERTER_DOT)), nestedF);
                    }

                    //Recursive call until nested form beans over
                    nestedValueObject(nestedVO, nestedF);
                }
            }
            nestedValueObjectCollectionType(vo, fb, voField);
        }
    }

    private void nestedValueObjectCollectionType(VO vo, FB fb, Field voField) throws Exception {
        //If fields are of type Collection<ValueObject>
        if (Collection.class.isAssignableFrom(voField.getType()) && ValueObject.class.isAssignableFrom(getFieldGenericType(voField))) {
            @SuppressWarnings("unchecked")
            List<VO> listOfVos = (List<VO>) new Mirror().on(vo).invoke().getterFor(voField);

            if (listOfVos != null) {

                List<FormBean> newListOfFbs = new ArrayList<FormBean>(listOfVos.size());

                for (VO VO : listOfVos) {

                    if( VO != null)
                    {
                        String fbName = getName(VO);
                        @SuppressWarnings("unchecked")
                        Class<FB> fbClass = (Class<FB>) Class.forName(fbName);

                        FB FB = fbClass.newInstance();

                        try {
                            PropertyUtils.copyProperties(FB, VO);
                        } catch (Exception e) {
                            //Don't care as It has to copy other fields in loop
                        }

                        //Collection object can have another collection objects of Value Object type
                        nestedValueObject(VO, FB);

                        newListOfFbs.add(FB);
                    }
                }

                new Mirror().on(fb).invoke().setterFor(voField).withValue(newListOfFbs);
            }
        }
    }

    private void copyNestedFB(FB fb, VO VO) {
        try {
            nestedFormBeans(fb, VO);
        } catch (Exception e) {
            LOG.error(e);
        }
    }

    private void nestedFormBeans(FB fb, VO VO) throws Exception {
        //All form Beans fields
        Field[] fields = fb.getClass().getDeclaredFields();

        for (Field fbField : fields) {
            //Filter on form bean filed
            if (FormBean.class.isAssignableFrom(fbField.getType())) {
                //Get nested form bean value
                @SuppressWarnings("unchecked")
                FB nestedFB = (FB) PropertyUtils.getNestedProperty(fb, fbField.getName());
                if (nestedFB != null) {
                    //Get nested Value object name from nested Form Bean
                    String nestedVoName = getName(nestedFB);
                    //Instantiate nested Value Object class
                    @SuppressWarnings("unchecked")
                    Class<VO> nestedVoClass = (Class<VO>) Class.forName(nestedVoName);
                    //Create nested equivalent value object
                    VO nestedV = nestedVoClass.newInstance();
                    //Populate nested Value object with nested form bean
                    PropertyUtils.copyProperties(nestedV, nestedFB);
                    //Set nested property in parent value object

                    try {
                        //When fields name in both <FormBean> and <ValueObject> are same.
                        new Mirror().on(VO).invoke().setterFor(fbField).withValue(nestedV);
                    } catch (Exception e) {
                        //When fields name in both <FormBean> and <ValueObject> are different.
                        PropertyUtils.setNestedProperty(VO, StringUtils.uncapitalize(StringUtils.substringAfterLast(nestedVoName, Constants.CONVERTER_DOT)), nestedV);
                    }

                    //Recursive call until nested form beans over
                    nestedFormBeans(nestedFB, nestedV);
                }
            }
            nestedFormBeanCollectionType(fb, VO, fbField);
        }
    }

    private void nestedFormBeanCollectionType(FB fb, VO VO, Field fbField) throws Exception {
        //If fields are of type Collection<FormBean>
        if (Collection.class.isAssignableFrom(fbField.getType()) && FormBean.class.isAssignableFrom(getFieldGenericType(fbField))) {
            @SuppressWarnings("unchecked")
            Collection<FB> listOfFb = (Collection<FB>) new Mirror().on(fb).invoke().getterFor(fbField);

            if (listOfFb != null) {
                //Create same type of collection class
                @SuppressWarnings("unchecked")
                Collection<ValueObject> newListOfVo = listOfFb.getClass().newInstance();

                for (FB FB : listOfFb) {

                    String voName = getName(FB);
                    @SuppressWarnings("unchecked")
                    Class<VO> voClass = (Class<VO>) Class.forName(voName);

                    VO vc = voClass.newInstance();

                    try {
                        PropertyUtils.copyProperties(vc, FB);
                    } catch (Exception e) {
                        //Don't care for exception as It has to copy other fields in loop
                    }

                    //Current collection object can have child collection object of type Value Object
                    nestedFormBeans(FB, vc);

                    newListOfVo.add(vc);
                }

                new Mirror().on(VO).invoke().setterFor(fbField).withValue(newListOfVo);
            }
        }
    }

    public Class getFieldGenericType(Field field) {
        if (ParameterizedType.class.isAssignableFrom(field.getGenericType().getClass())) {
            ParameterizedType genericType = (ParameterizedType) field.getGenericType();
            return ((Class) (genericType.getActualTypeArguments()[0])).getSuperclass();
        }
        return Boolean.class;
    }

    private void copyFbToVo(FB fb, VO VO) {
        Mirror source = new Mirror();
        Mirror target = new Mirror();
        Field[] fields = fb.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                Object fieldValue = source.on(fb).invoke().getterFor(field);
                if (fieldValue != null) {
                    target.on(VO).invoke().setterFor(field).withValue(fieldValue);
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
        if(fbPackage.endsWith(Constants.CONVERTER_FORM_BEANS))
        {
            source = Constants.CONVERTER_FORM_BEANS;
            dest = Constants.CONVERTER_VALUE_BEANS;
            sourceSuffix = Constants.CONVERTER_FORM_BEAN_SUFFIX;
            destSuffix = Constants.CONVERTER_VALUE_BEAN_SUFFIX;
        }
        else
        {
            dest = Constants.CONVERTER_FORM_BEANS;
            source = Constants.CONVERTER_VALUE_BEANS;
            destSuffix = Constants.CONVERTER_FORM_BEAN_SUFFIX;
            sourceSuffix = Constants.CONVERTER_VALUE_BEAN_SUFFIX;
        }
        String voPackage = StringUtils.replaceOnce(fbPackage, source, dest);
        String fbName = StringUtils.substringAfterLast(fb.getClass().getName(), Constants.CONVERTER_DOT);
        String voName = StringUtils.substringBeforeLast(fbName, sourceSuffix) + destSuffix;

        return voPackage + Constants.CONVERTER_DOT + voName;
    }

}