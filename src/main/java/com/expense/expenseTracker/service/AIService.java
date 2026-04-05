package com.expense.expenseTracker.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AIService {

    @Value("${groq.api.key}")
    private String apiKey;
    
    @Value("${groq.api.url}")
    private String apiUrl;


   

    private final RestTemplate restTemplate = new RestTemplate();

    public String categorize(String text) {

        try {
            Map<String, Object> request = new HashMap<>();

            request.put("model", "llama-3.3-70b-versatile");

            List<Map<String, String>> messages = new ArrayList<>();

            Map<String, String> system = new HashMap<>();
            system.put("role", "system");
            system.put("content", "Classify the expense into one word: Food, Transport, Shopping, Bills, Other.");

            Map<String, String> user = new HashMap<>();
            user.put("role", "user");
            user.put("content", text);

            messages.add(system);
            messages.add(user);

            request.put("messages", messages);
            request.put("temperature", 0);

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + apiKey);
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

            ResponseEntity<Map> response =
                    restTemplate.postForEntity(apiUrl, entity, Map.class);

            List choices = (List) response.getBody().get("choices");
            Map choice = (Map) choices.get(0);
            Map message = (Map) choice.get("message");

            String result = message.get("content").toString();

            return result.replaceAll("[^a-zA-Z]", "").trim();

        } catch (Exception e) {
            e.printStackTrace();
            return "Other";
        }
    
    }
    
    public String askAI(String prompt) {

        try {
            Map<String, Object> request = new HashMap<>();

            request.put("model", "llama-3.3-70b-versatile");

            List<Map<String, String>> messages = new ArrayList<>();

            Map<String, String> system = new HashMap<>();
            system.put("role", "system");
            system.put("content", "You are a helpful financial assistant. Answer clearly and concisely.");

            Map<String, String> user = new HashMap<>();
            user.put("role", "user");
            user.put("content", prompt);

            messages.add(system);
            messages.add(user);

            request.put("messages", messages);
            request.put("temperature", 0.3);

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + apiKey);
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

            ResponseEntity<Map> response =
                    restTemplate.postForEntity(apiUrl, entity, Map.class);

            List choices = (List) response.getBody().get("choices");
            Map choice = (Map) choices.get(0);
            Map message = (Map) choice.get("message");

            return message.get("content").toString().trim();

        } catch (Exception e) {
            return "Unable to process your request right now.";
        }
    }
}