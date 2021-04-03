package org.egbz.clouddemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.egbz.clouddemo.entity.CommonResult;
import org.egbz.clouddemo.entity.Payment;
import org.egbz.clouddemo.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author egbz
 * @date 2021/4/2
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
