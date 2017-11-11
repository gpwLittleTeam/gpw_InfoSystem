package temp.struts2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class test extends ActionSupport{
	private File file;
	private String fileFileName;
	private String fileContentType;
	
	public String execute() throws Exception {
		if(file != null) {
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
			String path = request.getRealPath("/headPortrait");
			System.out.println("path"+path);
			InputStream is = new FileInputStream(file);
			OutputStream os = new FileOutputStream(new File(path,fileFileName));
			System.out.println("line55");
			byte[] buffer = new byte[200];
			int len = 0;
			while((len=is.read(buffer))!=-1) {
				os.write(buffer,0,len);
			}
			os.close();
			is.close();
		} else {
			System.out.println("没有照片");
		}
		return SUCCESS;
	}

	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
}
