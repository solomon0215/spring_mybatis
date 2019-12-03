package Model.DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ADTO implements Serializable{
	Long a;
	String b;
	
	public ADTO(Long a, String b) {
		super();
		this.a = a;
		this.b = b;
	}
	public Long getA() {
		return a;
	}
	public void setA(Long a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
}
