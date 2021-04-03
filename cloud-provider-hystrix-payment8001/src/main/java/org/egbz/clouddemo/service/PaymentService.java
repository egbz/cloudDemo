package org.egbz.clouddemo.service;

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
     * 模拟超时
     * @param id
     * @return
     */
    public String paymentInfo_TimeOut(Integer id) {
        int seconds = 3;
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "thread pool: " + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " + id;

    }
}
