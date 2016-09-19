package com.datashow;

import com.entity.Human;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.HumanFilterEnum;
import com.service.HumanService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindHumanServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(FindHumanServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final ObjectMapper mapper = new ObjectMapper();

        final String jsonData = request.getParameter("jsonData");

        logger.debug("request jsonData : " + jsonData);

        final Map<String, String> jsonMap = new ObjectMapper().readValue(jsonData, HashMap.class);

        final Map<HumanFilterEnum, String> filterMap = new HashMap<>();

        jsonMap.entrySet().stream().filter(entry -> entry.getValue() != null && !entry.getValue().isEmpty()).forEach(entry -> {
            filterMap.put(HumanFilterEnum.valueOf(entry.getKey()), entry.getValue());
        });

        HumanService humanService = new HumanService();
        List<Human> humanList = humanService.findHumans(filterMap);

        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().write(mapper.writeValueAsString(humanList));
    }
}