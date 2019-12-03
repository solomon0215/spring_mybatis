package Model.DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CDTO implements Serializable{
	Long a;
	Long c;
	Long e;
	String f;
	public Long getA() {
		return a;
	}
	public void setA(Long a) {
		this.a = a;
	}
	public Long getC() {
		return c;
	}
	public void setC(Long c) {
		this.c = c;
	}
	public Long getE() {
		return e;
	}
	public void setE(Long e) {
		this.e = e;
	}
	public String getF() {
		return f;
	}
	public void setF(String f) {
		this.f = f;
	}
	
}
