/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
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
package org.jboss.arquillian.container.android.managed.impl;

import java.io.File;

import org.jboss.arquillian.container.android.managed.configuration.AndroidContainerConfigurationException;

/**
 * Simple validation utility
 * 
 * @author <a href="@mailto:kpiwko@redhat.com">Karel Piwko</a>
 * 
 */
class Validate {

    public static void stateNotNull(Object object, String message) throws IllegalStateException {
        if (object == null) {
            throw new IllegalStateException(message);
        }
    }

    /**
     * Checks that object is not null, throws exception if it is.
     * 
     * @param obj The object to check
     * @param message The exception message
     * @throws IllegalArgumentException Thrown if obj is null
     */
    public static void notNull(final Object obj, final String message) throws AndroidContainerConfigurationException {
        if (obj == null) {
            throw new AndroidContainerConfigurationException(message);
        }
    }

    /**
     * Checks that the specified String is not null or empty, throws exception if it is.
     * 
     * @param string The object to check
     * @param message The exception message
     * @throws AndroidContainerConfigurationException Thrown if string is null
     */
    public static void notNullOrEmpty(final String string, final String message) throws AndroidContainerConfigurationException {
        if (string == null || string.length() == 0) {
            throw new AndroidContainerConfigurationException(message);
        }
    }

    /**
     * Checks that at least one of specified String is not empty
     * 
     * @param strings The array of strings to be checked
     * @param message The exception message
     * @throws AndroidContainerConfigurationException Throws if all strings are null or empty
     */
    public static void notAllNullsOrEmpty(final String[] strings, final String message)
            throws AndroidContainerConfigurationException {
        for (String string : strings) {
            if (string != null && string.trim().length() != 0) {
                return;
            }
        }

        throw new AndroidContainerConfigurationException(message);
    }

    /**
     * Checks that the specified String is not null or empty and represents a readable file, throws exception if it is empty or
     * null and does not represent a path to a file.
     * 
     * @param path The path to check
     * @param message The exception message
     * @throws AndroidContainerConfigurationException Thrown if path is empty, null or invalid
     */
    public static void isReadable(final String path, String message) throws AndroidContainerConfigurationException {
        notNullOrEmpty(path, message);
        File file = new File(path);
        isReadable(file, message);
    }

    /**
     * Checks that the specified File is not null or empty and represents a readable file, throws exception if it is empty or
     * null and does not represent a path to a file.
     * 
     * @param file The file to check
     * @param message The exception message
     * @throws IllegalArgumentException Thrown if file is null or invalid
     */
    public static void isReadable(final File file, String message) throws IllegalArgumentException {
        if (file == null) {
            throw new IllegalArgumentException(message);
        }
        if (!file.exists() || !file.canRead()) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Checks that the specified String is not null or empty and represents a readable directory, throws exception if it is
     * empty or null and does not represent a path to a directory.
     * 
     * @param path The path to check
     * @param message The exception message
     * @throws IllegalArgumentException Thrown if path is empty, null or invalid
     */
    public static void isReadableDirectory(final String path, String message) throws AndroidContainerConfigurationException {
        notNullOrEmpty(path, message);
        File file = new File(path);
        isReadableDirectory(file, message);
    }

    /**
     * Checks that the specified file is not null and represents a readable directory, throws exception if it is empty or null
     * and does not represent a directory.
     * 
     * @param file The path to check
     * @param message The exception message
     * @throws AndroidContainerConfigurationException Thrown if file is null or invalid
     */
    public static void isReadableDirectory(final File file, String message) throws AndroidContainerConfigurationException {
        if (file == null) {
            throw new AndroidContainerConfigurationException(message);
        }
        if (!file.exists() || !file.isDirectory() || !file.canRead() || !file.canExecute()) {
            throw new AndroidContainerConfigurationException(message);
        }
    }

    public static void sdSize(String sdSize, String message) throws AndroidContainerConfigurationException {
        if (sdSize != null && !sdSize.matches("\\d{1,3}M")) {
            throw new AndroidContainerConfigurationException(message);
        }
    }

}
