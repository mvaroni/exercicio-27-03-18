/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

/**
 *
 * @author 13104405
 */
public class Cliente {
    //VAR GLOBAL . . .
    private String nome, cpf;
    private int idade;
    private boolean genero; //TRUE = HOMEM
    private boolean socio;
    
    //CONSTRUTOR
    public Cliente(String nome, String cpf, int idade, boolean genero, boolean socio){
        this.nome=nome;
        this.cpf=cpf;
        this.idade=idade;
        this.genero=genero;
        this.socio=socio;
    }
    
    //GET . . .
    public String getNome() {return nome;}
    public String getCpf() {return cpf;}
    public int getIdade() {return idade;}  
    public boolean isSocio() {return socio;}
    public boolean isGenero(){return genero;}
    
    //SET . . .
    public void setNome(String nome) {this.nome = nome;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public void setIdade(int idade) {this.idade = idade;}
    public void setSocio(boolean socio) {this.socio = socio;}
    
    public String toString(){
        return "\nNome: " + getNome() + 
               "\nCPF: " + getCpf() +
               "\nIdade: " + getIdade() +
               "\nGênero: " + isGenero() +
               "\nSócio? " + isSocio() + "\n";
    }
}