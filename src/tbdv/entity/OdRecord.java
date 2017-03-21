package tbdv.entity;

public class OdRecord {
	
	private String tgsj;
	private String hphm;
	private String dkdm;
	private String name;
	private double lat;
	private double lon;
	
	@Override
	public String toString() {
		return "OdRecord [tgsj=" + tgsj + ", hphm=" + hphm + ", dkdm=" + dkdm
				+ ", name=" + name + ", lat=" + lat + ", lon=" + lon + "]";
	}
	public OdRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OdRecord(String tgsj, String hphm, String dkdm, String name,
			double lat, double lon) {
		super();
		this.tgsj = tgsj;
		this.hphm = hphm;
		this.dkdm = dkdm;
		this.name = name;
		this.lat = lat;
		this.lon = lon;
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
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	
}
