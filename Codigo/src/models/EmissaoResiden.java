package models;

import interfaces.Emissoes;

import java.util.Scanner;

public class EmissaoResiden implements Emissoes {

    private double gastoEletMensal;
    private double gastoGasMensal;
    private double gastoAguaMensal;
    private double residuosDiario;
    private int qtdPessoas;
    private double emissaoTotalResidAno;
    public EmissaoResiden() {
    }

    public double getGastoEletMensal() {
        return gastoEletMensal;
    }

    public void setGastoEletMensal(double gastoEletMensal) {
        this.gastoEletMensal = gastoEletMensal;
    }

    public double getGastoGasMensal() {
        return gastoGasMensal;
    }

    public void setGastoGasMensal(double gastoGasMensal) {
        this.gastoGasMensal = gastoGasMensal;
    }

    public double getResiduosDiario() {
        return residuosDiario;
    }

    public void setResiduosDiario(double residuosDiario) {
        this.residuosDiario = residuosDiario;
    }

    public double getGastoAguaMensal() {
        return gastoAguaMensal;
    }

    public void setGastoAguaMensal(double gastoAguaMensal) {
        this.gastoAguaMensal = gastoAguaMensal;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public double getEmissaoTotalResidAno() {
        return emissaoTotalResidAno;
    }

    public void setEmissaoTotalResidAno(double emissaoTotalResidAno) {
        this.emissaoTotalResidAno = emissaoTotalResidAno;
    }

    @Override
    public String toString() {
        return "\nEmissaoResiden  {" +
                "Gasto de energia elétrica mensal ='" + getGastoEletMensal() + '\'' +
                ", Gasto de gás natural mensal = " + getGastoGasMensal() +
                ", Gasto de água mensal = " + getGastoAguaMensal() +
                ", Kg de Resíduos produzidos diariamente = " + getResiduosDiario() +
                ", Quantidade de pessoas na casa = " + getQtdPessoas() +
                ", Emissão total individual na residência/ano em Kgs de CO2 = " + getEmissaoTotalResidAno() +
                "}\n";
    }
//  Pega informações revelantes à emissão de carbono e as adiciona aos respectivos atributos
    @Override
    public void pegarInformacoes(Usuario user) {
        Scanner numScanner = new Scanner(System.in);
        System.out.println("\n -----Cadastro de pegada de carbono na residência----- \n");
        System.out.println("Quantas pessoas vivem na sua casa?  ");
        setQtdPessoas(numScanner.nextInt());
        System.out.println("Qual o seu consumo mensal de energia elétrica? (em kWh)  ");
        setGastoEletMensal(numScanner.nextDouble());
        System.out.println("Qual o seu consumo mensal de gás natural? (em m³)  ");
        setGastoGasMensal(numScanner.nextDouble());
        System.out.println("Qual a sua produção diária de resíduos não recicláveis? (em Kg)  ");
        setResiduosDiario(numScanner.nextDouble());
        System.out.println("Qual o seu consumo mensal de água? (em m³)  ");
        setGastoAguaMensal(numScanner.nextDouble());

    }

//  Calcula a emissão total do usuário em sua residência
@Override
    public double calcularEmissao(Usuario user){
        double totalAno = 0;
        //energia elétrica
        totalAno += getGastoEletMensal() * 0.4 * 12;
        //gas
        totalAno += getGastoGasMensal() * 2.75 * 12;
        //agua
        totalAno += getGastoAguaMensal() * 0.3 * 12;
        //residuos
        totalAno += getResiduosDiario() * 0.21 * 365;

        totalAno /= getQtdPessoas();

        setEmissaoTotalResidAno(totalAno);
        return totalAno;

    }


}
