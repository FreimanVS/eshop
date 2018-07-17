package com.freimanvs.shops.eshop.tags.handler;

import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CounterTagHandler extends SimpleTagSupport {

    public static final String COUNTER_APPLICATION_ATTRIBUTE = "counter";
    private Map<String, Long> counterMap = null;
    private static final Logger LOGGER = Logger.getLogger(CounterTagHandler.class);

    @Override
    public void doTag() throws JspException, IOException {
        PageContext context = (PageContext) getJspContext();
        counterMap = (Map<String, Long>) context.getServletContext().getAttribute(COUNTER_APPLICATION_ATTRIBUTE);
        if (counterMap == null) {
            counterMap = new ConcurrentHashMap<>();
            context.getServletContext().setAttribute(COUNTER_APPLICATION_ATTRIBUTE, counterMap);
        }

        final Map<String, Long> result = counterMap;

        String key = context.getPage().getClass().getSimpleName();
        Long value = result.getOrDefault(key, 0L) + 1;
        counterMap.put(key, value);
        LOGGER.info("page: " + key + "; count: " + value);
    }

    public Map<String, Long> getCounterMap() {
        return counterMap;
    }
}