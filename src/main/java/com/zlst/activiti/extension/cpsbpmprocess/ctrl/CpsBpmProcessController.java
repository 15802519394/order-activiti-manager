package com.zlst.activiti.extension.cpsbpmprocess.ctrl;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.app.model.editor.ModelRepresentation;
import org.activiti.app.rest.editor.AbstractModelBpmnResource;
import org.activiti.app.rest.editor.ModelResource;
import org.activiti.app.rest.editor.ModelsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zlst.activiti.extension.cpsbpmprocess.bean.CpsBpmProcess;
import com.zlst.activiti.extension.cpsbpmprocess.service.CpsBpmProcessService;
import com.zlst.activiti.extension.cpsbpmprocess.vo.CpsBpmProcessVo;
import com.zlst.common.util.StringUtils;
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
	
	ModelsResource modelsResource = new ModelsResource();
	
	ModelResource modelResource = new ModelResource();
	
	AbstractModelBpmnResource abstractModelBpmnResource = new AbstractModelBpmnResource();
	
	// PFS事件与工作流模板的保存
	@RequestMapping(value = "/savePfsModel", method = RequestMethod.POST, produces = "application/json")
	public Object savePfsModel(@RequestBody CpsBpmProcessVo cpsVo) {
		// 先单独保存工作流模板
		ModelRepresentation model = new ModelRepresentation();
		// 模板格式转换
		copyCpsBpmVo2Model(cpsVo, model);
		// 如果已经存在modelId，则为更新
		if(StringUtils.isNotEmpty(cpsVo.getBpmProcessNo())) {
			model = modelResource.updateModel(cpsVo.getBpmProcessNo(), model);
		}else { 
			// 调用新增操作接口 
			model = modelsResource.createModel(model);
		}
		// 结合返回的model，将 PFS事件与工作流模板的保存(包括新增和更新)
		saveCpsBpmProcess(model,cpsVo.getPfsEventId(),cpsVo.getTpltNo());
		
		return ObjectToResult.getResult(0,"success");
	}
	
	// BPM的保存(包括新增和更新)
	public void saveCpsBpmProcess(ModelRepresentation model,String pfsEventId,String tpltNo ) {
		// 先保存model，再保存bpm,所以modelId不能为空
		if(null != model && StringUtils.isNotEmpty(model.getId())) {
			CpsBpmProcess cps = new CpsBpmProcess();
			cps.setBpmProcessNo(model.getId());
			cps.setBpmProcessVer(model.getVersion()+"");
			cps.setProcessName(model.getName());
			cps.setTpltNo(tpltNo);
			cps.setNotes(model.getDescription());
			
			cpsBpmProcessService.saveCpsBpmProcess(cps);
		}
	}
	
	// 点击左侧PFS事件的列表查询方法
	@RequestMapping(value = "/getCpsBpmProcessList", method = RequestMethod.GET, produces = "application/json")
	public Object getCpsBpmProcessList(@RequestParam(required = true) String pfsEventId) throws Exception {
        return ObjectToResult.getResult(cpsBpmProcessService.findByPfsEventId(pfsEventId));
    }
    
	// 获取单个PFS与流程模板的关联结果对象
	@RequestMapping(value="/findCpsBpmProcessOne" ,method = RequestMethod.GET, produces = "application/json")
	public Object findCpsBpmProcessOne(@RequestParam(required = true) String pfsEventId,
			@RequestParam(required = true) String bpmProcessNo) {
		return ObjectToResult.getResult(cpsBpmProcessService.findCpsBpmProcessOne(pfsEventId, bpmProcessNo));
	}
	
	// 更新PFS工作流事件的状态
	@RequestMapping(value="/updateCpsBpmProcessEnableState" ,method = RequestMethod.PUT, produces = "application/json")
	public Object updateCpsBpmProcessEnableState(@RequestParam(required = true) String pfsEventId,
			@RequestParam(required = true) String bpmProcessNo,@RequestParam(required = true) String enableState) {
		cpsBpmProcessService.updateCpsBpmProcessEnableState(pfsEventId, bpmProcessNo, enableState);
		return ObjectToResult.getResult(0,"success");
	}
	
	// 删除PFS工作流事件
	@RequestMapping(value="/deleteByPfsEventIdAndbpmProcessNo" ,method = RequestMethod.DELETE, produces = "application/json")
	public Object deleteByPfsEventIdAndbpmProcessNo(@RequestParam(required = true) String pfsEventId,
			@RequestParam(required = true) String bpmProcessNo) {
		// 删除 PFS工作流事件
		cpsBpmProcessService.deleteByPfsEventIdAndbpmProcessNo(pfsEventId, bpmProcessNo);
		
		// 还要删除 工作流模板
		// ModelResource中的删除其实有三个参数 （考虑是我这边调用还是前端分开调用）
		// public void deleteModel(@PathVariable String modelId, @RequestParam(required = false) Boolean cascade, @RequestParam(required = false) Boolean deleteRuntimeApp) {
		modelResource.deleteModel(bpmProcessNo,true,true);
		
		return ObjectToResult.getResult(0,"success");
	}

	// 流程模板的导入
	@RequestMapping(value = "/importProcessModelWithPfsEventId", method = RequestMethod.POST, produces = "application/json")
    public Object importProcessModel(HttpServletRequest request,@RequestParam(required = true) String pfsEventId, 
		   	@RequestParam("file") MultipartFile file) {
		// 导入的工作流模板保存
		ModelRepresentation model = modelsResource.importProcessModel(request, file);
		// 再保存 PFS与工作流的关联表
		saveCpsBpmProcess(model, pfsEventId, "");
		
		return ObjectToResult.getResult(0,"success");
    }
	
	// 导出xml格式的流程文件
	@RequestMapping(value = "/exportProcessModelBpmn20Xml/{processModelId}/bpmn20", method = RequestMethod.GET)
	public void exportProcessModelBpmn20Xml(HttpServletResponse response, @PathVariable String processModelId) throws IOException {
		abstractModelBpmnResource.getProcessModelBpmn20Xml(response, processModelId);
	}
	
	// 前端获取的对象信息转换为工作流模板对象
	private void copyCpsBpmVo2Model(CpsBpmProcessVo cpsVo,ModelRepresentation model) {
		model.setId(cpsVo.getBpmProcessNo());
		model.setName(cpsVo.getProcessName());
		model.setKey(cpsVo.getProcessKey());
		model.setDescription(cpsVo.getNotes());
		if(StringUtils.isNotEmpty(cpsVo.getBpmProcessVer())) {
			model.setVersion(Integer.parseInt(cpsVo.getBpmProcessVer()));
		}
	}
	
    
    
	
}
