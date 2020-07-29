package servidor2.cliente;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @author maico
 */
public class App {

    public String token;
    String statusLogin;

    public void Login(String credenciais) throws IOException {

        System.out.println("Fazendo login");
        ClienteHTTP.Logar(credenciais, new ICliente<String>() {
            @Override
            public void Retorna(String response) {
                Login login = new Login();

                Gson gson = new Gson();

                login = gson.fromJson(response, Login.class);

                if (login.success) {
                    token = login.token;
                    ObterInfo();
                    Dashboard dsh = new Dashboard();
                    dsh.setVisible(true);

                }
            }

            @Override
            public void Falha(String respose) {
                System.out.println("Falha login: " + respose);
            }
        });
        System.out.println("Executado");
    }

    public void InsertUser(String credenciais) throws IOException {
        ClienteHTTP.InsertUser(credenciais, new ICliente<String>() {
            @Override
            public void Retorna(String response) {
                System.out.println("Cadastro com sucesso!");
            }

            @Override
            public void Falha(String respose) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }
    
    public void ObterInfo(){
         ClienteHTTP.ObterInfo(token, new ICliente<String>() {
            @Override
            public void Retorna(String response) {
                System.out.println(response);
            }

            @Override
            public void Falha(String respose) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }

    public static void main(String[] args) throws MalformedURLException, IOException {
        TelaInicial login = new TelaInicial();
        login.setVisible(true);
    }
}
