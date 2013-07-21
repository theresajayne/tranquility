package com.github.theresajayne.tranquility.model.services;

import com.github.theresajayne.tranquility.common.Converter;
import com.github.theresajayne.tranquility.formbeans.ConstellationFB;
import com.github.theresajayne.tranquility.model.beans.ConstellationVO;
import com.github.theresajayne.tranquility.model.dao.ConstellationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 21/07/13
 * Time: 14:50
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ConstellationServiceImpl implements ConstellationService {
    
    @Autowired
    private ConstellationDao constellationDao;

    @Autowired
    private Converter converter;
    
    @Override
    public List<ConstellationFB> getAllConstellations() {
        List<ConstellationVO> constellationVOList =constellationDao.getAllConstellations();
        List<ConstellationFB> constellationFBList = new ArrayList<ConstellationFB>();
        for(ConstellationVO constellationVO : constellationVOList)
        {
            ConstellationFB fb = (ConstellationFB)converter.toFormBean(constellationVO);
            constellationFBList.add(fb);
        }
        return constellationFBList;        
    }

    @Override
    public ConstellationFB getConstellationById(Long constellationID) {
        return (ConstellationFB)converter.toFormBean(constellationDao.getConstellationByID(constellationID));
    }

    @Override
    public ConstellationFB getConstellationByName(String name) {
        return (ConstellationFB)converter.toFormBean(constellationDao.getConstellationByName(name));
    }

    @Override
    public void saveConstellation(ConstellationFB constellationFB) {
        constellationDao.saveConstellation((ConstellationVO)converter.toValueObject(constellationFB));
    }

    @Override
    public void deleteConstellation(ConstellationFB constellationFB) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
