package name.qd.aibe.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import name.qd.aibe.config.AIBEException;
import name.qd.aibe.service.LLMService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/llm")
public class LLMController {
    private static final Logger logger = LoggerFactory.getLogger(LLMController.class);
    @Autowired
    private LLMService llmService;

    @GetMapping("")
    public ResponseEntity<String> getModel() throws AIBEException {
        return ResponseEntity.ok(llmService.getModels());
    }

    @PostMapping("chatCompletions")
    public ResponseEntity<String> chatCompletions(@RequestBody String message) throws JsonProcessingException {
        return ResponseEntity.ok(llmService.chatCompletions(message));
    }
}
