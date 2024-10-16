package com.tencent.wxcloudrun.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.CounterRequest;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.*;

/**
 * counter控制器
 */
@RestController

public class CounterController {

    @Resource
    private HttpServletRequest httpServletRequest;

    final CounterService counterService;
    final Logger logger;

    public CounterController(@Autowired CounterService counterService) {
        this.counterService = counterService;
        this.logger = LoggerFactory.getLogger(CounterController.class);
    }


    /**
     * 获取当前计数
     *
     * @return API response json
     */
    @GetMapping(value = "/api/count")
    ApiResponse get() {
        HttpRequest post = HttpUtil.createPost("https://shops-go.paquapp.com/miniapp/v2/sg/order/create");
        post.body("{}");
        post.header("x-wx-ob-env", "appservice");
        post.header("x-wx-ob-sdkversion", "3.4.10");
        post.header("x-wx-ob-pack-version", "2.0");
//            post.header("x-cloudbase-phone", baseUserInfo.getMobile());
        post.header("x-wx-ob-project-key", "wx9627eb7f4b1c69d5");
        post.header("x-wx-platform", "ios");
//            post.header("x-real-ip", value);
//            post.header("x-real-ipv6", "2409:8a28:c25:2e04:6020:f535:90ab:728a");
        post.header("x-cloudbase-version", "pop");
//            post.header("x-original-forwarded-for", "2409:8a28:c25:2e04:6020:f535:90ab:728a");
        post.header("x-scheme", "https");
        post.header("x-forwarded-proto", "https");
        post.header("x-forwarded-port", "443");
        post.header("x-forwarded-host", "a0c89d6ac-wxe17e6efa4c656fcd.tj.wxgateway.com");
//            post.header("Identity_Code", baseUserInfo.getAuthToken());
//            post.header("x-wx-open-id", baseUserInfo.getAuthToken());
//            post.header("x-wx-openId", baseUserInfo.getAuthToken());
//            post.header("x-wx-service", "pop");
//            post.header("x-cloudbase-trace", "ODcwYTgyYzMxOTBmNGRmZGExNjc0MDFhOTNlMmY2OGEsMjgzNGQ4NDRiYWY4NDQwNjljZTc1OTVlZDMzZjdkNjEsb24=");
        post.header("x-cloudbase-timestamp", System.currentTimeMillis()/1000+"");
//            post.header("x-cloudbase-sessiontoken", "cxBUMYNM9BvHuP41tgvDJgXmOtSRbMwabb3871a295eec17a70a9bcab84f9fb639Mi3d-izb3CUGOVLhBOyFMigxQfDWFH8mS4L-TkOeqms7vpPRJ7n5Fs7gYOyjw0Ugmw20lSEBweaGiM81HeEtImwLmXwMepfubClkQkNAXOSBPchIGDiyRyRBQhB4gFu8x9E7dNeyHjxPDzd3qhtYl8sqiWnMPtkJuYIVwiAyj3yRwWp71vATjvBjgtC0EWcTCqenVHUkkOFskI8-uXlvGyG3_qsimqbrNCFzH6IMCJoWEmtqAQO1z1yMh4wt3-pxfvFHINKerewT93w1uz-bNxi7BeGKWJNKIpZ7ZyjuZV2T-2D_p0ftEkxnAEhY1DWq03F2FWFveWs5dOMTfmzKNQLQCmlhOliRyuSBEZ-p2sRhUfGoBuSutsa_yYk_bpf");
        post.header("x-cloudbase-request-id", UUID.randomUUID().toString());
//            post.header("x-cloudbase-context", "H4sIAAAAAAAA/4yPsWrDMBBA/+XmuJwk25I9JtBQKCl0KMFLcaQjce1KrqTYgpB/L/bSoRS63r17vLsB2enJQA2jdybDc3+xVeoZV4yXQsAGrp2FGhgiCqWUlKJahoH8euU+mvZZHpvXXXPab/dKp+3hJT322+OkYQOB/NRpOrSfBDWE0Xf2fHIuZl++iD/7N/Khc/Y3kiEuDcFdvV4Mc3o3NEXnhgAbmElf2rhzNlKKUN9At8OwZjHJVSFZUUqR8wwfuMgRGeYqF5UQ5d9KN5L9z2PtOK7YnIwpKy4IUZq8KiSD+/07AAD//xlU/z5VAQAA");
//            post.header("x-cloudbase-authorization", "1.0.0 TC3-HMAC-SHA256 Credential=AKIDx-j2hokFfZUKHzV-oZcBi49xcLASexU62Il4Rmc8cLUaf9u9WEbXqmNOqgRHbm8P/2024-10-10/tcb/tc3_request, SignedHeaders=content-type;host, Signature=46428f5a92170906fb14b5dc3ba0ee8a1889c461ed73840a75b8c4c935a9791e");
//            post.header("forwarded", "for=1.116.111.121; host=a0c89d6ac-wxe17e6efa4c656fcd.tj.wxgateway.com");
        post.header("x-forwarded", "a0c89d6ac-wxe17e6efa4c656fcd.tj.wxgateway.com");
        post.header("x-wx-call-id", "v2-" + System.currentTimeMillis() + "-" + RandomUtil.randomString(8));
        post.header("x-wx-appid", "wx9627eb7f4b1c69d5");
        post.header("x-cloudbase-timestamp-ms", System.currentTimeMillis() + "");
        post.header("x-wx-include-credentials", "openid, unionid");
        post.header("X-WX-REGION", "ap-shanghai");
        post.header("X-WX-GATEWAY-ID", "prod-popvip-go-4gvvjhghd014a5fb");
        post.header("X-WX-HTTP-HOST", "a0c89d6ac-wxe17e6efa4c656fcd.tj.wxgateway.com");
        post.header("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 14_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 MicroMessenger/8.0.48(0x18003030) NetType/WIFI Language/zh_CN MiniProgramEnv/iOS");
        post.header("referer", "https://servicewechat.com/wx9627eb7f4b1c69d5/668/page-frame.html");
        String body = post.execute().body();
        logger.info("ppmt请求返回:{}",body);
        logger.info("/api/count get request");
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = httpServletRequest.getHeader(key);
            logger.info("header:{},value:{}", key, value);
        }
        logger.info("/api/count get request,header:{}", headerNames);
        Optional<Counter> counter = counterService.getCounter(1);
        Integer count = 0;
        if (counter.isPresent()) {
            count = counter.get().getCount();
        }

        return ApiResponse.ok(count);
    }


    /**
     * 更新计数，自增或者清零
     *
     * @param request {@link CounterRequest}
     * @return API response json
     */
    @PostMapping(value = "/api/count")
    ApiResponse create(@RequestBody CounterRequest request) {
        logger.info("/api/count post request, action: {}", request.getAction());

        Optional<Counter> curCounter = counterService.getCounter(1);
        if (request.getAction().equals("inc")) {
            Integer count = 1;
            if (curCounter.isPresent()) {
                count += curCounter.get().getCount();
            }
            Counter counter = new Counter();
            counter.setId(1);
            counter.setCount(count);
            counterService.upsertCount(counter);
            return ApiResponse.ok(count);
        } else if (request.getAction().equals("clear")) {
            if (!curCounter.isPresent()) {
                return ApiResponse.ok(0);
            }
            counterService.clearCount(1);
            return ApiResponse.ok(0);
        } else {
            return ApiResponse.error("参数action错误");
        }
    }

}