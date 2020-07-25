package servidor2.cliente;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @author maico
 */

public class App {

    String statusLogin;

    public void Login(String credenciais) throws IOException {

        System.out.println("Fazendo login");
        ClienteHTTP.Logar(credenciais, new ICliente<String>() {
            @Override
            public void Retorna(String response) {
                Dashboard dsh = new Dashboard();
                dsh.setVisible(true);
                Usuario usuario = new Usuario();
                usuario.setJwt(response);
                dsh.usuario = usuario;
                System.out.println("Logado: " + usuario.toString());
            }

            @Override
            public void Falha(String respose) {
                System.out.println("Falha login: " + respose);
            }
        });
        System.out.println("Executado");
    }
    
    public void InsertUser(String credenciais) throws IOException{
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

    public static void main(String[] args) throws MalformedURLException, IOException {
        TelaInicial login = new TelaInicial();
        login.setVisible(true);
    }
}