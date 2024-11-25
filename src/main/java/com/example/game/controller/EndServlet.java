package com.example.game.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/end")
public class EndServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String endingMessage = (String) session.getAttribute("endingMessage");
        String gameResult = (String) session.getAttribute("gameResult");

        if (endingMessage == null || gameResult == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        request.setAttribute("endingMessage", endingMessage);
        request.setAttribute("isWin", "win".equals(gameResult));


        // Очищаємо атрибути сесії після використання
        session.removeAttribute("endingMessage");
        session.removeAttribute("gameResult");

        request.getRequestDispatcher("/end.jsp").forward(request, response);
    }
}
