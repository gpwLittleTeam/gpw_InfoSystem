package gpw.object;

public class Codetable {
	private String tablename;
	private String tablechname;
	private String number;
	
	public Codetable(){
		
	}
	
	public Codetable(String tablename, String tablechname, String number){
		this.tablename = tablename;
		this.tablechname = tablechname;
		this.number = number;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getTablechname() {
		return tablechname;
	}

	public void setTablechname(String tablechname) {
		this.tablechname = tablechname;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
