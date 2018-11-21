package com.zlst.order.cpsomsdataobject.ctrl;

import com.zlst.order.cpsomsdataobject.service.CpsOmsDataobjectService;
import com.zlst.order.cpsomsdataobject.vo.CpsOmsDataobjectFindVo;
import com.zlst.param.ObjectToResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by T016 on 2018/11/21.
 */

@RestController
@RequestMapping("/v1/cpsOmsDataobject")
public class CpsOmsDataobjectController {

    @Autowired
    public CpsOmsDataobjectService cpsOmsDataobjectService;

    @RequestMapping(value = "/findActivityOrDo", method = RequestMethod.POST, produces = "application/json")
    public Object findActivityOrDo(@RequestBody CpsOmsDataobjectFindVo cpsOmsDataobjectFindVo) {
        if (cpsOmsDataobjectFindVo.getCatalogType().equals("ACTIVITY"))
            return ObjectToResult.getResult(cpsOmsDataobjectService.findByCatalogId(cpsOmsDataobjectFindVo.getFindId()));
        else
            return null;
    }
}
