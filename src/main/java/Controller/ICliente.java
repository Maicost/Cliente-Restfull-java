package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author maico
 */
public interface ICliente<T> {

    public void Retorna(T response);

    public void Falha(T respose);

}
