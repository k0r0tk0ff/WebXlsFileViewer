package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import parser.Parser;

@WebServlet(
        name = "MainServlet",
        urlPatterns = {"/MainServlet"}
)

public class MainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        try {
            Parser parser = new Parser();
            lists = parser.parse("file.xls");
        } catch (IOException e) {
            e.printStackTrace();
        }

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("lists", lists);
        request.getRequestDispatcher("index.jsp").include(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("index.jsp").include(request, response);
    }

}
