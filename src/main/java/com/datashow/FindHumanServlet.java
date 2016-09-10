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

public class FindHumanServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String firstName = request.getParameter("firstName");
        final String middleName = request.getParameter("middleName");
        final String lastName = request.getParameter("lastName");
        final String cityName = request.getParameter("cityName");
        final String autoMark = request.getParameter("autoMark");
        final String autoModel = request.getParameter("autoModel");


        Map<HumanFilterEnum,String> filterMap = new HashMap<HumanFilterEnum, String>();

        if (lastName!=null&&lastName.trim().length()>0) {
            filterMap.put(HumanFilterEnum.lastName, lastName.trim());
        }

        if (firstName!=null&&firstName.trim().length()>0) {
            filterMap.put(HumanFilterEnum.firstName, firstName.trim());
        }

        if (middleName!=null&&middleName.trim().length()>0) {
            filterMap.put(HumanFilterEnum.middleName, middleName.trim());
        }

        if (cityName!=null&&cityName.trim().length()>0) {
            filterMap.put(HumanFilterEnum.cityName, cityName.trim());
        }

        if (autoMark!=null&&autoMark.trim().length()>0) {
            filterMap.put(HumanFilterEnum.autoMark, autoMark.trim());
        }

        if (autoModel!=null&&autoModel.trim().length()>0) {
            filterMap.put(HumanFilterEnum.autoModel, autoModel.trim());
        }

        HumanService humanService = new HumanService();
        List<Human> humanList = humanService.findHumans(filterMap);

        String greetings = "<table>";
        for(Human human : humanList)
        {
            String autos = "";
            for(AutoMobile autoMobile : human.getAutoMobiles()){
                autos+=  autoMobile.getBrand() +" "+ autoMobile.getModel()+"\n";
            }

            //if(filterMap.containsKey(HumanFilterEnum.autoMark))

            greetings +="<tr><td>"+ human.getFirstName() +"</td><td>"+human.getMiddleName()+ "</td><td> "+ human.getLastName()+"</td><td>"+autos+ "</td></tr>\n";
        }

        greetings += "</table>";

        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().write(greetings);
    }
}