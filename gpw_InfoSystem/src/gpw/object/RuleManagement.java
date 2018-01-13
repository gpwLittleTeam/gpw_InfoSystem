package gpw.object;

public class RuleManagement {
	private String rule_no;
	private String rule_field;
	private String rule_relation;
	private String rule_value;
	private String rule_percent;
	private String rule_percentRelation;
	private String rule_range;
	private String rule_force;
	private String rule_enabled;
	
	
	public RuleManagement() {
		super();
	}
	public RuleManagement(String rule_no, String rule_field, String rule_relation, String rule_value,
			String rule_percent, String rule_percentRelation, String rule_range, String rule_force, String rule_enabled) {
		super();
		this.rule_no = rule_no;
		this.rule_field = rule_field;
		this.rule_relation = rule_relation;
		this.rule_value = rule_value;
		this.rule_percent = rule_percent;
		this.rule_percentRelation = rule_percentRelation;
		this.rule_range = rule_range;
		this.rule_force = rule_force;
		this.rule_enabled = rule_enabled;
	}
	public String getRule_no() {
		return rule_no;
	}
	public void setRule_no(String rule_no) {
		this.rule_no = rule_no;
	}
	public String getRule_field() {
		return rule_field;
	}
	public void setRule_field(String rule_field) {
		this.rule_field = rule_field;
	}
	public String getRule_relation() {
		return rule_relation;
	}
	public void setRule_relation(String rule_relation) {
		this.rule_relation = rule_relation;
	}
	public String getRule_value() {
		return rule_value;
	}
	public void setRule_value(String rule_value) {
		this.rule_value = rule_value;
	}
	public String getRule_percent() {
		return rule_percent;
	}
	public void setRule_percent(String rule_percent) {
		this.rule_percent = rule_percent;
	}
	public String getRule_percentRelation() {
		return rule_percentRelation;
	}
	public void setRule_percentRelation(String rule_percentRelation) {
		this.rule_percentRelation = rule_percentRelation;
	}
	public String getRule_range() {
		return rule_range;
	}
	public void setRule_range(String rule_range) {
		this.rule_range = rule_range;
	}
	public String getRule_force() {
		return rule_force;
	}
	public void setRule_force(String rule_force) {
		this.rule_force = rule_force;
	}
	public String getRule_enabled() {
		return rule_enabled;
	}
	public void setRule_enabled(String rule_enabled) {
		this.rule_enabled = rule_enabled;
	}
	
	
}
