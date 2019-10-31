package com.module.api.test;

import org.json.JSONException;

import com.alibaba.fastjson.JSONObject;

import junit.framework.TestCase;

public class AccountApiTest extends TestCase {

	public void testFindByNo() {
		String httpUrl = "http://localhost:9001/account/getAccount/B000001";
		String result = HttpClient.doGet(httpUrl);
		System.out.println(result);
	}

	public void testTransaction() throws JSONException {
		String httpUrl = "http://localhost:9001/account/transaction";
		JSONObject obj = new JSONObject();
		obj.put("accountNo", "B0000012");
		obj.put("amount", 123.00);
		String result = HttpClient.doPost(httpUrl, obj.toString());
		System.out.println(result);
	}

}
