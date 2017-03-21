package tbdv.entity;

import java.util.HashMap;
import java.util.Map;

public class Moran {
	
	private String dkdm;
	private String name;
	private Map<String, Integer> statusMap=new HashMap<String, Integer>();
	private String ref1;
	private String ref2;
	
	public String getDkdm() {
		return dkdm;
	}
	
	public void setDkdm(String dkdm) {
		this.dkdm = dkdm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Integer> getStatusMap() {
		return statusMap;
	}
	public void setStatusMap(Map<String, Integer> statusMap) {
		this.statusMap = statusMap;
	}
	
	
	public Moran(String dkdm, String name, Map<String, Integer> statusMap,
			String ref1, String ref2) {
		super();
		this.dkdm = dkdm;
		this.name = name;
		this.statusMap = statusMap;
		this.ref1 = ref1;
		this.ref2 = ref2;
	}

	@Override
	public String toString() {
		return "Moran [dkdm=" + dkdm + ", name=" + name + ", statusMap="
				+ statusMap + ", ref1=" + ref1 + ", ref2=" + ref2 + "]";
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

	public Moran() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	

}
