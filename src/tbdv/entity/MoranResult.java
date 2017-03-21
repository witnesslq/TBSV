package tbdv.entity;

import java.util.Map;

public class MoranResult {
	
	private String road ;
	@Override
	public String toString() {
		return "MoranResult [road=" + road + ", ref=" + ref + "]";
	}
	public MoranResult() {
		super();
	}
	public MoranResult(String road, Map<String, Double> ref) {
		super();
		this.road = road;
		this.ref = ref;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public Map<String, Double> getRef() {
		return ref;
	}
	public void setRef(Map<String, Double> ref) {
		this.ref = ref;
	}
	private Map<String, Double> ref;

}
