package tbdv.entity;

import java.util.HashMap;
import java.util.Map;

public class LukuangRef {
	
	private String name;
	private String ref1;
	private String ref2;
	private Map<String, Integer> statusMap=new HashMap<String, Integer>();
	public Map<String, Integer> getStatusMap() {
		return statusMap;
	}
	public void setStatusMap(Map<String, Integer> statusMap) {
		this.statusMap = statusMap;
	}
	
	public LukuangRef() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LukuangRef(String name, String ref1, String ref2,
			Map<String, Integer> statusMap) {
		super();
		this.name = name;
		this.ref1 = ref1;
		this.ref2 = ref2;
		this.statusMap = statusMap;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRef1() {
		return ref1;
	}
	public void setRef1(String ref1) {
		this.ref1 = ref1;
	}
	public String getRef2() {
		return ref2;
	}
	public void setRef2(String ref2) {
		this.ref2 = ref2;
	}

}
