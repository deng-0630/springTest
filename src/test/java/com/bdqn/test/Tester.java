package com.bdqn.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    private ApplicationContext ctx=null;
    private JdbcTemplate jdbcTemplate=null;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate=null;
    {
        ctx=new ClassPathXmlApplicationContext("spring-jdbc.xml");
        jdbcTemplate= (JdbcTemplate) ctx.getBean("jdbcTemplate");
        namedParameterJdbcTemplate=ctx.getBean(NamedParameterJdbcTemplate.class);
    }
    @Test
    public void testNameParameter(){
        String sql="insert grade values(null,:gradeName)";
        Grade g=new Grade();
        g.setGradeName("S9");
        SqlParameterSource sqlsource=new BeanPropertySqlParameterSource(g);
        int update = namedParameterJdbcTemplate.update(sql, sqlsource);
        System.out.println(update>0?"成功":"失败");
    }

    @Test
    public void testQueryforList(){
        String sql ="select * from student";
        RowMapper<Student> rowmapper=new BeanPropertyRowMapper<Student>(Student.class);
        List<Student> student= jdbcTemplate.query(sql,rowmapper);
        System.out.println(student.size());
    }
    @Test
    public void testqueryforSingle(){
        String sql="select address from student where studentno=?";
        String s=jdbcTemplate.queryForObject(sql,String.class,"s1101001");
        System.out.println(s);
    }

    //批量更新
    @Test
    public void testBatchUpdate(){
        String sql="insert grade value(null,?)";
        List<Object[]> list=new ArrayList<Object[]>();
        list.add(new Object[]{"y6"});
        list.add(new Object[]{"y7"});
        list.add(new Object[]{"y8"});
        list.add(new Object[]{"y9"});
        int[] r=jdbcTemplate.batchUpdate(sql,list);
        for (int i:r){
            System.out.println(i>0?"插入成功":"插入失败");
        }
    }
    @Test
    public void testQueryforObject(){
        String sql ="select * from student where studentno=?";
        RowMapper<Student> rowmapper=new BeanPropertyRowMapper<Student>(Student.class);
        Student student= jdbcTemplate.queryForObject(sql,rowmapper,"S1101001");
        System.out.println(student);
    }

    @Test
    public void testNonQuery(){
        DataSource ds= (DataSource) ctx.getBean("dataSource");
        String sql="insert grade value(null,?)";
        int r=jdbcTemplate.update(sql,"Y4");
        System.out.println(r>0?"插入成功":"插入失败");
    }
}
