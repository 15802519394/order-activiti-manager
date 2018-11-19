package com.zlst.activiti.extension.cpsbpmprocess.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zlst.activiti.extension.cpsbpmprocess.bean.CpsBpmProcess;

@Repository
public interface CpsBpmProcessRepository extends JpaRepository<CpsBpmProcess, String>  {
	
	List<CpsBpmProcess> findByBfsEventId(String pfsEventId);
	
}
