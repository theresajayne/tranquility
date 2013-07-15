package com.github.theresajayne.tranquility.model.dao;

import com.github.theresajayne.tranquility.model.beans.UniverseVO;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 15/07/13
 * Time: 17:52
 */
@Service
public class UniverseDaoImpl implements UniverseDao {
    
    @Autowired
    private SqlSession sqlSession;
    
    @Override
    public List<UniverseVO> getAllUniverses() {
        return sqlSession.selectList("universeMapper.selectAll");

    }

    @Override
    public void saveUniverse(UniverseVO universeVO) {
        sqlSession.insert("universeMapper.saveUniverse",universeVO);
    }
}
