package com.zlst.common.util;

import com.alibaba.fastjson.JSON;
import com.zlst.redis.oper.redis.ZlstRedisRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 170205
 * Date: 2018-10-30
 * Time: 10:00
 */
@Component
public class CommonUtil {

    @Autowired
    private ZlstRedisRepositry zlstRedisRepositry;

    @Value("${spring.redis.database}")
    private int redisDbIndex;

    /**
     * redis转Map
     * ---字典值
     * @param key
     * @return
     */
    public List<Map> getRedisToListMap(String key) {
        String strs = zlstRedisRepositry.get(key, redisDbIndex);
        List<Map> maps = JSON.parseArray(strs, Map.class);
        return maps;
    }
}
