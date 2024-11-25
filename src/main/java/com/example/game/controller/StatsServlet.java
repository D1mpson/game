package com.example.game.controller;

import com.example.game.model.PlayerStats;
import com.example.game.util.StatsManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/stats")
public class StatsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, PlayerStats> statsMap = StatsManager.getStatsMap(getServletContext());
        request.setAttribute("stats", statsMap);
        request.getRequestDispatcher("/stats.jsp").forward(request, response);
    }
}