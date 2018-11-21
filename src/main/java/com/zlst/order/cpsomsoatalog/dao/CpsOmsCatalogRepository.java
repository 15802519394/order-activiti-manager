package com.zlst.order.cpsomsoatalog.dao;


import com.zlst.order.cpsomsoatalog.bean.CpsOmsCatalogBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CpsOmsCatalogRepository extends JpaRepository<CpsOmsCatalogBean, String> {

    List<CpsOmsCatalogBean> findByCatalogType(String catalogType);//根据目录类型查询

}
