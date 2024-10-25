import javax.servlet.http.*;

public class XSSExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userInput = request.getParameter("username");
        response.getWriter().println("<html><body>Hello, " + userInput + "</body></html>");
    }
}