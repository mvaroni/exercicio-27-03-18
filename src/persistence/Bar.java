/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 13104405
 */
public class Bar {
    private List<Cliente> clientes = new ArrayList<>();
    
    public Bar(){}
    
    public String show_all(){
        String resposta = "";
        
        if(clientes.size() > 0){
            for(int x=0; x<clientes.size(); x++){
               resposta = resposta + clientes.get(x).getNome() + "\n";
            }
            return resposta;
        }
        return "SEM CLIENTES NO BAR";
    }
    
    
    public String search_with_CPF(String cpf){
        int index = show_index_with_CPF(cpf);
        if(index == -1) return "CLIENTE INEXISTENTE";
        return clientes.get(index).toString();    
    }

    
    private int show_index_with_CPF(String cpf){
        for(int x=0;x<clientes.size();x++){
            if(clientes.get(x).getCpf().equalsIgnoreCase(cpf)){
                return x;
            }          
        }
        return -1;
    }
    
    
    
    public int count_clients(){
        return clientes.size();
    }
    
    public String percent_gender(){
        int homens = 0;
        for(int x=0; x<clientes.size(); x++){
            System.out.println(clientes.get(x).isGenero()+"\n");
            if(clientes.get(x).isGenero()){
                homens++;
            }
        }
        
        double percentHomens = (homens * 100) / clientes.size();
        
        return "\nHomens: " + percentHomens + "%  (" + homens + ")\n" +
               "Mulheres: " + (100 - percentHomens) + "%  (" + (clientes.size()-homens) + ")";
    }
    
    public String count_associateds(){
        int socios = 0;
        
        for(int x=0; x<clientes.size(); x++){
            if(clientes.get(x).isSocio()){
                socios++;
            }
        }
        
        return "\nSócios: " + socios + "\n" +
               "Outros: " + (clientes.size() - socios);
    }
    
    public void client_in(Cliente cli){
        clientes.add(cli);
    }
    
    public String client_out(String cpf){
        String nome;
        int index = show_index_with_CPF(cpf);
        if(index == -1) return "CLIENTE INEXISTENTE";
        nome = clientes.get(index).getNome();
        clientes.remove(index);
        return "CLIENTE " + nome + " SAIU DO BAR";
    }
}