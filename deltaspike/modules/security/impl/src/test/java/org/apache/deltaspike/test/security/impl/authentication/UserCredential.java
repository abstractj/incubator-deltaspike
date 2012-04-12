package org.apache.deltaspike.test.security.impl.authentication;

import org.apache.deltaspike.security.api.credential.Credential;

public class UserCredential implements Credential {

    private String userId;
    private String value;

    public UserCredential(String userId, String value) {
        this.userId = userId;
        this.value = value;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public String getValue() {
        return value;
    }
}
