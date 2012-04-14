package org.apache.deltaspike.test.security.impl.authentication;

import org.apache.deltaspike.security.api.credential.CredentialAuthInfo;

public class TestCredentialAuthInfo implements CredentialAuthInfo<String> {

    private String userId;
    private String value;

    public TestCredentialAuthInfo(String userId, String value) {
        this.userId = userId;
        this.value = value;
    }

    @Override
    public String getCredentialId() {
        return userId;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setCredentialId(String credentialId) {
        this.userId = credentialId;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
