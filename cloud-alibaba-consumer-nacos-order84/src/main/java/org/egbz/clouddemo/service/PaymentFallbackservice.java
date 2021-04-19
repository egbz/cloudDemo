package org.egbz.clouddemo.service;

import org.egbz.clouddemo.entity.CommonResult;
import org.egbz.clouddemo.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @author egbz
 * @date 2021/4/19
 */
@Component
public class PaymentFallbackservice implements PaymentService{

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级返回, -----PaymentFallbackservice", new Payment(id, "errorSerial"));
    }
}
