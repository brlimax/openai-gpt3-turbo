package br.com.limax.openai.gpt3turbo;

public class CompletionResponse {
	
    private String id = null;
    private String model = null;
    private String role = null;
    private String content = null;
    private String object = null;        
    private int promptTokens = 0;
    private int completionTokens = 0;
    private int totalTokens = 0;
    
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the object
	 */
	public String getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(String object) {
		this.object = object;
	}
	/**
	 * @return the promptTokens
	 */
	public int getPromptTokens() {
		return promptTokens;
	}
	/**
	 * @param promptTokens the promptTokens to set
	 */
	public void setPromptTokens(int promptTokens) {
		this.promptTokens = promptTokens;
	}
	/**
	 * @return the completionTokens
	 */
	public int getCompletionTokens() {
		return completionTokens;
	}
	/**
	 * @param completionTokens the completionTokens to set
	 */
	public void setCompletionTokens(int completionTokens) {
		this.completionTokens = completionTokens;
	}
	/**
	 * @return the totalTokens
	 */
	public int getTotalTokens() {
		return totalTokens;
	}
	/**
	 * @param totalTokens the totalTokens to set
	 */
	public void setTotalTokens(int totalTokens) {
		this.totalTokens = totalTokens;
	}    
    
    

}
