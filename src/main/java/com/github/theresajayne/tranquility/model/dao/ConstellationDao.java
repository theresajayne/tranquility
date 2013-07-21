package com.github.theresajayne.tranquility.model.dao;

import com.github.theresajayne.tranquility.model.beans.ConstellationVO;
import com.github.theresajayne.tranquility.model.beans.RegionVO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 21/07/13
 * Time: 13:52
 */
public interface ConstellationDao {
    List<ConstellationVO> getAllConstellations();
    List<ConstellationVO> getAllConstellationsInRegion(RegionVO regionVO);
    ConstellationVO getConstellationByID(Long constellationID);
    ConstellationVO getConstellationByName(String name);
    void saveConstellation(ConstellationVO constellationVO);
}
