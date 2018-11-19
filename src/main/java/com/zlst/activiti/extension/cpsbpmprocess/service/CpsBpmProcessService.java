package com.zlst.activiti.extension.cpsbpmprocess.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlst.activiti.extension.cpsbpmprocess.bean.CpsBpmProcess;
import com.zlst.activiti.extension.cpsbpmprocess.dao.CpsBpmProcessRepository;

@Service
public class CpsBpmProcessService  {

	@Autowired
	private CpsBpmProcessRepository cpsBpmProcessRepository;
	
	public List<CpsBpmProcess> findByBfsEventId(String pfsEventId){
		return cpsBpmProcessRepository.findByBfsEventId(pfsEventId);
	}
	
}
