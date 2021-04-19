package org.egbz.clouddemo.service;

import org.egbz.clouddemo.entity.CommonResult;
import org.egbz.clouddemo.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author egbz
 * @date 2021/4/19
 */
@Component
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackservice.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
