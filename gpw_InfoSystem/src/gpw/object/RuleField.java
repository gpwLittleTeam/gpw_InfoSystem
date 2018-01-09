package gpw.object;

public class RuleField {
	private String field_name;
	private String field_chname;
	private String field_type;
	private String field_code;
	
	public RuleField(String field_name, String field_chname, String field_type, String field_code) {
		super();
		this.field_name = field_name;
		this.field_chname = field_chname;
		this.field_type = field_type;
		this.field_code = field_code;
	}
	public String getField_name() {
		return field_name;
	}
	public void setField_name(String field_name) {
		this.field_name = field_name;
	}
	public String getField_chname() {
		return field_chname;
	}
	public void setField_chname(String field_chname) {
		this.field_chname = field_chname;
	}
	public String getField_type() {
		return field_type;
	}
	public void setField_type(String field_type) {
		this.field_type = field_type;
	}
	public String getField_code() {
		return field_code;
	}
	public void setField_code(String field_code) {
		this.field_code = field_code;
	}
	
	
}
