package com.zlst.activiti.extension.cpsbpmprocess.ctrl;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zlst.activiti.extension.cpsbpmprocess.service.CpsBpmProcessService;
import com.zlst.param.ObjectToResult;

/**
 * PFS事件与工作流模板关联对应前台
 * @author 170285
 */
@RestController
@RequestMapping("/cpsBpmProcess")
public class CpsBpmProcessController  {

	@Inject
	CpsBpmProcessService cpsBpmProcessService;
	
	// PFS事件与工作流模板的保存
	@RequestMapping(value = "/savePfsModel", method = RequestMethod.GET, produces = "application/json")
	public Object savePfsModel() {
		return ObjectToResult.getResult("hh");
	}
	
	@RequestMapping(value = "/getCpsBpmProcessList", method = RequestMethod.GET, produces = "application/json")
	public Object getCpsBpmProcessList(@RequestParam(required = false) String pfsEventId) throws Exception {
        return ObjectToResult.getResult(cpsBpmProcessService.findByPfsEventId(pfsEventId));
    }
    
    
    
    
	
}
