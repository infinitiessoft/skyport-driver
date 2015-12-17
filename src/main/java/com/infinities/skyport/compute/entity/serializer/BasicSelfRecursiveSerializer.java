/*******************************************************************************
 * Copyright 2015 InfinitiesSoft Solutions Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package com.infinities.skyport.compute.entity.serializer;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Collection;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.infinities.skyport.util.JsonUtil;
import com.infinities.skyport.view.Views;

public class BasicSelfRecursiveSerializer extends JsonSerializer<Collection<?>> implements Serializable {

	// private static final Logger logger =
	// LoggerFactory.getLogger(SelfRecursiveSerializer.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public void serialize(Collection<?> value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
			JsonGenerationException {

		ObjectMapper mapper = JsonUtil.getObjectMapper();

		ObjectWriter writer = mapper.writerWithView(Views.Basic.class);
		StringWriter sw = new StringWriter();
		writer.writeValue(sw, value);

		JsonNode rootNode = mapper.readTree(sw.toString());

		jgen.writeObject(rootNode);

	}

}
