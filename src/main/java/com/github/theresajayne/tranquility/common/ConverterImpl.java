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
            
            copyNestedFB(fb, vo);
        }
        return vo;
    }

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
       
        Field[] fields = vo.getClass().getDeclaredFields();

        for (Field voField : fields) {
            
            if (ValueObject.class.isAssignableFrom(voField.getType())) {
                
                @SuppressWarnings("unchecked")
                VO nestedVO = (VO) PropertyUtils.getNestedProperty(vo, voField.getName());
                if (nestedVO != null) {
                    
                    String nestedFbName = getName(nestedVO);
                    
                    @SuppressWarnings("unchecked")
                    Class<FB> nestedFbClass = (Class<FB>) Class.forName(nestedFbName);
                    
                    @SuppressWarnings("unchecked")
                    FB nestedF = nestedFbClass.newInstance();
                    
                    PropertyUtils.copyProperties(nestedF, nestedVO);

                    try {
                        
                        new Mirror().on(fb).invoke().setterFor(voField).withValue(nestedF);
                    } catch (Exception e) {
                        
                        PropertyUtils.setNestedProperty(fb, StringUtils.uncapitalize(StringUtils.substringAfterLast(nestedFbName, Constants.CONVERTER_DOT)), nestedF);
                    }
                    nestedValueObject(nestedVO, nestedF);
                }
            }
            nestedValueObjectCollectionType(vo, fb, voField);
        }
    }

    private void nestedValueObjectCollectionType(VO vo, FB fb, Field voField) throws Exception {
       
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
                           
                        }
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
         Field[] fields = fb.getClass().getDeclaredFields();

        for (Field fbField : fields) {
            if (FormBean.class.isAssignableFrom(fbField.getType())) {
                @SuppressWarnings("unchecked")
                FB nestedFB = (FB) PropertyUtils.getNestedProperty(fb, fbField.getName());
                if (nestedFB != null) {
                    String nestedVoName = getName(nestedFB);
                    @SuppressWarnings("unchecked")
                    Class<VO> nestedVoClass = (Class<VO>) Class.forName(nestedVoName);
                    VO nestedV = nestedVoClass.newInstance();
                    PropertyUtils.copyProperties(nestedV, nestedFB);
 
                    try {
                        new Mirror().on(VO).invoke().setterFor(fbField).withValue(nestedV);
                    } catch (Exception e) {
                        PropertyUtils.setNestedProperty(VO, StringUtils.uncapitalize(StringUtils.substringAfterLast(nestedVoName, Constants.CONVERTER_DOT)), nestedV);
                    }

                    nestedFormBeans(nestedFB, nestedV);
                }
            }
            nestedFormBeanCollectionType(fb, VO, fbField);
        }
    }

    private void nestedFormBeanCollectionType(FB fb, VO VO, Field fbField) throws Exception {
        if (Collection.class.isAssignableFrom(fbField.getType()) && FormBean.class.isAssignableFrom(getFieldGenericType(fbField))) {
            @SuppressWarnings("unchecked")
            Collection<FB> listOfFb = (Collection<FB>) new Mirror().on(fb).invoke().getterFor(fbField);

            if (listOfFb != null) {
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
                    }

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
