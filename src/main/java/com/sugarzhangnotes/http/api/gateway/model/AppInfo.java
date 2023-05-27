package com.sugarzhangnotes.http.api.gateway.model;

import lombok.Data;

/**
* app info model
* 
* @author sugarzhangnotes
*/
@Data
public class AppInfo {
    String appKey;
    //应用密钥
    String appSecret;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
}
