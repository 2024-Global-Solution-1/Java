package models;

import interfaces.Emissoes;

import java.util.Scanner;

public class EmissoesTransp implements Emissoes {

    private double kmOnibus;
    private int diaSemanaOnibus;
    private double kmDiaMetro;
    private int diaSemanaMetro;
    private double kmVoo;
    private double gastoTipoVoo;
    private int anoVoo;
    private double emissaoTotalTranspAno;

    public EmissoesTransp() {
    }

    public double getKmOnibus() {
        return kmOnibus;
    }

    public void setKmOnibus(double kmOnibus) {
        this.kmOnibus = kmOnibus;
    }

    public double getDiaSemanaOnibus() {
        return diaSemanaOnibus;
    }

    public void setDiaSemanaOnibus(int diaSemanaOnibus) {
        this.diaSemanaOnibus = diaSemanaOnibus;
    }

    public double getKmDiaMetro() {
        return kmDiaMetro;
    }

    public void setKmDiaMetro(double kmDiaMetro) {
        this.kmDiaMetro = kmDiaMetro;
    }

    public double getDiaSemanaMetro() {
        return diaSemanaMetro;
    }

    public void setDiaSemanaMetro(int diaSemanaMetro) {
        this.diaSemanaMetro = diaSemanaMetro;
    }

    public double getKmVoo() {
        return kmVoo;
    }

    public void setKmVoo(double kmVoo) {
        this.kmVoo = kmVoo;
    }

    public double getAnoVoo() {
        return anoVoo;
    }

    public void setAnoVoo(int anoVoo) {
        this.anoVoo = anoVoo;
    }

    public double getGastoTipoVoo() {
        return gastoTipoVoo;
    }

    public void setGastoTipoVoo(double gastoTipoVoo) {
        this.gastoTipoVoo = gastoTipoVoo;
    }

    public double getEmissaoTotalTranspAno() {
        return emissaoTotalTranspAno;
    }

    public void setEmissaoTotalTranspAno(double emissaoTotalTranspAno) {
        this.emissaoTotalTranspAno = emissaoTotalTranspAno;
    }

    @Override
    public String toString() {
        return "\nEmissoesTransp  {" +
                "Km em ônibus ='" + getKmOnibus() + '\'' +
                ", Dias da semana em ônibus = " + getDiaSemanaOnibus() +
                ", Km em metrô = " + getKmDiaMetro() +
                ", Dias da semana em metrô = " + getDiaSemanaMetro() +
                ", Km em aviões = " + getKmVoo() +
                ", Dias do ano em avião = " + getAnoVoo() +
                ", Tipo do voo = " + getGastoTipoVoo() +
                ", Emissão total por transporte público/ano em Kgs de CO2 = " + getEmissaoTotalTranspAno() +
                "}\n";
    }
@Override
    public void pegarInformacoes(Usuario user){
        Scanner scanner = new Scanner(System.in);
        Scanner numScanner = new Scanner(System.in);
        System.out.println("\n -----Cadastro de pegada de carbono por transporte público----- \n");
        System.out.println("Quantos dias da semana você pega ônibus? (Digite 0 caso não pegue)  ");
        int diaOnibus = numScanner.nextInt();
        if (diaOnibus == 0) {
            setDiaSemanaOnibus(0);
        } else {
            setDiaSemanaOnibus(diaOnibus);
            System.out.println("Por quantos KMs você utiliza o ônibus em um dia ?");
            setKmOnibus(numScanner.nextDouble());
        }

        System.out.println("Quantos dias da semana você pega metrô? (Digite 0 caso não pegue)  ");
        int diaMetro = numScanner.nextInt();
        if (diaMetro == 0) {
            setDiaSemanaMetro(0);
        } else {
            setDiaSemanaMetro(diaMetro);
            System.out.println("Por quantos KMs você utiliza o metrô em um dia ?");
            setKmDiaMetro(numScanner.nextDouble());
        }

        System.out.println("Quantos dias do ano você pega avião? (Digite 0 caso não pegue)  ");
        int vezesAno = numScanner.nextInt();
        if (vezesAno == 0) {
            setAnoVoo(0);
        } else {
            setAnoVoo(vezesAno);
            System.out.println("Qual a distância da viagem, em KM ?");
            setKmVoo(numScanner.nextDouble());
            System.out.println("Qual a classe do voo ?  (Economica/Executiva/Primeira)");
            String classe = scanner.nextLine();
            if (classe.equalsIgnoreCase("economica")) {
                setGastoTipoVoo(0.115);
            } else if (classe.equalsIgnoreCase("executiva")) {
                setGastoTipoVoo(0.2);
            } else if (classe.equalsIgnoreCase("primeira")) {
                setGastoTipoVoo(0.3);
            } else {
                setGastoTipoVoo(0.115);
            }

        }

    }
    @Override
    public void calcularEmissao(Usuario user) {
        double totalTranspAno = 0;
        if (getDiaSemanaOnibus() != 0) {
            totalTranspAno += ((getDiaSemanaOnibus() * getKmOnibus() * 52) / 3 * 0.82 * 0.75 * 3.7) / 30;
        }
        if (getDiaSemanaMetro() != 0) {
            totalTranspAno += (getDiaSemanaMetro() * getKmDiaMetro() * 52) * 0.05 * 0.4;
        }
        if (getAnoVoo() != 0) {
            totalTranspAno += getAnoVoo() * getKmVoo() * getGastoTipoVoo();
        }
        setEmissaoTotalTranspAno(totalTranspAno);
    }


}


