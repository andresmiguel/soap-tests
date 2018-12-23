package com.ambh.ws.soap.utclient.service;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

@Component
public class UTPasswordCallback implements CallbackHandler {

    @Value("${paymentServiceUsername}")
    private String username;
    @Value("${paymentServicePassword}")
    private String password;

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            WSPasswordCallback wsPasswordCallback = (WSPasswordCallback) callback;
            if (wsPasswordCallback.getIdentifier().equals(username)) {
                wsPasswordCallback.setPassword(password);
                break;
            }
        }
    }
}
