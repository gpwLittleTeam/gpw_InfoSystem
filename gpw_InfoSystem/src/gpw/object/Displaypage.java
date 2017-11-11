package gpw.object;

public class Displaypage {
	private String tablename;
	private String tablechname;
	private String displayorder;
	private String order;
	
	public Displaypage(){
		
	}
	
	public Displaypage(String tablename, String tablechname, String displayorder, 
			String order){
		this.tablename = tablename;
		this.tablechname = tablechname;
		this.displayorder = displayorder;
		this.order = order;
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

	public String getDisplayorder() {
		return displayorder;
	}

	public void setDisplayorder(String displayorder) {
		this.displayorder = displayorder;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
}
