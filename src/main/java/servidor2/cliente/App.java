/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor2.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
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
                System.out.println("Logado: " + response);
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
