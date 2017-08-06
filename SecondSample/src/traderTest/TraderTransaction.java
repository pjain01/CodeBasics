package traderTest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TraderTransaction {
	@JsonProperty
	long timestamp;
	@JsonProperty
	String traderId;
	@JsonProperty
	double value;
	
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public double getValue() {
		return value;
	}
	
		
	@Override
	public String toString() {
		return "TraderTransaction [timestamp=" + timestamp + ", traderId=" + traderId + ", value=" + value + "]";
	}
	
}
