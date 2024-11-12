import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InsecureDirectObjectReferencesExample extends HttpServlet {
    private static final Map<String, Item> items = new HashMap<>();

    static {
        items.put("1", new Item("Item 1", "Description 1"));
        items.put("2", new Item("Item 2", "Description 2"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String itemId = request.getParameter("itemId");
        // Validate the input to prevent direct object references
        if (!items.containsKey(itemId)) {
            response.getWriter().println("<html><body>Invalid item ID.</body></html>");
            return;
        }
        Item item = getItemById(itemId);

        if (item != null) {
            response.getWriter().println("<html><body>Item: " + item.getName() + "</body></html>");
        } else {
            response.getWriter().println("<html><body>Item not found.</body></html>");
        }
    }

    private Item getItemById(String itemId) {
        return items.get(itemId);
    }
}

class Item {
    private final String name;
    private final String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}