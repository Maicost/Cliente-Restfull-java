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
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maico
 */
public class ClienteHTTP {

    public static void Logar(String credenciais, ICliente client) throws IOException {
        new Thread(new Runnable() {
            public void run() {
                try {
                    URL url = new URL("http://localhost:8080/Servidor2/resources/generic");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection(); //abre conexão

                    urlConnection.setRequestMethod("POST");
                    urlConnection.setRequestProperty("Content-type", "application/json");
                    urlConnection.setDoOutput(true); //indica que irá enviar arquivo
                    PrintStream printStream = new PrintStream(urlConnection.getOutputStream());
                    printStream.println(credenciais); //seta o que voce vai enviar

                    urlConnection.connect();

                    InputStream inputStream;
                    inputStream = urlConnection.getInputStream();

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(inputStream));

                    StringBuilder response = new StringBuilder();
                    String currentLine;

                    while ((currentLine = in.readLine()) != null) {
                        response.append(currentLine);
                    }

                    in.close();
                    urlConnection.disconnect();
                    if (response.toString().equals("false")) {
                        client.Falha(response.toString());
                    } else {
                        client.Retorna(response.toString());
                    }
                    System.out.println("Performing operation in Asynchronous Task");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(ClienteHTTP.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ClienteHTTP.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }).start();
    }

    public static void InsertUser(String credenciais, ICliente client) throws IOException {
        new Thread(new Runnable() {
            public void run() {

                try {
                    URL url = new URL("http://localhost:8080/Servidor2/resources/generic");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection(); //abre conexão

                    urlConnection.setRequestMethod("PUT");
                    urlConnection.setRequestProperty("Content-type", "application/json");
                    urlConnection.setDoOutput(true); //indica que irá enviar arquivo
                    PrintStream printStream = new PrintStream(urlConnection.getOutputStream());
                    printStream.println(credenciais); //seta o que voce vai enviar

                    urlConnection.connect();

                    InputStream inputStream;
                    inputStream = urlConnection.getInputStream();

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(inputStream));

                    StringBuilder response = new StringBuilder();
                    String currentLine;

                    while ((currentLine = in.readLine()) != null) {
                        response.append(currentLine);
                    }

                    in.close();
                    urlConnection.disconnect();
                    if (response.toString().equals("true")) {
                        client.Retorna(response.toString());
                    } else {
                        client.Falha(response.toString());
                    }
                    System.out.println("Performing operation in Asynchronous Task");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(ClienteHTTP.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ClienteHTTP.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }).start();
    }

    public static void ObterInfo() {
    }

}
