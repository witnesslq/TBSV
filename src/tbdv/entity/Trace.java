package tbdv.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trace {
	
	//号牌
	private String hp;
	//起始时间
	private String begin;
	//终止时间
	private String end;
	//轨迹记录
	private String date;
	private List<Trail>trail=new ArrayList<Trail>();
	
	public List<Trail> getTrail() {
		return trail;
	}

	public Trace(String hp, String begin, String end, String date,
			List<Trail> trail) {
		super();
		this.hp = hp;
		this.begin = begin;
		this.end = end;
		this.date = date;
		this.trail = trail;
	}

	public void setTrail(List<Trail> trail) {
		this.trail = trail;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	

	public Trace() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Trace [hp=" + hp + ", begin=" + begin + ", end=" + end
				+ ", date=" + date + ", trail=" + trail + "]";
	}

	
	

}
