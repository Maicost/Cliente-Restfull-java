/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @author maico
 */
public class Usuario {

    private String nome;
    private String senha;
    private String jwt;
    private String salt;

    public Usuario(String nome, String senha, String salt) {
        this.nome = nome;
        this.senha = senha;
        this.salt = salt;
    }

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getSalt() {
        return salt;
    }

    public void setJwt(String jwt) {
            this.jwt = jwt;
    }
    
    @Override
    public String toString(){
    return ""+this.nome+" "+this.jwt;
    }
}