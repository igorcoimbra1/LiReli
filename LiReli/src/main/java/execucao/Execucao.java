/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package execucao;

import interfacegrafica.PaginaLogin;
import usuario.LoginSenha;

import interfacegrafica.MenuPrincipal;
/**
 *
 * @author igorc
 */
public class Execucao {
     public static void main(String[] args) {
        new LoginSenha();
        new PaginaLogin(LoginSenha.getLoginInfo());
    } 
}
