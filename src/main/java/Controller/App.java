package Controller;

import Model.Login;
import View.Dashboard;
import View.FalhaLogin;
import View.TelaInicial;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @author maico
 */
public class App {

    public String token;
    String statusLogin;
    public String retorno;

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
                    Dashboard dsh = new Dashboard();
                    ObterInfo(dsh);
                    dsh.setVisible(true);
                }
            }

            @Override
            public void Falha(String respose) {
                FalhaLogin falhaLogin = new FalhaLogin();
                falhaLogin.setVisible(true);
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
    
    public void ObterInfo(Dashboard dsh){
         ClienteHTTP.ObterInfo(token, new ICliente<String>() {
            @Override
            public void Retorna(String response) {
                System.out.println(response);
                dsh.id = response;
            }

            @Override
            public void Falha(String respose) {
                retorno = respose;
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }

    public static void main(String[] args) throws MalformedURLException, IOException {
        TelaInicial telaInicial = new TelaInicial();
        telaInicial.setVisible(true);
    }
}
