package com.zlst.order.cpsomsdataobject.dao;

import com.zlst.order.cpsomsdataobject.bean.CpsOmsDataobjectBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by T016 on 2018/11/21.
 */
public interface CpsOmsDataobjectRepository extends JpaRepository<CpsOmsDataobjectBean, String> {
    public CpsOmsDataobjectBean findByCatalogId(String catalogId);
}
