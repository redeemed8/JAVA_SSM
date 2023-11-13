package com.jchhh.spring.service.impl;

import com.jchhh.spring.dao.BookDao;
import com.jchhh.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    /**
     * readOnly = true 将事务设置为只读属性，然后sql会优化它     ----  不能有修改操作
     * timeout = 3  设置事务处理时间最多为 3 秒，若超过3秒仍未执行完毕，那么--- 强制回滚并且报错 TransactionTimedOutException
     * noRollbackFor = ArithmeticException.class 意为 遇到什么异常不会滚回滚
     * noRollbackForClassName 功能一样，只不过要写 异常所对的全类名
     * isolation = Isolation.DEFAULT    设置隔离级别为默认
     * propagation = Propagation.REQUIRES_NEW     意为不使用买书的事务，而是开启一个新的事务 ----也就是结账的事务
     */
    @Override
/*    @Transactional(
            //  readOnly = true
            //  timeout = 5
            //  noRollbackFor = ArithmeticException.class
            //  noRollbackForClassName = "java.lang.ArithmeticException"
            //  isolation = Isolation.DEFAULT
            propagation = Propagation.REQUIRES_NEW
    )*/
    public void buyBook(Integer userId, Integer bookId) {

        /*try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //  查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookId);
        //  更新图书的库存
        bookDao.updateStock(bookId);
        //  更新用户的余额
        bookDao.updateBalance(userId, price);

        //  System.out.println(1 / 0);      //  对应 ArithmeticException 异常
    }
}
