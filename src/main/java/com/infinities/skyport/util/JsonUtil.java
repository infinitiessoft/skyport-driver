package com.infinities.skyport.util;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import com.infinities.skyport.JsonConstants;
import com.infinities.skyport.view.Views;

public class JsonUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	// private static ObjectMapper objectMapper = new ObjectMapper();
	private static final AnnotationIntrospectorPair jaxbAnnotationPair;

	static {
		AnnotationIntrospector introspector = new JaxbAnnotationIntrospector(TypeFactory.defaultInstance());
		// if using BOTH JAXB annotations AND Jackson annotations:
		AnnotationIntrospector secondary = new JacksonAnnotationIntrospector();
		jaxbAnnotationPair = new AnnotationIntrospectorPair(introspector, secondary);
	}


	public static ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper = objectMapper.setAnnotationIntrospector(jaxbAnnotationPair);
		// make deserializer use JAXB annotations (only)
		objectMapper = objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		objectMapper = objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		objectMapper.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
		return objectMapper;
	}

	public static String toJson(Object object) {
		return toJson(object, Views.Full.class);
	}

	public static String toJson(Object object, Class<? extends Views.Short> view) {
		ObjectMapper mapper = getObjectMapper();
		ObjectWriter writer = mapper.writerWithView(view).withDefaultPrettyPrinter();
		try {
			if (object == null || "".equals(object)) {
				object = mapper.createObjectNode();
			}
			return writer.writeValueAsString(object);
		} catch (Exception e) {
			logger.error("json parsing failed", e);
			throw new RuntimeException(e);
		}
	}

	public static String toJson(boolean insertResponseCode, String msg, Object object) {
		return toJson(insertResponseCode, msg, object, Views.Full.class);
	}

	public static String toJson(boolean insertResponseCode, Object object) {
		return toJson(insertResponseCode, object, Views.Full.class);
	}

	public static String toJson(boolean insertResponseCode, Object object, Class<? extends Views.Short> view) {
		return toJson(insertResponseCode, "", object, view);
	}

	public static String toJson(boolean insertResponseCode, String msg, Object object, Class<? extends Views.Short> view) {
		ObjectMapper mapper = getObjectMapper();
		ObjectWriter writer = mapper.writerWithView(view).withDefaultPrettyPrinter();
		JsonNode rootNode = mapper.createObjectNode();

		try {
			if (object == null || "".equals(object)) {
				object = mapper.createObjectNode();
			}

			String temp = writer.writeValueAsString(object);
			rootNode = mapper.readTree(temp);
		} catch (Exception e) {
			logger.error("json parsing failed", e);

		}

		ObjectNode root = getObjectMapper().createObjectNode();
		root.put(JsonConstants.STATUS, insertResponseCode ? 1 : 0).put(JsonConstants.MSG, msg)
				.put(JsonConstants._DATA, rootNode);

		try {
			return getObjectMapper().configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, false).writeValueAsString(
					root);
		} catch (Exception e) {
			logger.error("json parsing failed", e);
			throw new RuntimeException(e);
		}
	}

	public static String toJson(Throwable t) {
		ObjectNode root = getObjectMapper().createObjectNode();
		JsonNode empty = getObjectMapper().createObjectNode();
		root.put(JsonConstants.STATUS, 0).put(JsonConstants.MSG, t.getMessage()).put(JsonConstants._DATA, empty);

		try {
			return getObjectMapper().configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, false).writeValueAsString(
					root);
		} catch (Exception e) {
			logger.error("json parsing failed", e);
			throw new RuntimeException(e);
		}
	}

	public static String toLegendJson(boolean insertResponseCode, List<?> links, Collection<?> objects) {
		ObjectMapper mapper = JsonUtil.getObjectMapper();
		Map<String, Object> status = new HashMap<String, Object>();
		status.put(JsonConstants.RES, String.valueOf(insertResponseCode).toUpperCase());
		status.put(JsonConstants.LINKS, links);

		List<Object> objs = new ArrayList<Object>();
		objs.addAll(objects);
		objs.add(0, status);

		try {
			return mapper.writeValueAsString(objs);
		} catch (Exception e) {
			logger.error("json parsing failed", e);
			throw new RuntimeException(e);
		}
	}

	public static String toLegendJson(boolean insertResponseCode, List<?> links, Object object) {
		if (object instanceof Collection) {
			return toLegendJson(insertResponseCode, links, (Collection<?>) object);
		}
		List<Object> objects = new ArrayList<Object>();
		if (object != null) {
			objects.add(object);
		}

		return toLegendJson(insertResponseCode, links, objects);
	}

	public static String toLegendJson(boolean insertResponseCode, Collection<?> objects) {
		ObjectMapper mapper = JsonUtil.getObjectMapper();
		ObjectNode status = getObjectMapper().createObjectNode();
		status.put(JsonConstants.RES, String.valueOf(insertResponseCode).toUpperCase());

		List<Object> objs = new ArrayList<Object>();
		objs.addAll(objects);
		objs.add(0, status);

		try {
			return mapper.writeValueAsString(objs);
		} catch (Exception e) {
			logger.error("json parsing failed", e);
			throw new RuntimeException(e);
		}
	}

	public static String toLegendJson(boolean insertResponseCode, Object object) {
		if (object instanceof Collection) {
			return toLegendJson(insertResponseCode, (Collection<?>) object);
		}
		List<Object> objects = new ArrayList<Object>();
		if (object != null) {
			objects.add(object);
		}

		return toLegendJson(insertResponseCode, objects);
	}

	public static boolean getResult(String resText) throws IOException {
		final JsonNode jsonResult = readJson(resText);

		for (final Object obj : jsonResult) {
			if (obj instanceof JsonNode) {
				if (((JsonNode) obj).has(JsonConstants.RES)) {
					return "True".equalsIgnoreCase(((JsonNode) obj).get(JsonConstants.RES).textValue());
				}
			}
		}
		return false;
	}

	public static JsonNode getLegendNode(String resText) throws IOException {
		final JsonNode jsonResult = readJson(resText);
		return jsonResult;
	}

	public static JsonNode readJson(String resText) throws IOException {
		// workaround for amin's bug on some command

		final JsonNode rootNode = getObjectMapper().readTree(resText);
		return rootNode;
	}

	public static <T> T readJson(JsonNode fromValue, Class<T> toValueType) throws IOException {
		// workaround for amin's bug on some command
		return getObjectMapper().convertValue(fromValue, toValueType);
	}

	public static <T> T readJson(String fromValue, TypeReference<T> toValueType) throws IOException {
		return getObjectMapper().readValue(fromValue, toValueType);
	}

	public static <T> T readJson(String fromValue, Class<T> toValueType) throws IOException {
		return getObjectMapper().readValue(fromValue, toValueType);
	}

	public static <T> T readJson(File file, Class<T> toValueType) throws IOException {
		return getObjectMapper().readValue(file, toValueType);
	}

	public static String toLegendJson(Throwable e) {
		StringWriter wtr = new StringWriter();
		try {
			JsonGenerator g = new JsonFactory().createGenerator(wtr);
			g.writeStartArray();
			g.writeStartObject();
			g.writeStringField("RES", "FALSE");
			g.writeStringField("REASON", e.toString());
			// g.writeStringField("REASON", Objects.firstNonNull(e.getMessage(),
			// e.toString()));
			g.writeEndObject();
			g.writeEndArray();
			g.close();
		} catch (Exception ee) {
			ArrayNode array = getObjectMapper().createArrayNode();
			ObjectNode reason = getObjectMapper().createObjectNode();
			ObjectNode status = getObjectMapper().createObjectNode();

			status.put(JsonConstants.STATUS, String.valueOf("FALSE"));
			reason.put(JsonConstants.REASON, "an unexpected error occurred");
			array.add(status).add(reason);

			// "[{\"RES\":\"FALSE\"}, {\"REASON\":\"an unexpected error occurred\"}]";
			return array.toString();
		}

		return wtr.toString();
	}

	// public static <T> T convertValue(Object fromValue, Class<T> toValueType)
	// throws JsonParseException,
	// JsonMappingException, IOException {
	// return getObjectMapper().convertValue(fromValue, toValueType);
	// }

	public static <T> T readValue(String fromValue, Class<T> toValueType) throws JsonParseException, JsonMappingException,
			IOException {
		return getObjectMapper().readValue(fromValue, toValueType);
	}

	public static String toString(Object fromValue) throws IOException {
		return getObjectMapper().writeValueAsString(fromValue);
	}

	private JsonUtil() {
		super();
	}

}
