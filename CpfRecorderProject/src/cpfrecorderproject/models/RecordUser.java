/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpfrecorderproject.models;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.lang.RuntimeException;

/**
 * Classe responsável por armazenar os dados de um usuário permanentemente em "users.txt".
 * @author felipe
 */

public class RecordUser {
    protected String name, surname, age, cpf, gender;
    protected ArrayList<String> users;
    
    public RecordUser(){}
    
    /**
     * Construtor da classe
     * @param name - Nome do usuário
     * @param surname - sobrenome do usuário
     * @param age - corresponde á idade da pessoa
     * @param cpf - cpf da pessoa registrada
     * @param gender - sexo da pessoa
    */
    public RecordUser(String name, String surname, String age, String cpf, String gender){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.cpf = cpf; 
        this.gender = gender;
    }
    
    /**
     * Método para registrar um usuário
     * @param name - Nome do usuário
     * @param surname - sobrenome do usuário
     * @param age - corresponde á idade da pessoa
     * @param cpf - cpf da pessoa registrada
     * @param gender - sexo da pessoa
    */
    public void recordInfo(String name, String surname, String age, String cpf, String gender){
        try{
            users = new ArrayList<>();
            FileWriter archiveWriter = new FileWriter("users.txt", true);
            PrintWriter writeArc = new PrintWriter(archiveWriter);
            
            writeArc.println("----------------------------");
            writeArc.println("CPF: " + cpf);
            writeArc.println("Nome: " + name);
            writeArc.println("Sobrenome " + surname);
            writeArc.println("Idade: " + age);
            writeArc.println("Sexo: " + gender);
            writeArc.println("----------------------------");
            
            archiveWriter.close();
           
        }
        catch(IOException e){
            System.out.println("Erro! Exceção IO");
        }
    }
    
    /**
     * Método que exibe para o usuário o resultado de um procura por uma pessoa
     * a partir de seu cpf.
     * 
     * @param cpf - cpf da pessoa
     * @return para a string "show" em Janela exibe para exibir a busca de 
     * cpf de uma pessoa ao pressionar o botão "jButtonShowUsers"
     */
    public String showInfo(String cpf){
        int cont = 0;
        try{
            users = new ArrayList<String>();
            FileReader archive = new FileReader("users.txt");
            BufferedReader readArc = new BufferedReader(archive);
           
            String str;//cria uma String que salva as linhas do arquivo lido
            
            while((str = readArc.readLine()) != null)//se o arquivo não estiver vazio
                users.add(str);//armazena as linhas na arraylist
            
            /*
            Condição que verifica primeiro se a arraylist não está vazia. 
            Depois, verifica se encontra o cpf. Se sim, adicionar +1 na variável cont, 
            utilizada posteriormente para retornar as informações necessárias.
            */
            if(users != null){  
                for(int i = 0; i < users.size(); i++){
                    if(users.get(i).contains(cpf))
                        break;                   
                    else
                        cont++;
                }
            }
               
            archive.close();
        }
        catch(IOException e){
            System.out.println("Erro! Arquivo não foi aberto");
        }
        
        if(cont < 1)//se nada foi encontrado, retorna esta informação
            return "Nenhum usuário encontrado!";
        
        else// senão, retorna os dados da pessoa
            return users.get(cont + 1) + 
                            "\n" + users.get(cont + 2) + 
                            "\n" + users.get(cont + 3) + 
                            "\n" + users.get(cont + 4) + "\n";
    }
    
}
