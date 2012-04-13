package org.apache.deltaspike.test.security.impl.authentication;

import org.apache.deltaspike.security.api.credential.UserAuthInfo;

public class TestUserAuthInfo implements UserAuthInfo<String> {

    private String userId;
    private String value;

    public TestUserAuthInfo(String userId, String value) {
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

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
