import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.ServletException;

public class XSSExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userInput = request.getParameter("username");
        // Encode user input to prevent XSS attacks
        String safeUserInput = HTMLEscape(userInput);
        response.getWriter().println("<html><body>Hello, " + safeUserInput + "</body></html>");
    }

    // Utility method to escape HTML special characters
    private String HTMLEscape(String s) {
        if (s == null) return null;
        StringBuilder out = new StringBuilder(Math.max(16, s.length()));
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > 127 || c == '"' || c == '<' || c == '>' || c == '&' || c == '\'' ) {
                out.append("&#" + (int)c + ";");
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }
}