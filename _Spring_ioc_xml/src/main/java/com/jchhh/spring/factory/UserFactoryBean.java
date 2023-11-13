package com.jchhh.spring.factory;

import com.jchhh.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

public class UserFactoryBean implements FactoryBean<User> {

    //  通过一个对象交给IOC容器管理
    @Override
    public User getObject() throws Exception {
        //  将此方法的返回值交给 ioc容器 管理
        return new User();
    }

    //  设置所提供对象的类型
    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    /**
     * isSingleton（）：所提供的对象是否单例     默认为单例
     *  当把FactoryBean的实现类配置为Bean时，会将当前类中getObject()所返回的对象交给IOC容器管理
     */

}
