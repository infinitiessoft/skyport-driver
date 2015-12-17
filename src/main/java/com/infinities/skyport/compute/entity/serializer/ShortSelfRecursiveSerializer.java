package com.infinities.skyport.compute.entity.serializer;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.infinities.skyport.util.JsonUtil;
import com.infinities.skyport.view.Views;

public class ShortSelfRecursiveSerializer extends JsonSerializer<Serializable> implements Serializable {

	// private static final Logger logger =
	// LoggerFactory.getLogger(SelfRecursiveSerializer.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public void serialize(Serializable value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
			JsonGenerationException {

		ObjectMapper mapper = JsonUtil.getObjectMapper();

		ObjectWriter writer = mapper.writerWithView(Views.Short.class);
		StringWriter sw = new StringWriter();
		writer.writeValue(sw, value);

		JsonNode rootNode = mapper.readTree(sw.toString());

		jgen.writeObject(rootNode);

	}

}
