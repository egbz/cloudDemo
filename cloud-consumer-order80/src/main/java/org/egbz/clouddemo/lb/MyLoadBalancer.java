package org.egbz.clouddemo.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author egbz
 * @date 2021/4/2
 */
@Component
public class MyLoadBalancer implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("***next: " + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serverInstances) {
        int index = getAndIncrement() % serverInstances.size();
        return serverInstances.get(index);
    }
}
