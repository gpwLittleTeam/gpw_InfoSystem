package gpw.object;

public class Historytitle {
	//private String History_id;
	private String expert_no;
	private String expert_name;
	private String expert_jury;
	private String expert_group;
	private String expert_post;
	private String expert_serveyear;
	
	public Historytitle(){
		
	}
	
	public Historytitle(String expert_no, String expert_name,
			String expert_jury, String expert_group, String expert_post,
			String expert_serveyear){
		//this.History_id = History_id;
		this.expert_no = expert_no;
		this.expert_name = expert_name;
		this.expert_jury = expert_jury;
		this.expert_group = expert_group;
		this.expert_post = expert_post;
		this.expert_serveyear = expert_serveyear;
	}

//	public String getHistory_id() {
//		return History_id;
//	}
//
//	public void setHistory_id(String history_id) {
//		History_id = history_id;
//	}

	public String getExpert_no() {
		return expert_no;
	}

	public void setExpert_no(String expert_no) {
		this.expert_no = expert_no;
	}

	public String getExpert_name() {
		return expert_name;
	}

	public void setExpert_name(String expert_name) {
		this.expert_name = expert_name;
	}

	public String getExpert_jury() {
		return expert_jury;
	}

	public void setExpert_jury(String expert_jury) {
		this.expert_jury = expert_jury;
	}

	public String getExpert_group() {
		return expert_group;
	}

	public void setExpert_group(String expert_group) {
		this.expert_group = expert_group;
	}

	public String getExpert_post() {
		return expert_post;
	}

	public void setExpert_post(String expert_post) {
		this.expert_post = expert_post;
	}

	public String getExpert_serveyear() {
		return expert_serveyear;
	}

	public void setExpert_serveyear(String expert_serveyear) {
		this.expert_serveyear = expert_serveyear;
	}
	
}
