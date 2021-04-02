package org.egbz.clouddemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.egbz.clouddemo.entity.CommonResult;
import org.egbz.clouddemo.entity.Payment;
import org.egbz.clouddemo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author egbz
 * @date 2021/3/29
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果: " + result);

        return result > 0 ? new CommonResult(200, "插入数据库成功, serverPort: " + serverPort, result)
                : new CommonResult(444, "插入数据库失败, serverPort: " + serverPort, result);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果: " + payment);

        return payment != null ? new CommonResult(200, "查询成功, serverPort: " + serverPort, payment)
                : new CommonResult(444, "无数据, serverPort: " + serverPort, null);
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
