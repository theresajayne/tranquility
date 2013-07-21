package com.github.theresajayne.tranquility.model.services;

import com.github.theresajayne.tranquility.common.Converter;
import com.github.theresajayne.tranquility.formbeans.UniverseFB;
import com.github.theresajayne.tranquility.model.beans.UniverseVO;
import com.github.theresajayne.tranquility.model.dao.UniverseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 15/07/13
 * Time: 17:45
 */
@Service
public class UniverseServiceImpl implements UniverseService {

    @Autowired
    private Converter converter;

    @Autowired
    private UniverseDao universeDao;

    @Override
    public List<UniverseFB> getAllUniverses() {
        List<UniverseVO> universeVOList =universeDao.getAllUniverses();
        List<UniverseFB> universeFBList = new ArrayList<UniverseFB>();
        for(UniverseVO universeVO : universeVOList)
        {
            UniverseFB fb = (UniverseFB)converter.toFormBean(universeVO);
            universeFBList.add(fb);
        }
        return universeFBList;
    }

    @Override
    public UniverseFB getUniverseById(Long universeID) {
        return (UniverseFB)converter.toFormBean(universeDao.getUniverseByID(universeID));
    }

    @Override
    public UniverseFB getUniverseByName(String name) {
        return (UniverseFB)converter.toFormBean(universeDao.getUniverseByName(name));
    }

    @Override
    public void saveUniverse(UniverseFB universeFB) {
        UniverseVO universeVO = (UniverseVO)converter.toValueObject(universeFB);
        universeDao.saveUniverse(universeVO);
    }

    @Override
    public void deleteUniverse(UniverseFB universeFB) {

    }
}
