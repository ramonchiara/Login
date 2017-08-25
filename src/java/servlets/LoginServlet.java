package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicos.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        LoginService svc = new LoginService();
        boolean autorizado = svc.verifica(login, senha);

        if (autorizado) {
            out.println("Seja bem-vindo!");
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            out.println("Não autorizado!");
        }
    }

}
