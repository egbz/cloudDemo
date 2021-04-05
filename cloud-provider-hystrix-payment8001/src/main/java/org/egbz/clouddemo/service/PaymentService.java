package org.egbz.clouddemo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author egbz
 * @date 2021/4/3
 */
@Service
public class PaymentService {

    /**
     * 模拟正常访问
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "thread pool: " + Thread.currentThread().getName() + " paymentInfo_OK,id: " + id;
    }

    /**
     * 超时访问, 演示降级
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int ms = 5000;
        try {
            TimeUnit.MICROSECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        id /= 0;   // 模拟异常
        return "thread pool: " + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " + id;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "thread pool: " +  Thread.currentThread().getName() + " 超时或运行时异常,id: " + id + " T|E";
    }
}
