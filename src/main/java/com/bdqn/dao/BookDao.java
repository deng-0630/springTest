package com.bdqn.dao;

public interface BookDao {
    //根据ID获得书的单价
    Double findBookPriceById(int bid);
    //更新书库存
    void updateBookStock(int bid);
    //更新用户余额
    void updateUserAccount(String uname,int price);
}
