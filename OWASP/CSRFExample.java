import javax.servlet.http.*;
import java.util.UUID;

public class CSRFExample extends HttpServlet {
    private static final String CSRF_TOKEN_ATTRIBUTE = "csrfToken";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String csrfToken = UUID.randomUUID().toString();
        request.getSession().setAttribute(CSRF_TOKEN_ATTRIBUTE, csrfToken);

        response.getWriter().println("<html><body>");
        response.getWriter().println("<form action=\"/csrf\" method=\"POST\">");
        response.getWriter().println("<input type=\"hidden\" name=\"csrfToken\" value=\"" + csrfToken + "\">");
        response.getWriter().println("<input type=\"submit\" value=\"Submit\">");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String csrfToken = request.getParameter("csrfToken");
        String sessionCSRFToken = (String) request.getSession().getAttribute(CSRF_TOKEN_ATTRIBUTE);

        if (csrfToken != null && csrfToken.equals(sessionCSRFToken)) {
            // Handle sensitive action
            response.getWriter().println("<html><body>CSRF token validated.</body></html>");
        } else {
            response.getWriter().println("<html><body>Invalid CSRF token.</body></html>");
        }
    }
}