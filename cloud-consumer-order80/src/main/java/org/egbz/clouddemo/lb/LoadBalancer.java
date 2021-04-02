package org.egbz.clouddemo.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author egbz
 * @date 2021/4/2
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serverInstances);
}
