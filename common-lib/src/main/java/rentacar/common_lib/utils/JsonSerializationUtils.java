package rentacar.common_lib.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonSerializationUtils {

	/**
	 * The shared instance of the ObjectMapper class used for JSON serialization and
	 * deserialization. JavaTimeModule is used to allow work with Java 8 date types like LocalDate
	 */
	private static final ObjectMapper objectMapper  = new ObjectMapper().registerModule(new JavaTimeModule());

	/**
	 * Private constructor to prevent instantiation of the utility class.
	 */
	private JsonSerializationUtils() {
	}

	/**
	 * Serializes the given source object to JSON.
	 *
	 * @param source     The object to serialize.
	 * @param targetType The type reference representing the target type.
	 * @param <T>        The type of the source object.
	 * @return The JSON representation of the source object as a string.
	 * @throws JsonProcessingException
	 */
	public static <T> String serializeToJson(T source, TypeReference<T> targetType) throws JsonProcessingException {
		return objectMapper.writerFor(targetType).writeValueAsString(source);
	}

	/**
	 * Deserializes the given JSON string to an object of the specified target type.
	 *
	 * @param source The JSON string to deserialize.
	 * @param target The type reference representing the target type.
	 * @param <T>    The type of the target object.
	 * @return The deserialized object of the specified target type.
	 * @throws IOException 
	 */
	public static <T> T deserializeFromJson(String source, TypeReference<T> targetType)
			throws IOException {
		return objectMapper.readValue(source, targetType);
	}
	
	/**
	 * Converts the given object to an concrete object of model.
	 *
	 * @param source The object to convert.
	 * @param target The class which is target.
	 * @param <T>    The type of the target object.
	 * @return The converted object of the specified target type.
	 * @throws IOException 
	 */
	public static <T> T convertValue(Object source,  TypeReference<T> targetType)
			throws IOException {
		return objectMapper.convertValue(source, targetType);
	}
}
