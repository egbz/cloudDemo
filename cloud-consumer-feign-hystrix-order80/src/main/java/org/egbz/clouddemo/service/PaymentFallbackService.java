package org.egbz.clouddemo.service;

import org.springframework.stereotype.Component;

/**
 * @author egbz
 * @date 2021/4/5
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "[PaymentFallbackService]  paymentInfo_OK  fallback";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "P[aymentFallbackService]  paymentInfo_TimeOut  fallback";
    }
}
