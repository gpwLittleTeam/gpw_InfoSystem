package gpw.object;

public class CodeModel {
	private String codeNo;
	private String codeName;
	private String codeComments;
	
	public CodeModel() {	}
	
	public CodeModel(String codeNo, String codeName, String codeComments) {
		super();
		this.codeNo = codeNo;
		this.codeName = codeName;
		this.codeComments = codeComments;
	}
	
	public String getCodeNo() {
		return codeNo;
	}
	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public String getCodeComments() {
		return codeComments;
	}
	public void setCodeComments(String codeComments) {
		this.codeComments = codeComments;
	}
	 
}
