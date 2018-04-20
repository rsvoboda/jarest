/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2018, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.eap.qa.jarest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Configuration {
    private static Configuration instance;

    public synchronized static Configuration get() {
        if (instance != null) {
            return instance;
        }

        instance = new Configuration();
        return instance;
    }

    private Configuration() {
    }

    // TODO consider PathMatcher
    public Set<String> expectedMRv9JarNames() {
        return Set.of(
                // TODO double-check
                "wildfly-elytron-tool.jar",
                "jboss-cli-client.jar",
                "jboss-client.jar",
                "openjdk-orb-",
                // from MR JAR Support in JBoss Parent document:
                "jboss-modules.jar",
                "jboss-logmanager-",
                "wildfly-common-",
                "jboss-marshalling-2"  // vs. jboss-marshalling-river-2.0.4.Final.jar
        );
    }

    public Map<String, String> expectedAutomaticModuleNames() {
        Map<String, String> map = new HashMap<>(20);

        map.put("jboss-annotations-api_1.2_spec", "beta.jboss.annotation.api_1_2");
        map.put("jboss-annotations-api_1.3_spec", "beta.jboss.annotation.api_1_3");
        map.put("jboss-batch-api_1.0_spec", "beta.jboss.batch.api_1_0");
        map.put("jboss-concurrency-api_1.0_spec", "beta.jboss.concurrency.api_1_0");
        map.put("jboss-connector-api_1.7_spec", "beta.jboss.connector.api_1_7");
        map.put("jboss-ejb-api_3.2_spec", "beta.jboss.ejb.api_3_2");
        map.put("jboss-el-api_3.0_spec", "beta.jboss.el.api_3_0");
        map.put("jboss-interceptors-api_1.2_spec", "beta.jboss.interceptor.api_1_2");
        map.put("jboss-j2eemgmt-api_1.1_spec", "beta.jboss.j2eemgmt.api_1_1");
        map.put("jboss-jacc-api_1.5_spec", "beta.jboss.jacc.api_1_5");
//        map.put("jboss-jad-api_spec", "beta.jboss.jad.api_1_2");
        map.put("jboss-jaspi-api_1.1_spec", "beta.jboss.jaspi.api_1_1");
        map.put("jboss-jaxb-api_2.2_spec", "java.xml.bind");
        map.put("jboss-jaxb-api_2.3_spec", "java.xml.bind");
//        map.put("jboss-jaxr-api_spec", "beta.jboss.jaxr.api_1.0");
        map.put("jboss-jaxrpc-api_1.1_spec", "beta.jboss.jaxrpc.api_1.1");
        map.put("jboss-jaxrs-api_2.0_spec", "beta.jboss.jaxrs.api_2_0");
        map.put("jboss-jaxrs-api_2.1_spec", "beta.jboss.jaxrs.api_2_1");
        map.put("jboss-jaxws-api_2.2_spec", "beta.jboss.jaxws.api_2_2");
        map.put("jboss-jms-api_2.0_spec", "beta.jboss.jms.api_2_0");
        map.put("jboss-jsf-api_2.2_spec", "beta.jboss.jsf.api_2_2");

//        map.put("jboss-json-api_spec", "beta.jboss.json.api_1_0");
//        JSON-B
//        find dist/target/wildfly-13.0.0.Alpha1-SNAPSHOT/ | grep json | grep jar$ | grep api
//        dist/target/wildfly-13.0.0.Alpha1-SNAPSHOT//modules/system/layers/base/javax/json/api/main/javax.json-api-1.1.2.jar
//        dist/target/wildfly-13.0.0.Alpha1-SNAPSHOT//modules/system/layers/base/javax/json/bind/api/main/javax.json.bind-api-1.0.jar

        map.put("jboss-jsp-api_2.3_spec", "beta.jboss.jsp.api_2_3");

//        map.put("jboss-jstl-api_spec", "beta.jboss.jstl.api_1_2");
//        find dist/target/wildfly-13.0.0.Alpha1-SNAPSHOT/ | grep jstl | grep jar$ | grep api
//        dist/target/wildfly-13.0.0.Alpha1-SNAPSHOT//modules/system/layers/base/javax/servlet/jstl/api/main/taglibs-standard-compat-1.2.6-RC1.jar
//        dist/target/wildfly-13.0.0.Alpha1-SNAPSHOT//modules/system/layers/base/javax/servlet/jstl/api/main/taglibs-standard-spec-1.2.6-RC1.jar
//        dist/target/wildfly-13.0.0.Alpha1-SNAPSHOT//modules/system/layers/base/javax/servlet/jstl/api/main/taglibs-standard-impl-1.2.6-RC1.jar

//        map.put("jboss-rmi-api_spec", "beta.jboss.rmi.api_1_0");
        map.put("jboss-saaj-api_1.3_spec", "beta.jboss.saaj.api_1_3");
        map.put("jboss-servlet-api_3.1_spec", "beta.jboss.servlet.api_3_1");
        map.put("jboss-servlet-api_4.0_spec", "beta.jboss.servlet.api_4_0");
        map.put("jboss-transaction-api_1.2_spec", "java.transaction");
        map.put("jboss-websocket-api_1.1_spec", "beta.websocket.api_1_1");
        map.put("hibernate-jpa-2.1-api", "java.persistence");

        return Collections.unmodifiableMap(map);
    }
}
