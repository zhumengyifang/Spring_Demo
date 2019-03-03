import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("前方法 ： " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        System.out.println("后方法 ： " + beanName);
        // bean 目标对象
        // 生成 jdk 代理
        return Proxy.newProxyInstance(
                MyBeanPostProcessor.class.getClassLoader(),
                bean.getClass().getInterfaces(),
                (proxy, method, args) -> {

                    System.out.println("------开启事务");

                    //执行目标方法
                    Object obj = method.invoke(bean, args);

                    System.out.println("------提交事务");
                    return obj;
                });
    }

}
