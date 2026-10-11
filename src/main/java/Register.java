
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Register")
public class Register extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String ucity = request.getParameter("ucity");

		Model model = new Model();
		model.setUname(uname);
		model.setEmail(email);
		model.setpassword(password);
		model.setUcity(ucity);
		

		int row = model.register();
		HttpSession session = request.getSession();
		session.setAttribute("name", uname);

		if (row == 0) {
			response.sendRedirect("/Register/failed.jsp");
		} else {
			response.sendRedirect("/Register/success.jsp");
		}
	}

}
