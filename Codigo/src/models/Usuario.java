package models;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario extends Dados{

    private String username;
    private int idade;

    private ArrayList<Veiculo> listaVeic = new ArrayList<>();

    private double emissaoTotalAno = 0;


    public Usuario(String nome, String email, String username) {
        setNome(nome);
        setEmail(email);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public ArrayList<Veiculo> getListaVeic() {
        return listaVeic;
    }

    public void setListaVeic(ArrayList<Veiculo> listaVeic) {
        this.listaVeic = listaVeic;
    }

    public double getEmissaoTotalAno() {
        return emissaoTotalAno;
    }

    public void setEmissaoTotalAno(double emissaoTotalAno) {
        this.emissaoTotalAno = emissaoTotalAno;
    }


    @Override
    public String toString() {
        return "\nUsuário  {" +
                "nome ='" + getNome() + '\'' +
                ", email = " + getEmail() +
                ", username = " + getUsername() +
                ", telefone = " + getTelefone() +
                ", idade = " + getIdade() +
                ", lista de veículos = " + getListaVeic() +
                ", facebook = " + getFacebook() +
                ", instagram = " + getInstagram() +
                ", youtube = " + getYoutube() +
                ", twitter = " + getTwitter() +
                ", email = " + getEmail() +
                ", senha =  ******* "+
                ", Emissão total de carbono/ano =  " + getEmissaoTotalAno() +
                "}\n";
    }

//  Método para pegar informações específicas e genéricas (super.cadastrar()) e adicioná-las aos respectivos atributos.
    @Override
    public void cadastrar(){
        Scanner scanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);

        System.out.println("\n -----Cadastro Usuário-----\n");
        System.out.println("Digite sua idade: ");
        setIdade(intScanner.nextInt());

        super.cadastrar();
        setEstaCadastrado(true);
        ContagemRegistro.addUser(this);
    }

//  Pega um veículo e suas informações relevantes à queimada de carbono
//  como parâmetro e o adiciona à lista de veículos do usuário.
    public void addVeic(Veiculo veiculo) {
        Scanner scanner = new Scanner(System.in);
        Scanner numberScanner = new Scanner(System.in);
        boolean isValid = false;
        while (!isValid) {
            System.out.println("\n  -----Cadastro de Veículo -----\n");
            System.out.println("Qual tipo de combustível seu veículo usa?  (Etanol/Gasolina/Diesel)");
            String tipo = scanner.nextLine();
            switch (tipo.toLowerCase()) {
                case "etanol":
                    veiculo.setTipoVeic(EnumCombustivel.ETANOL);
                    isValid = true;
                    break;
                case "gasolina":
                    veiculo.setTipoVeic(EnumCombustivel.GASOLINA);
                    isValid = true;
                    break;
                case "diesel":
                    veiculo.setTipoVeic(EnumCombustivel.DIESEL);
                    isValid = true;
                    break;
                default:
                    break;
            }
        }
        System.out.println("Quantos KM o seu veículo percorre por dia?  ");
        veiculo.setDistanciaDia(numberScanner.nextDouble());

        System.out.println("Quantos dias da semana você usa esse veículo?  ");
        veiculo.setQtdDiasSemana(numberScanner.nextInt());

        System.out.println("Quantos KM o seu veículo faz por litro?  ");
        veiculo.setConsumoCombus(numberScanner.nextDouble());

        double emissao = veiculo.calcularEmissaoVeic(veiculo.getDistanciaDia(), veiculo.getConsumoCombus(), veiculo.getTipoVeic());
        System.out.println("A pegada deste veículo é de " + emissao + "KG CO2/dia");
        veiculo.setEmissaoDiariaVeic(emissao);

        listaVeic.add(veiculo);
    }
//  Calcula a emissão total de carbono do usuário por ano.
//  Utiliza informações de carbono de cada veículo registrado, de transporte público e residência.
    public void calcularPegadaCarbono(EmissoesTransp transPublico, EmissaoResiden residencia){
        double totalEmissaoAno = 0;
        for (Veiculo veiculo : getListaVeic()) {
            totalEmissaoAno += veiculo.getEmissaoDiariaVeic() * veiculo.getQtdDiasSemana() * 52;
        }
        totalEmissaoAno += transPublico.getEmissaoTotalTranspAno();
        totalEmissaoAno += residencia.getEmissaoTotalResidAno();

        setEmissaoTotalAno(totalEmissaoAno);



    }



}
