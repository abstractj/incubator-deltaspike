package org.apache.deltaspike.test.security.impl.authentication;

import org.apache.deltaspike.security.api.User;

public class TestUser implements User {

    private String username;
    private String password;

    public TestUser(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getUsername() {
        return username;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
