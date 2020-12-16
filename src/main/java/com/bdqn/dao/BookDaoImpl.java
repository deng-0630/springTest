package com.bdqn.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookDaoImpl implements BookDao{
   @Autowired
   private JdbcTemplate jdbcTemplate;
    public Double findBookPriceById(int bid) {
        String sql="select price from book where bookId=?";

        return jdbcTemplate.queryForObject(sql,Double.class,bid);
    }

    public void updateBookStock(int bid) {
        String sql="update mybook.book_stock set stock=stock-1 where bookId=?";
        jdbcTemplate.update(sql,bid);
    }

    public void updateUserAccount(String uname, int price) {
        String sql="update account set balance=balance-? where username=?";
        jdbcTemplate.update(sql,price,uname);
    }
}
