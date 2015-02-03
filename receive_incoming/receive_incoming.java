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

        String username = "Your SIP ENdpoint username";
        String password = "Your SIP ENdpoint Password";

        // Forward the token information to a JSP view
        response.setContentType("text/html");
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        RequestDispatcher view = request.getRequestDispatcher("receive_incoming.jsp");
        view.forward(request, response);
    }
}
