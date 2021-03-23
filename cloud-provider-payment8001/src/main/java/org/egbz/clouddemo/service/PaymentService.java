package org.egbz.clouddemo.service;

import org.apache.ibatis.annotations.Param;
import org.egbz.clouddemo.entity.Payment;

/**
 * @author egbz
 * @date 2021/3/22
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
