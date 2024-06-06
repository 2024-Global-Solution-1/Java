package models;

import java.util.Scanner;
import models.ContagemRegistro;
public class Empresa extends Dados{

    private String tipo;
    private String pessoaContato;

    public Empresa(String nome, String email, String tipo) {
        this.tipo = tipo;
        this.setEmail(email);
        this.setNome(nome);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPessoaContato() {
        return pessoaContato;
    }

    public void setPessoaContato(String pessoaContato) {
        this.pessoaContato = pessoaContato;
    }

    @Override
    public String toString() {
        return "\nEmpresa  {" +
                "nome ='" + getNome() + '\'' +
                ", email = " + getEmail() +
                ", tipo = " + getTipo() +
                ", telefone = " + getTelefone() +
                ", tipo = " + getTipo() +
                ", facebook = " + getFacebook() +
                ", instagram = " + getInstagram() +
                ", youtube = " + getYoutube() +
                ", twitter = " + getTwitter() +
                ", email = " + getEmail() +
                ", senha =  ******* "+
                "}\n";
    }

    @Override
    public void cadastrar(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n -----Cadastro Empresa-----\n");
        System.out.println("Pessoa para contato: ");
        setPessoaContato(scanner.nextLine());

        super.cadastrar();
        ContagemRegistro.addEmpre(this);
    }


}
