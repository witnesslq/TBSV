package tbdv.entity;

import java.util.HashMap;
import java.util.Map;

public class TravelResult {
	
	private String date;
	private Map<String, Integer> result=new HashMap<String, Integer>();
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public Map<String, Integer> getResult() {
		return result;
	}
	public void setResult(Map<String, Integer> result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "TravelResult [date=" + date + ",  result="
				+ result + "]";
	}
	public TravelResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TravelResult(String date,  Map<String, Integer> result) {
		super();
		this.date = date;
		this.result = result;
	}
	
	

}
