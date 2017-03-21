package tbdv.entity;


public class TravelRecord {
	
	private String tgsj;
	private String hphm;
	private int dkdm;
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
	public int getDkdm() {
		return dkdm;
	}
	public void setDkdm(int dkdm) {
		this.dkdm = dkdm;
	}
	public TravelRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TravelRecord(String tgsj, String hphm, int dkdm) {
		super();
		this.tgsj = tgsj;
		this.hphm = hphm;
		this.dkdm = dkdm;
	}
	@Override
	public String toString() {
		return "TravelRecord [tgsj=" + tgsj + ", hphm=" + hphm + ", dkdm="
				+ dkdm + "]";
	}

}
