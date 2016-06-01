package com.ctt.json;
import net.sf.json.JSONObject;
public class JsonTools {
	public JsonTools() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param key
	 *            表示json字符串的头信息
	 * @param value
	 *            是对解析的集合的类型
	 * @return 
	 * @return
	 */
	//将数据转换为Json
	public static String createJsonString(String key,Object value) {
		// TODO Auto-generated method stub
		JSONObject jsonObject=new JSONObject();
		jsonObject.put(key,value);		
		return jsonObject.toString();
	}
}
