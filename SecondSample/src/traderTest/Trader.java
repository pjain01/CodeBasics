package traderTest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Trader{
	@JsonProperty
	private String name;
	@JsonProperty
	private String city;
	@JsonProperty("id")
	private String traderId;
	
	public Trader(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTraderId() {
		return traderId;
	}
	public void setTraderId(String traderId) {
		this.traderId = traderId;
	}

	@Override
	public String toString() {
		return "Trader [name=" + name + ", city=" + city + ", traderId=" + traderId + "]";
	}
		
}
