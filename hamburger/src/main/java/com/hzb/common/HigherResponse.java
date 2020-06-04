package com.hzb.common;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

/**
 * 
 * 封装高复用响应对象
 *
 */
@Data
@JsonInclude(value=Include.NON_NULL)
public class HigherResponse<T> {

	private Integer status;
	private T data;
	private String msg;

	private HigherResponse() {

	}

	private HigherResponse(Integer status) {

		this.status = status;
	}

	private HigherResponse(Integer status, T t) {

		this.status = status;
		this.data = t;
	}

	private HigherResponse(Integer status, String msg) {

		this.status = status;
		this.msg = msg;
	}

	private HigherResponse(Integer status, String msg, T t) {

		this.status = status;
		this.msg = msg;
		this.data = t;
	}
	
	
	

	/**
	 * 提供对外公开的方法
	 */

	// success
	@JsonIgnore
	public boolean isResponseSuccess() {

		return this.status == StatusUtil.SUCCESSSTATUS;
	}

	public static HigherResponse getResponseSuccess() {

		return new HigherResponse(StatusUtil.SUCCESSSTATUS);
	}

	public static HigherResponse getResponseSuccess(String msg) {

		return new HigherResponse(StatusUtil.SUCCESSSTATUS, msg);
	}

	public static <T> HigherResponse getResponseSuccess(T t) {

		return new HigherResponse(StatusUtil.SUCCESSSTATUS, t);
	}

	public static <T> HigherResponse getResponseSuccess(String msg, T t) {

		return new HigherResponse(StatusUtil.SUCCESSSTATUS, msg, t);
	}

	// Failed
	@JsonIgnore 
	public boolean isResponseFailed() {

		return this.status == StatusUtil.FAILESTATUS;
	}

	// 失败方法
	public static HigherResponse getResponseFailed() {

		return new HigherResponse(StatusUtil.FAILESTATUS);
	}

	public static HigherResponse getResponseFailed(String msg) {

		return new HigherResponse(StatusUtil.FAILESTATUS, msg);
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
