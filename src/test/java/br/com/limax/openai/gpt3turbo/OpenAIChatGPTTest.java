package br.com.limax.openai.gpt3turbo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OpenAIChatGPTTest {

    private static final String API_KEY = System.getenv("openai.api.key");

    @Test
    public void testCompletion() throws OpenAIGPTException {

        OpenAIChatGPT chatbot = new OpenAIChatGPT(API_KEY);        
        
        ChatCompletionRequestBody request = new ChatCompletionRequestBody();
        request.setTemperature(1);
        request.setModel("gpt-3.5-turbo");
        request.addMessage(new ChatMessage("system", "O nome do usuário é Bruno, responda o nome do usuário sempre que requisitado"));        
        request.addMessage(new ChatMessage("user", "Qual é o meu nome?"));        
        
        CompletionResponse response = chatbot.complete(request);
        assertNotNull(response);
        assertTrue(response.getContent().contains("Bruno"));
    }

    @Test(expected = OpenAIGPTException.class)
    public void testCompletionError() throws OpenAIGPTException {
        OpenAIChatGPT chatbot = new OpenAIChatGPT(API_KEY);
        ChatCompletionRequestBody request = new ChatCompletionRequestBody();
        try {
        	chatbot.complete(request);
        }catch(OpenAIGPTException e) {
        	assertNotNull(e);
        	throw e;
        }
        
    }
}