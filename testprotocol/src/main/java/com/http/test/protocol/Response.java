/**
 * 
 */
package com.http.test.protocol;

/**
 * @Description: 协议响应
 **/
public class Response {
	
	/**
	 * 编码
	 */
	private byte encode;

	/**
	 * 响应长度
	 */
	private int responseLength;
	
	/**
	 * 响应
	 */
	private String response;

	public int getResponseLength() {
		return responseLength;
	}

	public void setResponseLength(int responseLength) {
		this.responseLength = responseLength;
	}


	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public byte getEncode() {
		return encode;
	}

	public void setEncode(byte encode) {
		this.encode = encode;
	}
	
}
