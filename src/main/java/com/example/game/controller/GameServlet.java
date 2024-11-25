package com.example.game.controller;

import com.example.game.model.GameLogic;
import com.example.game.util.StatsManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String playerName = (String) session.getAttribute("playerName");

        if (playerName == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        GameLogic gameLogic = (GameLogic) session.getAttribute("gameLogic");
        if (gameLogic == null) {
            gameLogic = new GameLogic();
            session.setAttribute("gameLogic", gameLogic);
            session.setAttribute("currentStep", "start");
        }

        String currentStep = (String) session.getAttribute("currentStep");
        request.setAttribute("question", gameLogic.getQuestion(currentStep));
        request.setAttribute("options", gameLogic.getOptions(currentStep));
        request.setAttribute("image", gameLogic.getImage(currentStep)); // Додаємо зображення

        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String playerName = request.getParameter("playerName");
        if (playerName != null && !playerName.trim().isEmpty()) {
            session.setAttribute("playerName", playerName);
            GameLogic gameLogic = new GameLogic();
            session.setAttribute("gameLogic", gameLogic);
            session.setAttribute("currentStep", "start");
            response.sendRedirect(request.getContextPath() + "/game");
            return;
        }

        String action = request.getParameter("action");
        if ("endGame".equals(action)) {
            session.removeAttribute("gameLogic");
            session.removeAttribute("currentStep");
            response.sendRedirect(request.getContextPath() + "/welcome");
            return;
        }

        GameLogic gameLogic = (GameLogic) session.getAttribute("gameLogic");
        if (gameLogic == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        String currentStep = (String) session.getAttribute("currentStep");
        String answer = request.getParameter("choice");

        String nextStep = gameLogic.getNextStep(currentStep, answer);
        session.setAttribute("currentStep", nextStep);

        if (gameLogic.isGameOver(nextStep)) {
            playerName = (String) session.getAttribute("playerName");
            if (playerName != null) {
                boolean isWin = "win".equals(nextStep);
                StatsManager.updatePlayerStats(getServletContext(), playerName, isWin);
            }
            String endingMessage = gameLogic.getQuestion(nextStep);
            session.setAttribute("endingMessage", endingMessage);
            session.setAttribute("gameResult", nextStep);

            session.removeAttribute("gameLogic");
            session.removeAttribute("currentStep");

            response.sendRedirect(request.getContextPath() + "/end.jsp");
            return;
        }

        response.sendRedirect(request.getContextPath() + "/game");
    }
}
