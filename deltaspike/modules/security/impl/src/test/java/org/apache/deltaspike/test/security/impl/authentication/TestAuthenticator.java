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
package org.apache.deltaspike.test.security.impl.authentication;

import org.apache.deltaspike.security.api.Credential;
import org.apache.deltaspike.security.api.credential.User;
import org.apache.deltaspike.security.api.credential.LoginCredential;
import org.apache.deltaspike.security.impl.authentication.UserCredential;
import org.apache.deltaspike.security.spi.authentication.BaseAuthenticator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class TestAuthenticator extends BaseAuthenticator
{
    @Inject
    private LoginCredential loginCredential;

    @Inject
    private Credential credential;

    @Override
    public void authenticate()
    {
        String password = InMemoryUserStorage.getPassword(this.loginCredential.getUser().getUserId());

        if (user != null && user.equals(this.loginCredential.getUser()))
        {
            setStatus(AuthenticationStatus.SUCCESS);
            this.credential.setUsername(this.loginCredential.getUser().getUserId());
            return;
        }

        setStatus(AuthenticationStatus.FAILURE);
    }

    @Override
    public Credential getCredential()
    {
        return this.credential;
    }

    void register(User user)
    {
        InMemoryUserStorage.setPassword(user);
    }
}
