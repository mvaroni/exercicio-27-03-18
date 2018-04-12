/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import persistence.Bar;
import persistence.Cliente;

/**
 *
 * @author 13104405
 */
public class NewEmptyJUnitTest {
    
    @Test
    public void check_in(){
        Bar bar = new Bar();
        
        Cliente cli_1 = new Cliente("Renato", 
                                    "84818700003", 
                                    35, 
                                    true, 
                                    false);
        Cliente cli_2 = new Cliente("Laura", 
                                    "55514735003", 
                                    28, 
                                    false, 
                                    false);
        Cliente cli_3 = new Cliente("Ycaro", 
                                    "50330987618", 
                                    40, 
                                    true, 
                                    true);
        //ADICIONA 3 . . .
        bar.client_in(cli_1);
        bar.client_in(cli_2);
        bar.client_in(cli_3);
        
        //REMOVE 1 . . .
        bar.client_out(cli_1.getCpf());
        
        assertEquals(2, bar.count_clients());
    }
    
    @Test
    public void mostrar_clientes_null(){
        Bar bar = new Bar();
        assertEquals("SEM CLIENTES NO BAR", bar.show_all());
    }
    
    @Test
    public void mostrar_clientes(){
        Bar bar = new Bar();
        
        Cliente cli_1 = new Cliente("PEDRO", 
                                    "00002589671", 
                                    39, 
                                    true, 
                                    false);
        Cliente cli_2 = new Cliente("RENATA", 
                                    "01131510005", 
                                    38, 
                                    false, 
                                    true);
        
        //ADICIONA 3 . . .
        bar.client_in(cli_1);
        bar.client_in(cli_2);
        
        assertEquals("PEDRO\nRENATA\n", bar.show_all());
    }
    
    @Test
    public void quantidade_de_clientes(){
        Bar bar = new Bar();
        
        Cliente cli_1 = new Cliente("PATRICIA", 
                                    "01232589123", 
                                    22, 
                                    false, 
                                    true);
        Cliente cli_2 = new Cliente("ROBERTO", 
                                    "07182512817", 
                                    19, 
                                    true, 
                                    true);
        //ADD 2 CLIENTES . . .
        bar.client_in(cli_1);
        bar.client_in(cli_2);
        
        assertEquals(2, bar.count_clients());
    }
    
    
    @Test
    public void pesquisar_por_CPF_null(){
        Bar bar = new Bar();
        assertEquals("CLIENTE INEXISTENTE", bar.search_with_CPF("00000000000"));
    }
     @Test
    public void pesquisar_por_CPF(){
        Bar bar = new Bar();
       
        Cliente cli_1 = new Cliente("MARTA", 
                                    "01232589123", 
                                    45, 
                                    false, 
                                    true);
        Cliente cli_2 = new Cliente("BRENO", 
                                    "10002000300", 
                                    23, 
                                    true, 
                                    true);
        
        //ADD 2 CLIENTES . . .
        bar.client_in(cli_1);
        bar.client_in(cli_2);
        
        assertEquals("\nNome: BRENO\nCPF: 10002000300\nIdade: 23\nGênero: true\nSócio? true\n", bar.search_with_CPF("10002000300"));
    }
    
    /*
    @Test
    public void distribuicao_por_genero(){
        assertEquals(1, 1);
    }
    
    @Test
    public void distribuicao_de_socios(){
        assertEquals(1, 1);
    }
    @Test
    public void check_out(){
        assertEquals(1, 1);
    }
*/
    
}
