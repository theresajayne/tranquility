package com.github.theresajayne.tranquility.model.dao;

import com.github.theresajayne.tranquility.model.beans.UniverseVO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 15/07/13
 * Time: 17:51
 * To change this template use File | Settings | File Templates.
 */
public interface UniverseDao {

    List<UniverseVO> getAllUniverses();

    void saveUniverse(UniverseVO universeVO);

    UniverseVO getUniverseByName(String universeName);

    UniverseVO getUniverseByID(Long universeID);
}
