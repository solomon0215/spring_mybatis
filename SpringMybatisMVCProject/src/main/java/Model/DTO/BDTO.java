package Model.DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BDTO  implements Serializable{
	Long a;
	Long c;
	String d;
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
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
}
