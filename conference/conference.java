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

        String username = "Your SIP Endpoint Username";
        String password = "Your SIP Endpoint Password";

        // Forward the username and password information to a JSP view
        response.setContentType("text/html");
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        RequestDispatcher view = request.getRequestDispatcher("conference.jsp");
        view.forward(request, response);
    }
}
