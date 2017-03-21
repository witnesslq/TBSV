package tbdv.entity;

public class Lukuang {
	
	private String num;
	private String road;
	private String last_status;
	@Override
	public String toString() {
		return "Lukuang [num=" + num + ", road=" + road + ", last_status="
				+ last_status + ", current_status=" + current_status
				+ ", time=" + time + "]";
	}
	public Lukuang(String num, String road, String last_status,
			String current_status, String time) {
		super();
		this.num = num;
		this.road = road;
		this.last_status = last_status;
		this.current_status = current_status;
		this.time = time;
	}
	public Lukuang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public String getLast_status() {
		return last_status;
	}
	public void setLast_status(String last_status) {
		this.last_status = last_status;
	}
	public String getCurrent_status() {
		return current_status;
	}
	public void setCurrent_status(String current_status) {
		this.current_status = current_status;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	private String current_status;
	private String time;

}
