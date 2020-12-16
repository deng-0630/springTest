package com.bdqn.test;

import com.bdqn.dao.BookDao;
import com.bdqn.dao.BookDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransation {
    private ApplicationContext ctx=null;
    private BookDao bookDao=null;
    {
        ctx=new ClassPathXmlApplicationContext("spring-jdbc.xml");
        bookDao= (BookDao) ctx.getBean("bookDaoImpl");
    }

@Test
    public void testBookDao(){
        System.out.println(bookDao.findBookPriceById(1001));
        bookDao.updateBookStock(1001);
        bookDao.updateUserAccount("wuhao",98);

    }
}
