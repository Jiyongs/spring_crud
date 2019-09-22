package com.sjy.board1.model;

public class RawPoiDto {

	private String rid;
	private String pname;
	private String address;
	private double latitude;
	private double longitude;
	private String write_date;
	
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	
	@Override
	public String toString() {
		return "RawPoiDto [rid=" + rid + ", pname=" + pname + ", address=" + address + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", write_date=" + write_date + "]";
	}
	
	
}
