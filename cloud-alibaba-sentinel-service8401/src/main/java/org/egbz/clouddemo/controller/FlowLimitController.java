package org.egbz.clouddemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author egbz
 * @date 2021/4/14
 */
@RestController
public class FlowLimitController {

    @GetMapping(value = "/testA")
    public String testA() {
        return "---------testA";
    }

    @GetMapping(value = "/testB")
    public String testB() {
        return "---------testB";
    }

}
