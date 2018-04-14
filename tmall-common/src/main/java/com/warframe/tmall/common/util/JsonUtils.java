package com.warframe.tmall.common.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class JsonUtils {

	/**
	 * json字符串转换成map
	 * @param jsonStr
	 * @return
	 */
	public static Map<String, Object> changeJsonStr2Map(String jsonStr) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		if (StringUtils.isEmpty(jsonStr)) {
			return jsonMap;
		}
		
		JSONObject json = JSONObject.parseObject(jsonStr);
		
		return (Map<String, Object>)json;
	}
}
