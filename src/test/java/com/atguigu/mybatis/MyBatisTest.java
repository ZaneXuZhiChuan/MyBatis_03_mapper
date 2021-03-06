package com.atguigu.mybatis;

import com.atguigu.bean.Employee;
import com.atguigu.dao.EmployeeMapper;
import com.atguigu.dao.EmployeeMapperAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {

    @Test
    public void employeeTest() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Employee employee = sqlSession.selectOne("com.atguigu.mybatis.EmployeeMapper.selectEmp", 1);
        System.out.println(employee);
        sqlSession.close();
    }

    private SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void employeeMapperTest() throws IOException {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        System.out.println(employeeMapper.getEmpById(2));
        sqlSession.close();
    }

    @Test
    public void employeeMapperAnnotationTest() throws IOException {
        System.out.println(getSqlSessionFactory().openSession().getMapper(EmployeeMapperAnnotation.class).getEmpById(1));
    }

    @Test
    public void addEmpTest() throws IOException {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        Employee mary = new Employee(2, "mary", "mary@gmai.com", "0");
        sqlSession.getMapper(EmployeeMapper.class).addEmp(mary);
        sessionCommitAndClose(sqlSession);
    }

    @Test
    public void addEmpWithResourceMapperTest() throws IOException {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        Employee mary = new Employee(3, "XiaoMing", "XiaoMing@gmai.com", "1");
        sqlSession.getMapper(EmployeeMapper.class).addEmp(mary);
        sessionCommitAndClose(sqlSession);
    }

    private void sessionCommitAndClose(SqlSession sqlSession) {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateEmpTest() throws IOException {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        Employee employee = new Employee(2, "Tom", "ToN@gmai.com", "0");
        sqlSession.getMapper(EmployeeMapper.class).updateEmp(employee);
        sessionCommitAndClose(sqlSession);
    }

}
