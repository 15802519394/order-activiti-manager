package com.zlst.activiti.extension.cpsbpmprocess.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlst.activiti.extension.cpsbpmprocess.bean.CpsBpmProcess;
import com.zlst.activiti.extension.cpsbpmprocess.dao.CpsBpmProcessRepository;
import com.zlst.activiti.extension.cpsbpmprocess.vo.CpsBpmProcessVo;
import com.zlst.common.util.CreateUtil;

@Service
public class CpsBpmProcessService  {

	@Autowired
	protected CpsBpmProcessRepository cpsBpmProcessRepository ;
	
	// 模板保存
	public boolean saveCpsBpmProcess(CpsBpmProcess cps) {
		// 先判断是否为更新数据
		CpsBpmProcess cpsBpm_local = cpsBpmProcessRepository.findByPfsEventIdAndBpmProcessNo(cps.getPfsEventId(), cps.getBpmProcessNo());
		// 如果不为空，则为更新
		if(null != cpsBpm_local) {
			// 添加相关字段
			CreateUtil.setCreatedOrModified(cpsBpm_local, true); // 更新人信息
			cpsBpm_local.setProcessName(cps.getProcessName()); // 模板名称
			cpsBpm_local.setNotes(cps.getNotes()); // 备注信息
			cpsBpm_local.setBpmProcessVer(cps.getBpmProcessVer()); // 版本号
			cpsBpmProcessRepository.save(cpsBpm_local);
		}else {
			// 执行新增操作
			CreateUtil.setCreatedOrModified(cps, false);
			cpsBpmProcessRepository.save(cps);
		}
		
		return true;
	}
	
	// 点击左侧菜单树的 列表查询
	public List<CpsBpmProcessVo> findByPfsEventId(String pfsEventId){
		List<CpsBpmProcessVo> result = cpsBpmProcessRepository.findByPfsEventId(pfsEventId);
		return result;
	}
	
	// 编辑：单独查询一条模板数据
	public CpsBpmProcessVo findCpsBpmProcessOne(String pfsEventId,String bpmProcessNo) {
		return cpsBpmProcessRepository.findCpsBpmProcessVoByPfsEventIdAndBpmProcessNo(pfsEventId, bpmProcessNo);
	}
	
	// 删除：
	@Transactional
	public void deleteByPfsEventIdAndbpmProcessNo(String pfsEventId , String bpmProcessNo) {
		cpsBpmProcessRepository.deleteByPfsEventIdAndBpmProcessNo(pfsEventId, bpmProcessNo);
	}
	
	// 启用、禁用状态的调整
	@Transactional
	public void updateCpsBpmProcessEnableState(String pfsEventId , String bpmProcessNo,String enableState) {
		// 先获取对象
		CpsBpmProcess cpsBpm = cpsBpmProcessRepository.findByPfsEventIdAndBpmProcessNo(pfsEventId, bpmProcessNo);
		// 修改状态
		cpsBpm.setEnableState(enableState);
		// 执行新增操作
		CreateUtil.setCreatedOrModified(cpsBpm, false);
		cpsBpmProcessRepository.save(cpsBpm);
	}
	
	// 文件的导入
	
	// 文件的导出
	
	
}
