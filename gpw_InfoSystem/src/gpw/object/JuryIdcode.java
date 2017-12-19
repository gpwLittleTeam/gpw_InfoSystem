package gpw.object;

public class JuryIdcode {
	private String juryNo;
	private String expert_name;
	private String expert_phone;
	private String id_code;
	private String state; 
	private String code_invalid_time;
	
	public JuryIdcode(){
		
	}
	
	public JuryIdcode(String expert_name, 
			String expert_phone, String id_code, String state, String code_invalid_time){
		this.expert_name = expert_name;
		this.expert_phone = expert_phone;
		this.id_code = id_code;
		this.code_invalid_time = code_invalid_time;
		this.state = state;
	}
	
/*	public JuryIdcode(String juryNo, 
			String expert_phone, String expert_name, String state){
		this.expert_name = expert_name;
		this.expert_phone = expert_phone;
		this.juryNo = juryNo;
		this.state = state;
	}*/
	
	public String getJuryNo() {
		return juryNo;
	}
	public void setJuryNo(String juryNo) {
		this.juryNo = juryNo;
	}
	public String getExpert_name() {
		return expert_name;
	}
	public void setExpert_name(String expert_name) {
		this.expert_name = expert_name;
	}
	public String getExpert_phone() {
		return expert_phone;
	}
	public void setExpert_phone(String expert_phone) {
		this.expert_phone = expert_phone;
	}
	public String getId_code() {
		return id_code;
	}
	public void setId_code(String id_code) {
		this.id_code = id_code;
	}
	
	public String getCode_invalid_time() {
		return code_invalid_time;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public void setCode_invalid_time(String code_invalid_time) {
		this.code_invalid_time = code_invalid_time;
	}

	public String toString(){
		return "JuryNo:" + this.juryNo + " Expert_name:" + this.expert_name + " Expert_phone:" + this.expert_phone 
				+ " Idcode:" + this.id_code + " Code_insert_time:" + this.code_invalid_time;
	}


	
}
