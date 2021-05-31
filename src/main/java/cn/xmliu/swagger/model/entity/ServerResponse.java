package cn.xmliu.swagger.model.entity;

import java.util.HashMap;

public class ServerResponse extends HashMap<String, Object> {

    public static final int STATUS_OK = 200;
    public static final int STATUS_ERROR = 500;
    public ServerResponse() {
        put("code", STATUS_OK);
    }

    public static ServerResponse error(String msg) {
        return error(STATUS_ERROR, msg);
    }
    public static ServerResponse error(int code, String msg) {
        ServerResponse r = new ServerResponse();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }
    public static ServerResponse success(String msg) {
        ServerResponse r = new ServerResponse();
        r.put("msg", msg);
        return r;
    }

    public static ServerResponse success() {
        return new ServerResponse();
    }

    @Override
    public ServerResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
