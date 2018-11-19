package com.zlst.activiti.extension.cpsbpmprocess.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zlst.activiti.extension.cpsbpmprocess.service.CpsBpmProcessService;
import com.zlst.param.ObjectToResult;

/**
 * PFS事件与工作流模板关联对应前台
 * @author 170285
 */
@RestController
@RequestMapping("/cpsBpmProcess")
public class CpsBpmProcessController {

	@Autowired
	CpsBpmProcessService cpsBpmProcessService;
	
	// PFS事件与工作流模板的保存
	public Object savePfsModel() {
		return ObjectToResult.getResult("hh");
	}
	
}
