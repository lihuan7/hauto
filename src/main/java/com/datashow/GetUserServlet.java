package com.datashow;

import com.entity.AutoMobile;
import com.entity.Human;
import com.service.HumanFilterEnum;
import com.service.HumanService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName").trim();
        if (userName == null || "".equals(userName)) {
            userName = "Guest";
        }

        Map<HumanFilterEnum,String> stringMap = new HashMap<HumanFilterEnum, String>();
        stringMap.put(HumanFilterEnum.firstName,userName);


        HumanService humanService = new HumanService();
        List<Human> humanList = humanService.findListHuman(stringMap);

        String greetings = "<table>";
        for(Human human : humanList)
        {
            String autos = "";
            for(AutoMobile autoMobile : human.getAutoMobiles()){
                autos+=  autoMobile.getBrand() +" "+ autoMobile.getModel()+"\n";
            }
            greetings +="<tr><td>"+ human.getFirstName() +"</td><td>"+human.getMiddleName()+ "</td><td> "+ human.getLastName()+"</td><td>"+autos+ "</td></tr>\n";
        }

        greetings += "</table>";

        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().write(greetings);
    }
}