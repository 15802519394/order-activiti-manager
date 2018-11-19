package com.zlst.activiti.extension.cpsbpmprocess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlst.activiti.extension.cpsbpmprocess.dao.CpsBpmProcessRepository;

@Service
public class CpsBpmProcessService {

	@Autowired
	private CpsBpmProcessRepository cpsBpmProcessRepository;
	
}
