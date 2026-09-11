package com.thinkitive.demo.dto.response;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.thinkitive.demo.util.ResponseStatus;


@JsonPropertyOrder({ "code", "message", "path", "data", "localDateTime", "requestId", "success", "version" })

public class StandardResponse<T> {

	private boolean success;

	private String message;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private T data;

	private LocalDateTime localDateTime;

	private String requestId;

	private String path;
	private String version;
	private ResponseStatus code;
//	private String code;

//	public void setCode(String code) {
//		this.code = code;
//	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ResponseStatus getCode() {
		return code;
	}

	public void setCode(ResponseStatus code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "StandardResponse [success=" + success + ", message=" + message + ", data=" + data + ", localDateTime="
				+ localDateTime + ", requestId=" + requestId + ", path=" + path + ", version=" + version + ", code="
				+ code + "]";
	}

	public StandardResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static <T> StandardResponse<T> data(String requestId, String message, T data, ResponseStatus code,String path) {

		StandardResponse<T> response = new StandardResponse<>();
		response.setRequestId(requestId);
		response.setMessage(message);
		response.setCode(code);
		response.setSuccess(true);
		response.setLocalDateTime(LocalDateTime.now());
		response.setData(data);
		response.setVersion("1.0.0");
		response.setPath(path);
		return response;
	}

	public static<T> StandardResponse<T> suceess(String requestId, String message, ResponseStatus code,String path) {

		StandardResponse<T> response = new StandardResponse<>();
		response.setRequestId(requestId);
		response.setMessage(message);
		response.setCode(code);
		response.setSuccess(true);
		response.setLocalDateTime(LocalDateTime.now());
		response.setVersion("1.0.0");
		response.setPath(path);
		
		return response;
	}
	
	public static<T> StandardResponse<T> error(String requestId,String message ,ResponseStatus code,String path){
		StandardResponse<T> standardResponse = new StandardResponse<>();
		standardResponse.setRequestId(requestId);
		standardResponse.setMessage(message);
		standardResponse.setCode(code);
		standardResponse.setSuccess(false);
		standardResponse.setLocalDateTime(LocalDateTime.now());
		standardResponse.setVersion("1.0.0");
		standardResponse.setPath(path);
		return standardResponse;
	}

}
