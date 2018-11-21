package com.zlst.activiti.extension.cpsbpmprocess.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zlst.activiti.extension.cpsbpmprocess.bean.CpsBpmProcess;
import com.zlst.activiti.extension.cpsbpmprocess.vo.CpsBpmProcessVo;

@Repository
public interface CpsBpmProcessRepository extends JpaRepository<CpsBpmProcess, String>  {
	
	@Query(value="select new com.zlst.activiti.extension.cpsbpmprocess.vo.CpsBpmProcessVo("
			+ " c.bpmProcessNo,c.processName, c.pfsEventId, c.pfsEventId as pfsEventName,c.tpltNo," 
			+ " c.notes,c.createDate,c.modifyDate,c.enableState,m.modelType,m.key as processKey) "
			+ " from CpsBpmProcess c , Model m where c.bpmProcessNo = m.id and c.pfsEventId = :pfsEventId ")
	List<CpsBpmProcessVo> findByPfsEventId(@Param("pfsEventId")String pfsEventId);
	
	@Query(value="select new com.zlst.activiti.extension.cpsbpmprocess.vo.CpsBpmProcessVo("
			+ " c.bpmProcessNo,c.processName, c.pfsEventId, c.pfsEventId as pfsEventName,c.tpltNo," 
			+ " c.notes,c.createDate,c.modifyDate,c.enableState,m.modelType,m.key as processKey) "
			+ " from CpsBpmProcess c , Model m where c.bpmProcessNo = m.id "
			+ " and c.pfsEventId = :pfsEventId and c.bpmProcessNo = :bpmProcessNo")
	CpsBpmProcessVo findCpsBpmProcessVoByPfsEventIdAndBpmProcessNo(@Param("pfsEventId")String pfsEventId , @Param("bpmProcessNo")String bpmProcessNo);
	
	CpsBpmProcess findByPfsEventIdAndBpmProcessNo(String pfsEventId , String bpmProcessNo);
	
	@Modifying
	void deleteByPfsEventIdAndBpmProcessNo(String pfsEventId , String bpmProcessNo);
	
	
}
