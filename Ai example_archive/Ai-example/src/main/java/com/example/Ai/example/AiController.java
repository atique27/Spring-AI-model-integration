package com.example.Ai.example;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AiController {
     private OllamaChatModel client;
     private static final String PROMPT="What is java ?";
     public AiController(OllamaChatModel client) {
          this.client = client;
     }
     @GetMapping("/prompt")
     public Flux<String> promptResponse(@RequestParam("prompt")String prompt){
        Flux<String> response = client.stream(prompt);
     return response;
     }
}
