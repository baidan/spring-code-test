package com.baidan.springCode.module.demo4.config;

import com.baidan.springCode.module.demo4.entity.Monkey;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author BaiDan
 */
public class Demo4FactoryBean implements FactoryBean<Monkey> {
    /**
     * @return 返回对象实例
     * @throws Exception
     */
    @Override
    public Monkey getObject() throws Exception {
        return new Monkey();
    }

    /**
     * 返回对象类型
     *
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Monkey.class;
    }

    /**
     * 是否单例
     *
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
