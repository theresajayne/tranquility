package com.github.theresajayne.tranquility.common;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 15/07/13
 * Time: 17:13
 */
public interface Converter<FB extends FormBean, VO extends ValueObject> {

    public VO toValueObject(FB fb);

    public FB toFormBean(VO vo);
}
