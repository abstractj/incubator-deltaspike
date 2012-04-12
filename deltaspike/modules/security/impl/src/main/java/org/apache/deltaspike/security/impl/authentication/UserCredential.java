package org.apache.deltaspike.security.impl.authentication;

import org.apache.deltaspike.security.api.Credential;

public class UserCredential implements Credential<Object> {

    private Object username;
    private Object password;

    public UserCredential(Object username) {
        this.username = username;
    }

    @Override
    public void setPassword(Object password) {
        this.password = password;
    }

    @Override
    public void setUsername(Object username) {
        this.username = username;
    }

    @Override
    public Object getPassword() {
        return password;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getUsername() {
        return username;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
