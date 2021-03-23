package org.egbz.clouddemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.egbz.clouddemo.entity.Payment;

/**
 * @author egbz
 * @date 2021/3/22
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
