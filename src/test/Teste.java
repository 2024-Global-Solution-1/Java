package test;

import models.*;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner NumSanner = new Scanner(System.in);

        ///////////////////Inicialziando os objetos///////////////////////////////

        Empresa empresa1 = new Empresa("Paradis", "paradisbusiness@gmail.com", "Grande Porte");
        ONG ong1 = new ONG("Yeagerists", "islandsalvation@gmail.com", "YGR");
        Usuario user1 = new Usuario("Eren", "readytorumble@gmail.com", "Tatakae80%");

        Veiculo veiculo1User1 = new Veiculo();
        Veiculo veiculo2User1 = new Veiculo();

        EmissaoResiden residenciaUser1 = new EmissaoResiden();
        EmissoesTransp transPublicoUser1 = new EmissoesTransp();


        /////////////////////////Cadastrando objetos da classe Empresa, ONG, e Usuario////////////////////

        empresa1.cadastrar();
        ong1.cadastrar();
        user1.cadastrar();
        //Printando a visualização dos atributos das classes Empresa e ONG
        System.out.println(empresa1);
        System.out.println(ong1);
        //Printando a quatidade regristrada de objetos Empresa, ONG e Usuario
        System.out.println("\nUsuários Registrados: " + ContagemRegistro.getQtUser());
        System.out.println("\nONGs Registradas: " + ContagemRegistro.getQtdOng());
        System.out.println("\nEmpresas Registradas: " + ContagemRegistro.getQtdEmpre());


        ///////////////////////////////Registrando um veículo na lista de veículos do Usuário//////////////

        user1.addVeic(veiculo1User1);


        //////////Calculando a pegada de carbono do usuário em transportes públicos e na residência/////////////

        //O user1 está sendo passado por razões de verificação. Você não consegue chamar os métodos sem um objeto usuário.
        transPublicoUser1.pegarInformacoes(user1);
        transPublicoUser1.calcularEmissao(user1);
        System.out.println(transPublicoUser1);

        residenciaUser1.pegarInformacoes(user1);
        residenciaUser1.calcularEmissao(user1);
        System.out.println(residenciaUser1);

        //////////////////////////////Calculando a pegada de carbono final, por ano, do usuário/////////////
        user1.calcularPegadaCarbono(transPublicoUser1, residenciaUser1);
        //Printando os atributos do usuário
        System.out.println(user1);
        System.out.printf("A pegada de carbono, em Kg/Ano do usuário é de: " + String.format("%.2f",user1.getEmissaoTotalAno()) + "\n");


        ////////////////////////Informações/Curiosidades sobre os mares e oceanos//////////////////////
        Info.addInfo("O SOL DÁ AO OCEANO SUA TONALIDADE AZUL");
        Info.addInfo("EXISTEM LAGOS E RIOS ABAIXO DA SUPERFÍCIE DO OCEANO");
        Info.addInfo("AS ONDAS DO TSUNAMI PODEM ATINGIR 30 METROS DE ALTURA");
        Info.addInfo("MENOS DE 5% DOS OCEANOS JÁ FOI EXPLORADO");
        System.out.println(Info.getInformacoes());







    }

}
