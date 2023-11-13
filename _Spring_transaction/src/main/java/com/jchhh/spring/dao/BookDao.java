package com.jchhh.spring.dao;

public interface BookDao {
    /**
     * 根据 id 查询 书的价格
     */
    Integer getPriceByBookId(Integer bookId);

    /**
     * 根据 id 更新图书的库存
     */
    void updateStock(Integer bookId);

    /**
     * 更新用户的余额
     */
    void updateBalance(Integer userId, Integer bookPrice);
}
