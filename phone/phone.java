package web_phne;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet("/plivo")
public class phone extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Invoke the JSP file
        response.setContentType("text/html");
        RequestDispatcher view = request.getRequestDispatcher("phone.jsp");
        view.forward(request, response);
    }
}
