package servicos;

public class LoginService {

    public boolean verifica(String login, String senha) {
        if (login == null || senha == null) {
            return false;
        }

        return login.equals("admin") && senha.equals("r**t");
    }

}
