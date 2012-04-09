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

package org.apache.deltaspike.core.api.exception.control;

import java.lang.annotation.*;

/**
 * Marker annotation for a method to be considered an Exception Handler. Handlers are typically in the form of
 * <code>public void ... (@Handles ... CaughtException<...> ...)</code> methods. If a method has a return type, it is
 * ignored.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
public @interface Handles
{
    /**
     * Precedence relative to handlers for the same type
     */
    public abstract int ordinal() default 0; //TODO discuss Precedence
}