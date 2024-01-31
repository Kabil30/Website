import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo7Servlet")
public class Demo7Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Demo7Servlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String item = request.getParameter("item");
        int qty = Integer.parseInt(request.getParameter("qty"));

        newclass2 obj = new newclass2(item, qty);
        obj.store();
        doGet(request, response);
        response.sendRedirect("thankyoupage.html");
    }
}