package com.github.theresajayne.tranquility.model.dao;

import com.github.theresajayne.tranquility.model.beans.ConstellationVO;
import com.github.theresajayne.tranquility.model.beans.RegionVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 21/07/13
 * Time: 13:57
 */
@Repository
public class ConstellationDaoImpl implements ConstellationDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<ConstellationVO> getAllConstellations() {
        return sqlSession.selectList("constellationMapper.selectAll");
    }

    @Override
    public List<ConstellationVO> getAllConstellationsInRegion(RegionVO regionVO) {
        return sqlSession.selectList("constellationMapper.selectAllByRegion",regionVO);
    }

    @Override
    public ConstellationVO getConstellationByID(Long constellationID) {
        return sqlSession.selectOne("constellationMapper.selectByID",constellationID);
    }

    @Override
    public ConstellationVO getConstellationByName(String constellationName) {
        return sqlSession.selectOne("constellationMapper.selectByName",constellationName);
    }

    @Override
    public void saveConstellation(ConstellationVO constellationVO) {
        ConstellationVO tempRecord = getConstellationByID(constellationVO.getConstellationID());
        ConstellationVO tempRecord2 = getConstellationByName(constellationVO.getConstellationName());
        if(tempRecord== null&& tempRecord2==null)
        {
            sqlSession.insert("constellationMapper.insertConstellation",constellationVO);
        }
        else
        {
            if(tempRecord!= null)
            {
                sqlSession.update("constellationMapper.updateConstellation",constellationVO);
            }
        }
    }
}
