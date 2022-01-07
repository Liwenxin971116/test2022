package com.nihao.test;

import com.nihao.dao.UserDAO;
import com.nihao.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TextMyBatis {
    public static void main(String[] args) throws IOException {

        InputStream inputstream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDAO mapper = sqlSession.getMapper(UserDAO.class);

                User user = mapper.queryUserById(1001);
        User user1 = mapper.queryUserById(1002);
        System.out.println(user);
        System.out.println(user1);

    }
}
