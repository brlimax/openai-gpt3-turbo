package br.com.limax.openai.gpt3turbo;

public class OpenAIChatGPT {

    private final OpenAIGPT client;

    public OpenAIChatGPT(String apiKey) {
        this.client = new OpenAIGPT(apiKey);
    }

    public CompletionResponse complete(ChatCompletionRequestBody request) throws OpenAIGPTException {
        try {
            return client.complete(request);
        } catch (Exception e) {
            throw new OpenAIGPTException("Error completing chat request:\n" + e.getMessage(), e);
        }
    }
}
