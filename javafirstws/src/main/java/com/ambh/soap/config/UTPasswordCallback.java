package com.ambh.soap.config;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;
import java.util.Map;

public class UTPasswordCallback implements CallbackHandler {

    private Map<String, String> passwords = new HashMap<>();

    public UTPasswordCallback() {
        passwords.put("andres", "a");
    }

    @Override
    public void handle(Callback[] callbacks) {
        for (Callback callback : callbacks) {
            WSPasswordCallback wsPasswordCallback = (WSPasswordCallback) callback;
            if (passwords.containsKey(wsPasswordCallback.getIdentifier())) {
                wsPasswordCallback.setPassword(passwords.get(wsPasswordCallback.getIdentifier()));
                break;
            }
        }
    }
}
