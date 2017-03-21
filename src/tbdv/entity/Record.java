package tbdv.entity;



//对应数据库的一条记录
public class Record {
	
	private String tgsj;
	private String hphm;
	private int hpys;
	private String dkdm;
	private String xsfx;
	
	
	public Record() {
		super();
	}
	
	public Record(String tgsj, String hphm, int hpys, String dkdm, String xsfx) {
		super();
		this.tgsj = tgsj;
		this.hphm = hphm;
		this.hpys = hpys;
		this.dkdm = dkdm;
		this.xsfx = xsfx;
	}
	@Override
	public String toString() {
		return "Record [tgsj=" + tgsj + ", hphm=" + hphm + ", hpys=" + hpys
				+ ", dkdm=" + dkdm + ", xsfx=" + xsfx + "]";
	}
	public String getTgsj() {
		return tgsj;
	}
	public void setTgsj(String tgsj) {
		this.tgsj = tgsj;
	}
	public String getHphm() {
		return hphm;
	}
	public void setHphm(String hphm) {
		this.hphm = hphm;
	}
	public int getHpys() {
		return hpys;
	}
	public void setHpys(int hpys) {
		this.hpys = hpys;
	}
	public String getDkdm() {
		return dkdm;
	}
	public void setDkdm(String dkdm) {
		this.dkdm = dkdm;
	}
	public String getXsfx() {
		return xsfx;
	}
	public void setXsfx(String xsfx) {
		this.xsfx = xsfx;
	}
	

}
