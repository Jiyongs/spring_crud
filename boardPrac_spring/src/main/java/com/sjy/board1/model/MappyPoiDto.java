package com.sjy.board1.model;

public class MappyPoiDto {

	private int pid;
	private String pname;
	private String address;
	private double latitude;
	private double longitude;
	private String insert_date;
	private String update_date;
	private String update_code;
	private int update_cnt;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getUpdate_code() {
		return update_code;
	}
	public void setUpdate_code(String update_code) {
		this.update_code = update_code;
	}
	public int getUpdate_cnt() {
		return update_cnt;
	}
	public void setUpdate_cnt(int update_cnt) {
		this.update_cnt = update_cnt;
	}
	
	@Override
	public String toString() {
		return "MappyPoiDto [pid=" + pid + ", pname=" + pname + ", address=" + address + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", insert_date=" + insert_date + ", update_date=" + update_date
				+ ", update_code=" + update_code + ", update_cnt=" + update_cnt + "]";
	}
	
}
