package com.datashow;

import com.entity.Human;
import com.service.HumanSearchService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName").trim();
        if (userName == null || "".equals(userName)) {
            userName = "Guest";
        }

        String greetings = "Hello :";

        HumanSearchService humanSearchService = new HumanSearchService();

        List<Human> humanList = humanSearchService.getListHuman();

        for(Human human : humanList)
        {
             greetings += human.getFirstName() +" "+human.getMiddleName()+ " "+ human.getLastName()+"\n";
        }


        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().write(greetings);
    }
}