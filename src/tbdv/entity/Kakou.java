package tbdv.entity;

public class Kakou {
	
	@Override
	public String toString() {
		return "Kakou [dkdm=" + dkdm + ", name=" + name + ", lat=" + lat
				+ ", lon=" + lon + "]";
	}


	//道口代码
	private String dkdm;
	//名称
	private String name;
	
	private double lat;
	
	private double lon;
	


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


	public Kakou(String dkdm, String name, double lat, double lon) {
		super();
		this.dkdm = dkdm;
		this.name = name;
		this.lat = lat;
		this.lon = lon;
	}


	public Kakou() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	

	


	
	

}
