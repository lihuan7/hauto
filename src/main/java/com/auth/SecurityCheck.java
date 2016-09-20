package com.auth;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Created by snikitin on 08.09.16.
 */
@WebServlet(name = "SecurityCheck", urlPatterns = {"/security_check"})
public class SecurityCheck extends HttpServlet {
    private static final long serialVersionUID = 3864891998838185875L;
    private static final Logger logger = Logger.getLogger(SecurityCheck.class);

    private static final Random RND = new Random();

    @Override
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding("UTF-8");
        }

        final String rememberMe = request.getParameter("rememberMe");
        final String username = request.getParameter("j_username");
        final String password = request.getParameter("j_password");
        final String realIP = request.getHeader("X-Real-IP");

        final String info = "principal='" + username
                + "', password='" + (password == null ? null : password.replaceAll(".", "*"))
                + "', X-Real-IP='" + realIP
                + "', addr='" + request.getRemoteAddr()
                + "', host='" + request.getRemoteHost() + "'";

        logger.info(info);
        try {
            Thread.sleep(RND.nextInt(200) + 800);
            request.login(username, password);
            if (rememberMe != null) {
                Cookie usernameCookie = new Cookie("username-cookie", username);
                Cookie passwordCookie = new Cookie("password-cookie", password);
                usernameCookie.setMaxAge(24 * 60 * 60);
                passwordCookie.setMaxAge(24 * 60 * 60);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            }
            response.sendRedirect("index.jsp");
        } catch (Exception ex) {
            response.sendRedirect("login-failed.jsp");
        }
    }
}
