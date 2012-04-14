/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.deltaspike.security.impl.credential;

import org.apache.deltaspike.security.api.authentication.event.LoginFailedEvent;
import org.apache.deltaspike.security.api.authentication.event.PostAuthenticateEvent;
import org.apache.deltaspike.security.api.credential.CredentialAuthInfo;
import org.apache.deltaspike.security.api.credential.LoginCredential;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;

/**
 * The default LoginCredential implementation.  This implementation allows for a
 * username and plain text password to be set, and uses the PasswordCredential
 * implementation of the CredentialAuthInfo interface for authentication.
 */
@Named("loginCredential")
@RequestScoped
public class DefaultLoginCredential implements LoginCredential
{
    private CredentialAuthInfo credentialAuthInfo;

    //private String userId;

    public CredentialAuthInfo getCredentialAuthInfo()
    {
        return credentialAuthInfo;
    }

    public void setCredentialAuthInfo(CredentialAuthInfo credentialAuthInfo)
    {
        this.credentialAuthInfo = credentialAuthInfo;
        //X TODO manager.fireEvent(new CredentialsUpdatedEvent(this.credentialAuthInfo));
    }

    public void invalidate()
    {
        this.credentialAuthInfo = null;
        //this.userId = null;
    }

    @Override
    public Boolean isValidUser(CredentialAuthInfo credentialAuthInfo) {
        //TODO must be refactored
        if(credentialAuthInfo != null && credentialAuthInfo.equals(this.credentialAuthInfo)){
            return true;
        }
        return false;
    }

    protected void setValid(@Observes PostAuthenticateEvent event)
    {
        invalidate();
    }

    protected void afterLogin(@Observes PostAuthenticateEvent event)
    {
        invalidate();
    }

    //X TODO discuss
    protected void loginFailed(@Observes LoginFailedEvent event)
    {
        invalidate();
    }

    @Override
    public String toString() 
    {
        return "LoginCredential[" + (this.credentialAuthInfo.getCredentialId() != null ? this.credentialAuthInfo.getCredentialId() : "unknown" ) + "]";
    }
}
