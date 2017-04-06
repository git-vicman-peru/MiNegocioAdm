package vic.apps.model;

public class ErrorObj {

	private boolean flg;
	private String fldName;
	private String msg;
	private String tag;
	
	public ErrorObj(){
		
	}

	
	public boolean hasError(){
		return this.flg;
	}
	
	public boolean getFlg() {
		return flg;
	}

	public void setFlg(boolean flg) {
		this.flg = flg;
	}

	public String getFldName() {
		return fldName;
	}

	public void setFldName(String fldName) {
		this.fldName = fldName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}


	public void reset(){
		this.flg = false;
		this.fldName = "";
		this.msg = "";
	}
	
	public void ready(boolean qflag, String qfldName, String qmessage){
		this.flg = qflag;
		this.fldName = qfldName;
		this.msg = qmessage;
	}
	
	public boolean isStrNull(String sval){
		return (sval==null)||(sval.isEmpty());
	}
}
