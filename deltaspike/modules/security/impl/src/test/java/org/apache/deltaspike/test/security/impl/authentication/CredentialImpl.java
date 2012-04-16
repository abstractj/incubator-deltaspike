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

import javax.enterprise.inject.Model;

@Model
public class CredentialImpl implements Credential<Object>
{
    private Object username;
    private Object password;

    public CredentialImpl()
    {
    }

    public CredentialImpl(Object username)
    {
        this.username = username;
    }

    @Override
    public void setPassword(Object password)
    {
        this.password = password;
    }

    @Override
    public void setUsername(Object username)
    {
        this.username = username;
    }

    @Override
    public Object getPassword()
    {
        return password;
    }

    @Override
    public Object getUsername()
    {
        return username;
    }
}
