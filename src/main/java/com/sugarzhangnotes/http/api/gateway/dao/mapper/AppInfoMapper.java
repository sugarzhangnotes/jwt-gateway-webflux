package com.sugarzhangnotes.http.api.gateway.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.sugarzhangnotes.http.api.gateway.model.AppInfo;
/**
* 接入网关的应用信息mapper
* 
* @author sugarzhangnotes
*/
@Mapper
public interface AppInfoMapper {
    @Select("SELECT app_key appKey,app_secret appSecret FROM thirdparty_app_info WHERE app_key = #{appKey}")
    AppInfo findByAppKey(@Param("appKey") String appKey);

}