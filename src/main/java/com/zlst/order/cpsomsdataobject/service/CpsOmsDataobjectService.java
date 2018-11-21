package com.zlst.order.cpsomsdataobject.service;

import com.zlst.order.cpsomsdataobject.bean.CpsOmsDataobjectBean;
import com.zlst.order.cpsomsdataobject.dao.CpsOmsDataobjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by T016 on 2018/11/21.
 */

@Service
public class CpsOmsDataobjectService {

    @Autowired
    CpsOmsDataobjectRepository cpsOmsDataobjectRepository;

    /**
     * 根据catalogId查询元数据
     * @param catalogId
     * @return
     */

    public CpsOmsDataobjectBean findByCatalogId(String catalogId){

        return cpsOmsDataobjectRepository.findByCatalogId(catalogId);

    }
}
