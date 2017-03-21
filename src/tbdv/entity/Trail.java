package tbdv.entity;

//车辆运行轨迹
public class Trail {
	
	private String time;
	 
	private Kakou kakou;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Kakou getKakou() {
		return kakou;
	}

	public void setKakou(Kakou kakou) {
		this.kakou = kakou;
	}

	@Override
	public String toString() {
		return "Trail [time=" + time + ", kakou=" + kakou + "]";
	}

	public Trail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trail(String time, Kakou kakou) {
		super();
		this.time = time;
		this.kakou = kakou;
	}
	
	
	

}
