package com.zlst.activiti.extension.cpsbpmprocess.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zlst.activiti.extension.cpsbpmprocess.bean.CpsBpmProcess;


public interface CpsBpmProcessRepository extends JpaRepository<CpsBpmProcess, String>  {
	
	
}
