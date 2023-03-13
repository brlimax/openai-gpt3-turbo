package br.com.limax.openai.gpt3turbo;

import java.util.ArrayList;
import java.util.List;

public class ChatCompletionRequestBody {
	
	private double temperature = 1;
	private String model = "gpt-3.5-turbo";
	private int maxTokens = 4096;
	private double topP = 1;
	private double presencePenalty = 0;
	private double frequencyPenalty = 0;
	private int n = 1;
	
	
	private List<ChatMessage> message = new ArrayList<>();
	
	public void addMessage(ChatMessage chatMessage) {
		message.add(chatMessage);
	}
	
	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * [EN]
	 * <b>temperature</b> Optional Defaults to 1<br/>
	 * What sampling temperature to use, between 0 and 2. 
	 * Higher values like 0.8 will make the output more random, while lower values like 0.2 will make it more focused and deterministic.
	 * <br/><b>We generally recommend altering this or top_p but not both.</b>
	 * <br/>
	 * [PT-BR]
	 * <b>temperature</b> Opcional Default é 1<br/>
	 * Qual temperatura de amostragem usar, entre 0 e 2.
	 * Valores mais altos, como 0,8, tornarão a saída mais aleatória, enquanto valores mais baixos, como 0,2, a tornarão mais focada e determinística.
	 * <br/><b>Geralmente recomendamos alterar isso ou top_p, mas não ambos.</b>
	 * @param temperature the temperature to set
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * [EN]
	 * <b>model</b> Mandatory<br/>
	 * 2023-mar-13. ID of the model to use. Currently, only <b>gpt-3.5-turbo</b> and <b>gpt-3.5-turbo-0301</b> are supported.
	 * <br/>
	 * [PT-BR]
	 * <b>model</b> Obrigatório<br/>
	 * 2023-mar-13. ID do modelo a ser usado. Atualmente, apenas <b>gpt-3.5-turbo</b> e <b>gpt-3.5-turbo-0301</b> são suportados.
	 * 
	 * @param model the max_tokens to set
	 */	
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the message
	 */
	public List<ChatMessage> getMessage() {
		return message;
	}
	
	/**
	 * @return the maxTokens
	 */	
	public int getMaxTokens() {
		return maxTokens;
	}

	/**
	 * [EN]
	 * The maximum number of tokens allowed for the generated answer. 
	 * By default, the number of tokens the model can return will be (4096 - prompt tokens).
	 * <br/>
	 * [PT-BR]
	 * O número máximo de tokens permitidos para a resposta gerada.
	 * Por padrão, o número de tokens que o modelo pode retornar será (4096 - tokens de prompt).
	 * @param maxTokens the max_tokens to set
	 */	
	public void setMaxTokens(int maxTokens) {
		this.maxTokens = maxTokens;
	}

	/**
	 * @return the topP
	 */		
	public double getTopP() {
		return topP;
	}

	/**
	 * [EN]
	 * <b>top_p</b> Optional Defaults to 1<br/>
	 * An alternative to sampling with temperature, called nucleus sampling, where the model considers the results of the tokens with top_p probability mass. 
	 * So 0.1 means only the tokens comprising the top 10% probability mass are considered. 
	 * <br/><b>We generally recommend altering this or temperature but not both.</b>
	 * <br/>
	 * [PT-BR]
	 * <b>top_p</b> Opcional Default é 1<br/>
	 * Uma alternativa para amostragem com temperatura, chamada de amostragem de núcleo, onde o modelo considera os resultados dos tokens com massa de probabilidade top_p.
	 * Portanto, 0,1 significa que apenas os tokens que compõem a massa de probabilidade de 10% são considerados.
	 * <br/><b>Geralmente recomendamos alterar isso ou temperature, mas não ambos.</b>
	 * @param topP the top_p to set	 * 
	 */		
	public void setTopP(double topP) {
		this.topP = topP;
	}

	/**
	 * @return the presencePenalty
	 */
	public double getPresencePenalty() {
		return presencePenalty;
	}

	/**
	 * [EN]
	 * <b>presence_penalty</b> Optional Defaults to 0<br/>
	 * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether they
	 * appear in the text so far, increasing the model's likelihood to talk about new topics.
	 * <br/>
	 * [PT-BR]
	 * <b>presence_penalty</b> Opcional Default é 0<br/>
	 * Número entre -2,0 e 2,0. Valores positivos penalizam novos tokens com base em sua presença no texto até o momento, 
	 * aumentando a probabilidade do modelo falar sobre novos tópicos.
	 * 
	 * <br/><br/><b>https://platform.openai.com/docs/api-reference/parameter-details</b>
	 * 
	 * @param presencePenalty the presence_penalty to set
	 */
	public void setPresencePenalty(double presencePenalty) {
		this.presencePenalty = presencePenalty;
	}

	/**
	 * @return the frequencyPenalty
	 */
	public double getFrequencyPenalty() {
		return frequencyPenalty;
	}

	/**
	 * [EN]
	 * <b>frequency_penalty</b> Optional Defaults to 0<br/>
	 * Number between -2.0 and 2.0. Positive values penalize new tokens based on their existing frequency in the text so far, 
	 * decreasing the model's likelihood to repeat the same line verbatim.
	 * <br/>
	 * [PT-BR]
	 * <b>frequency_penalty</b> Opcional Default é 0<br/>
	 * Número entre -2,0 e 2,0. Valores positivos penalizam novos tokens com base em sua frequência existente no texto até o momento, 
	 * diminuindo a probabilidade do modelo repetir a mesma linha textualmente. 
	 * 
	 * <br/><br/><b>https://platform.openai.com/docs/api-reference/parameter-details</b>
	 * 
	 * @param frequencyPenalty the frequency_penalty to set
	 */
	public void setFrequencyPenalty(double frequencyPenalty) {
		this.frequencyPenalty = frequencyPenalty;
	}

	/**
	 * @return the n
	 */
	public int getN() {
		return n;
	}

	/**
	 * [EN]
	 * <b>n</b> Optional Defaults to 1<br/>
	 * How many chat completion choices to generate for each input message.
	 * <br/>
	 * [PT-BR]
	 * <b>n</b> Opcional Default é 1<br/>
	 * Quantas opções de conclusão de bate-papo serão geradas para cada mensagem de entrada.
	 * 
	 * @param n the max_tokens to set
	 */	
	public void setN(int n) {
		this.n = n;
	}
	

}
