package org.egbz.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author egbz
 * @date 2021/4/1
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        // 负载均衡规则定义为 随机
        return new RandomRule();
    }
}
