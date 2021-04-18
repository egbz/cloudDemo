package org.egbz.clouddemo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.egbz.clouddemo.entity.CommonResult;
import org.egbz.clouddemo.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author egbz
 * @date 2021/4/18
 */
@RestController
@Slf4j
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate rt;

    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback") // 没有配置
//    @SentinelResource(value = "fallback")
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = rt.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException, 无对应记录");
        }
        return result;
    }

}
