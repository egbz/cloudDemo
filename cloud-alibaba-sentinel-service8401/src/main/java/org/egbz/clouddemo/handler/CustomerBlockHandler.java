package org.egbz.clouddemo.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.egbz.clouddemo.entity.CommonResult;

/**
 * @author egbz
 * @date 2021/4/18
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(444, "自定义, global handlerException-------0");
    }

    public static CommonResult handlerException1(BlockException exception) {
        return new CommonResult(444, "自定义, global handlerException-------1");
    }
}
