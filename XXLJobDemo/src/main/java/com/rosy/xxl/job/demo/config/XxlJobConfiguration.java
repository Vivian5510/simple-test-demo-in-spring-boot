package com.rosy.xxl.job.demo.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class XxlJobConfiguration {

    //调度中心地址
    @Value("${xxl-job.admin.address}")
    private String adminAddresses;
    //调度中心通讯秘钥
    @Value("${xxl-job.admin.access-token}")
    private String accessToken;
    //调度中心通讯超时时间
    @Value("${xxl-job.admin.timeout}")
    private Integer timeout;

    //执行器AppName
    @Value("${xxl-job.executor.app-name}")
    private String appName;
    //执行器优先使用该地址作为注册地址
    @Value("${xxl-job.executor.address}")
    private String executorAddress;
    //执行器运行日志文件存储磁盘路径
    @Value("${xxl-job.executor.log-path}")
    private String executorLogPath;

    @Bean
    public XxlJobSpringExecutor xxlJobSpringExecutor () {
        log.info("============================== XxlJobSpringExecutor ==============================");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        xxlJobSpringExecutor.setAccessToken(accessToken);
        xxlJobSpringExecutor.setTimeout(timeout);
        xxlJobSpringExecutor.setAppname(appName);
        xxlJobSpringExecutor.setAddress(executorAddress);
        xxlJobSpringExecutor.setLogPath(executorLogPath);

        return xxlJobSpringExecutor;
    }
}
