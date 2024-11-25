package com.example.game.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String playerName = (String) session.getAttribute("playerName");
        if (playerName != null) {
            request.setAttribute("playerName", playerName);
        }
        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        if ("changeNickname".equals(action)) {
            session.removeAttribute("playerName");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else if ("startGame".equals(action)) {
            String playerName = (String) session.getAttribute("playerName");
            if (playerName == null) {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/game");
            }
        }
    }
}