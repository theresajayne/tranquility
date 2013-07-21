package com.github.theresajayne.tranquility.model.dao;

import com.github.theresajayne.tranquility.model.beans.UniverseVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 15/07/13
 * Time: 17:52
 */
@Repository
public class UniverseDaoImpl implements UniverseDao {
    
    @Autowired
    private SqlSession sqlSession;
    
    @Override
    public List<UniverseVO> getAllUniverses() {
        return sqlSession.selectList("universeMapper.selectAll");

    }

    @Override
    public void saveUniverse(UniverseVO universeVO) {
        UniverseVO tempRecord = getUniverseByID(universeVO.getUniverseID());
        UniverseVO tempRecord2 = getUniverseByName(universeVO.getUniverseName());
        if(tempRecord==null && tempRecord2 == null)
        {
            sqlSession.insert("universeMapper.saveUniverse",universeVO);
        }
        else
        {
            if(tempRecord != null)
            {
                sqlSession.update("universeMapper.updateUniverse",universeVO);
            }
        }
    }


    @Override
    public UniverseVO getUniverseByName(String universeName) {
        return sqlSession.selectOne("universeMapper.selectAllByName",universeName);
    }

    @Override
    public UniverseVO getUniverseByID(Long universeID) {
        return sqlSession.selectOne("universeMapper.selectAllByID",universeID);
    }


}
