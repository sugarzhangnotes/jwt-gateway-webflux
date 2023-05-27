package com.sugarzhangnotes.http.api.gateway.service;

import java.util.concurrent.TimeUnit;

import com.sugarzhangnotes.http.api.gateway.dao.mapper.AppInfoMapper;
import com.sugarzhangnotes.http.api.gateway.model.AppInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
/**
* 应用服务
* 
* @author sugarzhangnotes
*/
@Service
public class AppInfoProvider {
    @Autowired
    AppInfoMapper appInfoMapper;
    
    //spring Caffeine cache
    Cache<String, AppInfo> cache = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .maximumSize(1000)
            .build();

    public AppInfo getAppInfoByAppKey(String appKey){
    		return cache.get(appKey, appInfoMapper::findByAppKey );
    }
}
