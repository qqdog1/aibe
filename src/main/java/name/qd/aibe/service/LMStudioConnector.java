package name.qd.aibe.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.PostConstruct;
import name.qd.aibe.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LMStudioConnector {
    private static final Logger logger = LoggerFactory.getLogger(LMStudioConnector.class);
    @Value("${llm.ip}")
    private String ip;
    @Value("${llm.port}")
    private int port;
    private String uri;
    private RestTemplate restTemplate;

    @PostConstruct
    private void init() {
        uri = "http://" + ip + ":" + port;
        logger.info("LLM uri: {}", uri);
        restTemplate = new RestTemplate();
    }

    public String getModels() {
        String path = uri + "/v1/models";
        return restTemplate.getForObject(path, String.class);
    }

    public String chatCompletions(String message) {
        String path = uri + "/v1/chat/completions";
        ObjectNode node = JsonUtils.getObjectNode();
        node.putArray("messages").addObject().put("role", "user").put("content", message);
        return restTemplate.postForObject(path, node, String.class);
    }
}
