package com.zjf.admin.acutuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class AppInfoContributor implements InfoContributor {


    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("msg","你好").withDetail("hello","world");

    }
}
