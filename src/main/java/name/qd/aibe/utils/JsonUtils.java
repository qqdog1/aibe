package name.qd.aibe.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String parseObjectToString(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public static JsonNode parseStringToNode(String data) throws JsonProcessingException {
        return objectMapper.readTree(data);
    }

    public static ArrayNode getArrayNode() {
        return objectMapper.createArrayNode();
    }

    public static ObjectNode getObjectNode() {
        return objectMapper.createObjectNode();
    }
}
