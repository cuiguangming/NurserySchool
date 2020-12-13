package com.nursery.common.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Result<TData> implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	public enum Type {
		unknown(-1), info(0), warn(1), error(2), fatal(4);

		//
		private int value = -1;

		Type(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}
	}

	// 原始请求信息
	public Integer requestCode = -1;
	public String requestCodeName = null;
	// 结果信息
	public Type type = Type.info;
	public Integer code = 0;
	public String codeName = null;
	public String token = null;
	public String message = null;
	public TData data = null;

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Result [");
		if (requestCode != null && -1 != requestCode) {
			builder.append("requestCode = " + requestCode);
			builder.append(", requestCodeName = " + requestCodeName);
			builder.append(", ");
		}
		builder.append("type = " + type);
		builder.append(", code = " + code);
		builder.append(", codeName = " + codeName);
		builder.append(", token = " + token);
		builder.append(", message = " + message);
		builder.append(", data = " + data);
		builder.append("]");
		return builder.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> retMap = new LinkedHashMap<String, Object>();
		//
		if (this.requestCode != null) {
			retMap.put("requestCode", requestCode);
		}
		if (this.requestCodeName != null) {
			retMap.put("requestCodeName", requestCodeName);
		}
		if (this.code != null) {
			retMap.put("code", code);
		}
		if (this.codeName != null) {
			retMap.put("codeName", codeName);
		}
		if (this.token != null) {
			retMap.put("token", token);
		}
		//
		retMap.put("type", type);
		retMap.put("message", message);
		retMap.put("data", data);
		//
		return retMap;
	}

	public Result<TData> echo() {
		System.out.println(this.toString());
		//
		return this;
	}

	public static <TData> Result<TData> newOne() {
		return new Result<TData>();
	}
}
