package com.github.theresajayne.tranquility.model.services;

import com.github.theresajayne.tranquility.formbeans.UniverseFB;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 15/07/13
 * Time: 17:03
 */

public interface UniverseService {

    List<UniverseFB> getAllUniverses();
    UniverseFB getUniverseById(Long universeID);
    UniverseFB getUniverseByName(String name);
    void saveUniverse(UniverseFB universeFB);
    void deleteUniverse(UniverseFB universeFB);
}
