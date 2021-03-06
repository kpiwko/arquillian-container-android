/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.arquillian.container.android.managed.configuration;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Finds out some random string in order to provide some name for AVD.
 * 
 * @author <a href="mailto:smikloso@redhat.com">Stefan Miklosovic</a>
 */
public final class AVDIdentifierGenerator {

    private static final int NUM_BITS = 130;

    private static final int RADIX = 30;

    private static final SecureRandom random = new SecureRandom();

    public static String getRandomAVDName() {
        return new BigInteger(NUM_BITS, random).toString(RADIX);
    }
}
