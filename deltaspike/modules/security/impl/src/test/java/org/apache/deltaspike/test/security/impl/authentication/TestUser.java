package org.apache.deltaspike.test.security.impl.authentication;

import org.apache.deltaspike.security.api.credential.User;

public class TestUser implements User<String> {

    private String userId;
    private String value;

    public TestUser(String userId, String value) {
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
