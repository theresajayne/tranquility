package com.github.theresajayne.tranquility.model.dao;

import com.github.theresajayne.tranquility.model.beans.RegionVO;
import com.github.theresajayne.tranquility.model.beans.UniverseVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 16/07/13
 * Time: 22:58
 */
@Repository
public class RegionDaoImpl implements RegionDao {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<RegionVO> getAllRegions() {
        return sqlSession.selectList("regionMapper.selectAll");
    }

    @Override
    public List<RegionVO> getAllRegionsInUniverse(UniverseVO universeVO) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public RegionVO getRegionByID(Long regionID) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public RegionVO getRegionByName(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveRegion(RegionVO regionVO) {
        sqlSession.insert("regionMapper.insertRegion",regionVO);
    }
}
