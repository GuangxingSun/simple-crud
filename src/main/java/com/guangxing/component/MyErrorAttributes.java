package com.guangxing.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 给容器增加自己定义的ErrorArrribute
 *
 * @author Guangxing
 * @create time 2020/4/11 23:27
 **/
@Component
public class MyErrorAttributes extends DefaultErrorAttributes{
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company", "guangxing");
        map.put("ext", webRequest.getAttribute("ext",0));
        return map;
    }
}
