package com.zlst.order.cpsomsoatalog.ctrl;


import com.zlst.order.cpsomsoatalog.service.CpsOmsCatalogService;
import com.zlst.order.cpsomsoatalog.vo.CpsOmsCatalogVo;
import com.zlst.param.ObjectToResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cpsOmsCatalog")
public class CpsOmsCatalogController {

    @Autowired
    CpsOmsCatalogService cpsOmsCatalogService;

    /**
     * 保存或更新目录信息
     */

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST, produces = "application/json")
    public Object orderSaveOrUpdate(@RequestBody CpsOmsCatalogVo cpsOmsCatalogVo) throws Exception{
      cpsOmsCatalogService.saveOrUpdate(cpsOmsCatalogVo);
      return  ObjectToResult.getResult(0, "success");
    }

    /**
     * 查询全部目录和对象
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public Object findAll(){
       return ObjectToResult.getResult(cpsOmsCatalogService.findAll());
    }

    /**
     * 查询所有目录
     */

    @RequestMapping(value = "/findParent", method = RequestMethod.GET)
    public Object findParent(){
        return ObjectToResult.getResult(cpsOmsCatalogService.findByCatalogType("ACTIVITY"));
    }
}
