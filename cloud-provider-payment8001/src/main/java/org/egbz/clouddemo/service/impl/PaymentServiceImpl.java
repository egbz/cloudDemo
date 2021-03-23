package org.egbz.clouddemo.service.impl;

import org.egbz.clouddemo.dao.PaymentDao;
import org.egbz.clouddemo.entity.Payment;
import org.egbz.clouddemo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author egbz
 * @date 2021/3/22
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
