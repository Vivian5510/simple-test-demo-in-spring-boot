package com.rosy.xxl.job.demo.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

@Component
public class DemoJob {

    @XxlJob("demoJobHandler")
    public ReturnT<String> execute() throws Exception {
        System.out.println("执行任务啦");
        return ReturnT.SUCCESS;
    }
}