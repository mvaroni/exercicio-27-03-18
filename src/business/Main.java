/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import persistence.*;

/**
 *
 * @author 13104405
 */
public class Main {

    //Pesquisar como criar um arq texto num desktop qualquer
    private static final String FILENAME = "C:\\temp\\logClients.txt";
    private static List<Cliente> checked_in_list = new ArrayList<>();
    public static Scanner terminal = new Scanner(System.in);
    
    static Bar bar = new Bar();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        Cliente cliente_1 = new Cliente("PEDRINHO"  , "03455699985", 17, true , false );
        Cliente cliente_2 = new Cliente("JUANA"     , "09684699005", 29, false,  true );
        Cliente cliente_3 = new Cliente("JUAU"      , "15425789336", 45, true ,  true );
        Cliente cliente_4 = new Cliente("JUSICLEYDE", "85769300289", 19, false, false );
        Cliente cliente_5 = new Cliente("JULINHO"   , "77930179582", 22, true ,  true );
        Cliente cliente_6 = new Cliente("GEREMIAS"  , "79635817582", 60, true ,  true );
        
        //CLIENTES ENTRAM NO BAR
        bar.client_in(cliente_1);
        verify_client_passage(cliente_1);
        bar.client_in(cliente_2);
        verify_client_passage(cliente_2);
        bar.client_in(cliente_3);
        verify_client_passage(cliente_3);
        bar.client_in(cliente_4);
        verify_client_passage(cliente_4);
        bar.client_in(cliente_5);
        verify_client_passage(cliente_5);
        bar.client_in(cliente_6);
        verify_client_passage(cliente_6);
        
        int op;
        do{
            System.out.println("1 - Check-in de cliente\n" +
            "2 - Mostrar clientes\n" +
            "3 - Quantidade de clientes\n" +
            "4 - Pesquisar por CPF\n" +
            "5 - Distribuição por gênero\n" +
            "6 - Distribuição de sócios\n" +
            "7 - Check-Out de cliente\n" +
            "8 - Sair do sistema\n\n");
            
            op = terminal.nextInt();
            
            switch(op){
                case 1:
                    System.out.println("Informe o nome do cliente:\n");
                    String nome = terminal.next();
                    System.out.println("Informe o CPF do cliente:\n");
                    String cpf = terminal.next();
                    System.out.println("Informe o idade do cliente:\n");
                    int idade = terminal.nextInt();
                    
                    int genero = 0;
                    do{
                    System.out.println("Informe o gênero do cliente:\n    "
                                        + "1 = Masculino;\n "
                                        + "2 = Feminino;");
                    genero  = terminal.nextInt();
                    if(genero != 1 && genero !=2){
                        System.out.println("OPÇÃO INVÁLIDA!");
                    }
                    }while(genero != 1 && genero !=2);
                    
                    int socio = 0;
                    do{
                    System.out.println("Informe se o cliente é sócio:\n    "
                                        + "1 = SIM;\n "
                                        + "2 = NÃO;");
                    socio  = terminal.nextInt();
                    if(socio != 1 && socio !=2){
                        System.out.println("OPÇÃO INVÁLIDA!");
                    }
                    }while(socio != 1 && socio !=2);
                    
                    
                    
                    Cliente cli = new Cliente(nome, cpf, idade, genero==1, socio==1);
                    bar.client_in(cli);
                    verify_client_passage(cli);
                    waiting();
                    break;
                    
                case 2:
                    System.out.println("CLIENTES: = \n" + bar.show_all());
                    waiting();
                    break;
                    
                case 3:
                    System.out.println("Quantidade de cliente = " + bar.count_clients());
                    waiting();
                    break;
                    
                case 4:
                    System.out.println("Digite o CPF:\n");
                    String cpfPesq = terminal.next();
                    
                    System.out.println(bar.search_with_CPF(cpfPesq));
                    waiting();
                    break;
                    
                case 5:
                    System.out.println("Distribuição por gênero: " + bar.percent_gender());
                    waiting();
                    break;
                    
                case 6:
                    System.out.println("Distribuição por sócios" + bar.count_associateds());
                    waiting();
                    break;
                    
                case 7:
                    System.out.println("Informe o seu CPF:\n");
                    String cpfOut = terminal.next();
                    
                    System.out.println(bar.client_out(cpfOut));
                    
                    waiting();
                    break;
                    
                case 8:
                    write_in_log();
                    return;
            }
            
        }while(op != 8);
        
    }
    
    private static void waiting(){
        System.out.println("\n----------------------------\n" + 
                           "Digite H para voltar ao menu inicial:\n");
        while(true){
            if(terminal.hasNext())
                if(terminal.next().equalsIgnoreCase("H"))
                    break;
        }
    }
    
    public static void write_in_log() {
        BufferedWriter writer = null;
        String logPath="Log saved in ";
        
        try {
            
            File logFile = new File(FILENAME);
            
            logPath += logFile.getCanonicalPath();
            
            writer = new BufferedWriter(new FileWriter(logFile, true));                  
            for(int x=0; x < checked_in_list.size(); x++){
                writer.write(checked_in_list.get(x).toString());
                writer.newLine();
                writer.write("-----------------------------------");
                writer.newLine();
            }
            
        }catch (IOException e ) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        System.out.println(logPath);
    } 
    
    public static void verify_client_passage(Cliente cli){
        for(int x=0; x < checked_in_list.size(); x++){
            if(cli.getCpf().equals(checked_in_list.get(x).getCpf())){
                return;
            }
        }
        checked_in_list.add(cli);
    }
}