package models;

import java.time.LocalDate;
import java.util.Scanner;

public class ONG extends Dados{
    private String sigla;
    private LocalDate dtFundacao;
    private String missao;
    private String visao;
    private String areaAtuacao;
    private String website;

    public ONG(String nome, String email, String sigla) {
        this.setNome(nome);
        this.setEmail(email);
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public LocalDate getDtFundacao() {
        return dtFundacao;
    }

    public void setDtFundacao(LocalDate dtFundacao) {
        this.dtFundacao = dtFundacao;
    }

    public String getMissao() {
        return missao;
    }

    public void setMissao(String missao) {
        this.missao = missao;
    }

    public String getVisao() {
        return visao;
    }

    public void setVisao(String visao) {
        this.visao = visao;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "\nONG  {" +
                "nome ='" + getNome() + '\'' +
                ", email = " + getEmail() +
                ", sigla = " + getSigla() +
                ", telefone = " + getTelefone() +
                ", data de fundação = " + getDtFundacao() +
                ", missão = " + getMissao() +
                ", visão = " + getVisao() +
                ", área de atuação = " + getAreaAtuacao() +
                ", website = " + getWebsite() +
                ", facebook = " + getFacebook() +
                ", instagram = " + getInstagram() +
                ", youtube = " + getYoutube() +
                ", twitter = " + getTwitter() +
                ", senha =  ******* "+
                "}\n";
    }
//   Método para pegar informações específicas e genéricas (super.cadastrar()) e adicioná-las aos respectivos atributos.
    @Override
    public void cadastrar(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n -----Cadastro ONG-----\n");
        System.out.println("Data da fundação (YYYY-MM-DD): ");
        String data = scanner.nextLine();
        setDtFundacao(LocalDate.parse(data));

        System.out.println("Qual a missão da ONG? ");
        setMissao(scanner.nextLine());

        System.out.println("Qual a visão da ONG? ");
        setVisao(scanner.nextLine());

        System.out.println("Qual a área de atuação da ONG? ");
        setAreaAtuacao(scanner.nextLine());

        System.out.println("Site da ONG (deixe em branco caso não haja): ");
        String site = scanner.nextLine();
        if (site != null) {setWebsite(site);}

        super.cadastrar();

        setEstaCadastrado(true);

        ContagemRegistro.addOng(this);
    }



}
