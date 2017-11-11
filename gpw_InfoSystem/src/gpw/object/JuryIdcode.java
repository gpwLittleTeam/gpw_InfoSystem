package gpw.object;

public class JuryIdcode {
	private String juryNo;
	private String expert_name;
	private String expert_phone;
	private String id_code;
	private String code_insert_time;
	
	public JuryIdcode(){
		
	}
	
	public JuryIdcode(String expert_name, 
			String expert_phone, String id_code, String code_insert_time){
		this.expert_name = expert_name;
		this.expert_phone = expert_phone;
		this.id_code = id_code;
		this.code_insert_time = code_insert_time;
	}
	
	public JuryIdcode(String juryNo, 
			String expert_phone, String expert_name){
		this.expert_name = expert_name;
		this.expert_phone = expert_phone;
		this.juryNo = juryNo;
	}
	
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
	public String getCode_insert_time() {
		return code_insert_time;
	}
	public void setCode_insert_time(String code_insert_time) {
		this.code_insert_time = code_insert_time;
	}
	
	public String toString(){
		return "JuryNo:" + this.juryNo + " Expert_name:" + this.expert_name + " Expert_phone:" + this.expert_phone 
				+ " Idcode:" + this.id_code + " Code_insert_time:" + this.code_insert_time;
	}
	
}
