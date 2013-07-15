package com.github.theresajayne.tranquility.common;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 15/07/13
 * Time: 17:13
 * To change this template use File | Settings | File Templates.
 */
public interface Converter<F extends FormBean, V extends ValueObject> {

    public V toValueObject(F fb);

    public F toFormBean(V vo);
}
