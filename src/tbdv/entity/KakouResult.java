package tbdv.entity;

public class KakouResult {
	
	private String name;
	private Integer value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "KakouResult [name=" + name + ", value=" + value + "]";
	}
	public KakouResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KakouResult(String name, Integer value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	

}
