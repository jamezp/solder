/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
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

package org.jboss.seam.solder.test.messages;

import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.jboss.seam.solder.test.util.Deployments.baseDeployment;
import static org.junit.Assert.assertEquals;

/**
 * Tests injection of typed message bundle injections.
 *
 * @author David Allen
 * @author Dan Allen
 */
@RunWith(Arquillian.class)
public class TypedMessageBundleInjectionTest {
    @Deployment
    public static Archive<?> createDeployment() {
        return baseDeployment()
                .addPackage(TypedMessageBundleInjectionTest.class.getPackage());
    }

    @Test
    public void testMessageBundleInjection(Jay jay) {
        assertEquals("Spotted 8 jays", jay.getMessage());
    }

    @Test
    public void testMessageBundleLocaleInjection(FrenchJay jay) {
        assertEquals("Spotted 4 geais", jay.getMessage());
    }
}
