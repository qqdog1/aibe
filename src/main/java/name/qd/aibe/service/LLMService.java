package name.qd.aibe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import name.qd.aibe.config.AIBEException;
import name.qd.aibe.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LLMService {
    @Autowired
    private LMStudioConnector lmStudioConnector;

    public String getModels() throws AIBEException {
        return lmStudioConnector.getModels();
    }

    public String chatCompletions(String message) throws JsonProcessingException {
        String response = lmStudioConnector.chatCompletions(message);
        JsonNode node = JsonUtils.parseStringToNode(response);
        return node.get("choices").get(0).get("message").get("content").asText();
    }
}
