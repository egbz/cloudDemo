package org.egbz.clouddemo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author egbz
 * @date 2021/4/14
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value = "/testA")
    public String testA() {
//        // 模拟耗时
//        try {
//            TimeUnit.MILLISECONDS.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "---------testA";
    }

    @GetMapping(value = "/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "....testB");
        return "---------testB";
    }

    @GetMapping(value = "/testD")
    public String testD() {
//        // 模拟耗时
//        try {
//            TimeUnit.MILLISECONDS.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("testD 测试RT");


        int a = 10 / 0;
        log.info("testD 测试 异常比例");

        return "---------testD";
    }

    @GetMapping(value = "/testE")
    public String testE() {
        int a = 10 / 0;
        log.info("testE 测试 异常数");
        return "----------testE";
    }

    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "------[testHotKey]";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        return "---------[desl_testHotKey]";
    }


}
