package com.zlst.order.cpsomsoatalog.service;


import com.zlst.common.constant.GlobalConstants;
import com.zlst.common.util.BaseUtil;
import com.zlst.common.util.StringUtils;
import com.zlst.order.cpsomsoatalog.bean.CpsOmsCatalogBean;
import com.zlst.order.cpsomsoatalog.dao.CpsOmsCatalogRepository;
import com.zlst.order.cpsomsoatalog.vo.CpsOmsCatalogVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CpsOmsCatalogService {
    @Autowired
    CpsOmsCatalogRepository cpsOmsCatalogRepository;

    private final static Logger log = LoggerFactory.getLogger(CpsOmsCatalogService.class);//日志


    /**
     * 新增及修改
     */

    @Transactional
    public void saveOrUpdate(CpsOmsCatalogVo cpsOmsCatalogVo) throws Exception{
        CpsOmsCatalogBean cpsOmsCatalogBean = new CpsOmsCatalogBean();
        BeanUtils.copyProperties(cpsOmsCatalogVo, cpsOmsCatalogBean);
        // 新增
        if (!StringUtils.isNotEmptyTrim(cpsOmsCatalogVo.getCatalogId())) {
            cpsOmsCatalogBean.setState(GlobalConstants.STATE_A);
            //cpsOmsCatalogBean.setCatalogType(GlobalConstants.CPS_OMS_CATALOG_TYPE_ACTIVITY);
            cpsOmsCatalogBean.setOrdType(GlobalConstants.ORD_TYPE_SO);
            BaseUtil.setOtherProperties(cpsOmsCatalogBean, false);
        }
        //修改
        else {
            BaseUtil.setOtherProperties(cpsOmsCatalogBean, true);
        }
        cpsOmsCatalogRepository.save(cpsOmsCatalogBean);
    }


    /**
     * 查询全部目录与对象
     */

    public List<CpsOmsCatalogBean> findAll(){
        List<CpsOmsCatalogBean> cpsOmsCatalogBeanList = cpsOmsCatalogRepository.findAll();
        return cpsOmsCatalogBeanList;
    }

    /**
     * 查询全部目录
     */

    public List<CpsOmsCatalogBean> findByCatalogType(String catalogType){
        List<CpsOmsCatalogBean> cpsOmsCatalogBeanList = cpsOmsCatalogRepository.findByCatalogType(catalogType);
        return cpsOmsCatalogBeanList;
    }

}
