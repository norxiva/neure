package plujezi.neure.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class JacksonUtils {

    private static final ObjectMapper DEFAULT_OBJECT_MAPPER = objectMapper();

    private static ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module());
        objectMapper.registerModule(new GuavaModule());
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(new JodaModule());

        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        return objectMapper;
    }

    public static String writeValueAsString(Object value){
        try {
            return DEFAULT_OBJECT_MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            log.error("Failed to convert the object {} to json string!", value);
            throw new IllegalArgumentException("Failed to convert the object" + value.toString()
                    + "to json string", e);
        }
    }

    public static <T> T readValue(String content, Class<T> valueType){
        try {
            return DEFAULT_OBJECT_MAPPER.readValue(content, valueType);
        } catch (IOException e) {
            log.error("Failed to parse text " + content + " with error ", e);
            throw new IllegalArgumentException("Error parsing \'" + content
                    + "\' with error", e);
        }
    }
}
