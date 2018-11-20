package com.zlst.activiti.extension.cpsbpmprocess.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlst.activiti.extension.cpsbpmprocess.bean.CpsBpmProcess;
import com.zlst.activiti.extension.cpsbpmprocess.dao.CpsBpmProcessRepository;

@Service
public class CpsBpmProcessService  {

	@Autowired
	protected CpsBpmProcessRepository cpsBpmProcessRepository ;
	
	public List<CpsBpmProcess> findByPfsEventId(String pfsEventId){
		return cpsBpmProcessRepository.findByPfsEventId(pfsEventId);
	}
	
}
