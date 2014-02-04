/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.rest.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.lang.model.type.NullType;

import org.jclouds.http.functions.ParseXMLWithJAXB;

/**
 * Shows the transformer type used to parse XML with the
 * {@link ParseXMLWithJAXB} parser in a HttpResponse.
 * 
 * @author Ignasi Barrera
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface JAXBResponseParser {

   /**
    * If present, this is the class that will be used to unmarshal the XML
    * document. If omitted, the return type of the annotated method will be
    * used.
    */
   Class<?> value() default NullType.class;
}