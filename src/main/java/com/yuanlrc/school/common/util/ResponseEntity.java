package com.yuanlrc.school.common.util;

import java.util.HashMap;

public class ResponseEntity extends HashMap<String, Object> {

    public static ResponseEntity success(String message){
        ResponseEntity response = new ResponseEntity();
        response.setSuccess(Boolean.TRUE);
        response.setMessage(message);
        return response;
    }

    public static ResponseEntity failure(String message){
        ResponseEntity response = new ResponseEntity();
        response.setSuccess(Boolean.FALSE);
        response.setMessage(message);
        return response;
    }

    public ResponseEntity setSuccess(Boolean success) {
        if (success != null) put("success", success);
        return this;
    }

    public ResponseEntity setMessage(String message) {
        if (message != null) put("message", message);
        return this;
    }

    public ResponseEntity setAny(String key, Object value) {
        if (key != null && value != null) put(key, value);
        return this;
    }
}
