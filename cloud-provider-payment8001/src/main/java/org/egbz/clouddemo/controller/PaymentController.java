package org.egbz.clouddemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.egbz.clouddemo.entity.CommonResult;
import org.egbz.clouddemo.entity.Payment;
import org.egbz.clouddemo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author egbz
 * @date 2021/3/22
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果: " + result);

        return result > 0 ? new CommonResult(200, "插入数据库成功", result)
                : new CommonResult(444, "插入数据库失败", result);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果: " + payment);

        return payment != null ? new CommonResult(200, "查询成功", payment)
                : new CommonResult(444, "无数据", null);
    }
}
