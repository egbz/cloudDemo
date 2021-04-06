package org.egbz.clouddemo.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int ms = 3000;
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        id /= 0;   // 模拟异常
        return "thread pool: " + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " + id;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "thread pool: " +  Thread.currentThread().getName() + " 超时或运行时异常,id: " + id + " T|E";
    }


//    ==========服务熔断
//    服务降级 -> 进而熔断 -> 恢复调用链路
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),   // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功, 流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "[paymentCircuitBreaker_fallback]  id不能为负数   id: " + id;
    }


}
