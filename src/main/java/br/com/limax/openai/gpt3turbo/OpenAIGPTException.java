package br.com.limax.openai.gpt3turbo;

public class OpenAIGPTException extends Exception{
	
	static final long serialVersionUID = 6484674311513215429L;
	
	public OpenAIGPTException(String message, Throwable cause) {
        super(message, cause);
    }

}
