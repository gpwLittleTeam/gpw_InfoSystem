package gpw.action.MyAjax;

import java.util.List;

import gpw.object.CodeModel;

import com.opensymphony.xwork2.ActionSupport;

public class ForRuleManagement extends ActionSupport{
	/**
	 * 通过给定代码表名称得到该表的内容
	 * @param fieldCode 传入需要获取的代码表名称
	 * @return ajax返回对应代码表里的所有列
	 */
	public String getCodeList(String fieldCode){
		List<CodeModel> listCodeModel;
		
		return SUCCESS;
	}
}
