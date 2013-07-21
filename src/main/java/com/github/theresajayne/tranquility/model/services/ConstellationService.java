package com.github.theresajayne.tranquility.model.services;

import com.github.theresajayne.tranquility.formbeans.ConstellationFB;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 21/07/13
 * Time: 14:47
 */
public interface ConstellationService {
    List<ConstellationFB> getAllConstellations();
    ConstellationFB getConstellationById(Long constellationID);
    ConstellationFB getConstellationByName(String name);
    void saveConstellation(ConstellationFB constellationFB);
    void deleteConstellation(ConstellationFB constellationFB);    
}
