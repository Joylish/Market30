package com.openhack.market30;

import com.android.volley.Response;
        import com.android.volley.toolbox.StringRequest;

        import java.lang.reflect.Method;
        import java.util.HashMap;
        import java.util.Map;

public class LoginRequest extends StringRequest {
    final static private String URL = "http://ec2-13-209-77-121.ap-northeast-2.compute.amazonaws.com:6001/";
    private Map<String, String> parameters;

    public LoginRequest(String userId, String userPwd, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        parameters = new HashMap<>();
        parameters.put("userId", userId);
        parameters.put("userPwd", userPwd);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}