package models;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Dados {
    private String nome;
    private String telefone;
    private String email;
    private String facebook;
    private String instagram;
    private String youtube;
    private String twitter;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void cadastrar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Telefone para contato: ");
        setTelefone(scanner.nextLine());

        System.out.println("Facebook (deixe em branco caso não haja): ");
        String facebook = scanner.nextLine();
        if (facebook != null) {setFacebook(facebook);}

        System.out.println("Youtube (deixe em branco caso não haja): ");
        String youtube = scanner.nextLine();
        if (youtube != null) {setYoutube(youtube);}

        System.out.println("Twitter (deixe em branco caso não haja): ");
        String twitter = scanner.nextLine();
        if (twitter != null) {setTwitter(twitter);}

        System.out.println("Instagram (deixe em branco caso não haja): ");
        String instagram = scanner.nextLine();
        if (instagram != null) {setInstagram(instagram);}

        System.out.println("Senha: ");
        setSenha(scanner.nextLine());
    };


}

