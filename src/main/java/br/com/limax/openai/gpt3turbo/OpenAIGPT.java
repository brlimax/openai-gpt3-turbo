package br.com.limax.openai.gpt3turbo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

class OpenAIGPT {
	
    private final String apiKey;

    public OpenAIGPT(String apiKey) {
        this.apiKey = apiKey;
    }

    public CompletionResponse complete(ChatCompletionRequestBody request) throws URISyntaxException, IOException {
    	
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("https://api.openai.com/v1/chat/completions");
        httpPost.addHeader("Authorization", "Bearer " + apiKey);
        httpPost.addHeader("Content-Type", "application/json");


        JSONObject requestJson = new JSONObject();
        requestJson.put("model", request.getModel());
        requestJson.put("temperature", request.getTemperature());
        requestJson.put("top_p", request.getTopP());
        
        
        requestJson.put("frequency_penalty", request.getFrequencyPenalty());
        requestJson.put("presence_penalty", request.getPresencePenalty());        
        requestJson.put("n", request.getN());
        
        
        
        
        JSONArray messagesArray = new JSONArray();
        List<ChatMessage> listMessage = request.getMessage();
        
        for (ChatMessage chatMessage : listMessage) {
        	
        	JSONObject message01 = new JSONObject();
            message01.put("role", chatMessage.getRole());
            message01.put("content", chatMessage.getContent());
            messagesArray.put(message01);

		}

        requestJson.put("messages", messagesArray);

        StringEntity requestEntity = new StringEntity(
                requestJson.toString(),
                ContentType.APPLICATION_JSON);

        httpPost.setEntity(requestEntity);    	

        CloseableHttpResponse response = httpclient.execute(httpPost);
        CompletionResponse completionResponse = null;
        try {
        	int statusCode = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String responseJsonString  = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            EntityUtils.consume(entity);
            
            if(statusCode == 200) {            	
                JSONObject responseJson = new JSONObject(responseJsonString);
                String id = responseJson.getString("id");
                String model = responseJson.getString("model");
                JSONArray choicesArray = responseJson.getJSONArray("choices");
                JSONObject choice = choicesArray.getJSONObject(0);
                JSONObject messageObject = choice.getJSONObject("message");
                String role = messageObject.getString("role");
                String content = messageObject.getString("content");
                String object = responseJson.getString("object");
                JSONObject usageObject = responseJson.getJSONObject("usage");
                int promptTokens = usageObject.getInt("prompt_tokens");
                int completionTokens = usageObject.getInt("completion_tokens");
                int totalTokens = usageObject.getInt("total_tokens");
                
                completionResponse = new CompletionResponse();                
                completionResponse.setId(id);
                completionResponse.setModel(model);
                completionResponse.setRole(role);
                completionResponse.setPromptTokens(promptTokens);
                completionResponse.setCompletionTokens(completionTokens);
                completionResponse.setTotalTokens(totalTokens);
                completionResponse.setObject(object);
                completionResponse.setContent(content);
            }else {
            	throw new IOException(responseJsonString);
            }
        } finally {
            response.close();
        }
        
        httpclient.close();
        
        return completionResponse;
        
    }

}
