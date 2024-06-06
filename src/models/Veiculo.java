package models;

public class Veiculo {
    private EnumCombustivel tipoVeic;
    private int qtdDiasSemana;
    private double distanciaDia;
    private double consumoCombus;
    private double emissaoDiariaVeic;

    public Veiculo() {

    }

    public EnumCombustivel getTipoVeic() {
        return tipoVeic;
    }

    public void setTipoVeic(EnumCombustivel tipoVeic) {
        this.tipoVeic = tipoVeic;
    }

    public double getDistanciaDia() {
        return distanciaDia;
    }

    public void setDistanciaDia(double distanciaDia) {
        this.distanciaDia = distanciaDia;
    }

    public double getConsumoCombus() {
        return consumoCombus;
    }

    public void setConsumoCombus(double consumoCombus) {
        this.consumoCombus = consumoCombus;
    }

    public double getEmissaoDiariaVeic() {
        return emissaoDiariaVeic;
    }

    public void setEmissaoDiariaVeic(double emissaoDiariaVeic) {
        this.emissaoDiariaVeic = emissaoDiariaVeic;
    }


    public int getQtdDiasSemana() {
        return qtdDiasSemana;
    }

    public void setQtdDiasSemana(int qtdDiasSemana) {
        this.qtdDiasSemana = qtdDiasSemana;
    }

    public double calcularEmissaoVeic(double kmDia, double kmLitro, EnumCombustivel tipo) {
        double emissao = 0;
        if (tipo == EnumCombustivel.GASOLINA) {
            emissao = (kmDia / kmLitro) * 0.82 * 0.75 * 3.7;
        }
        else if (tipo == EnumCombustivel.ETANOL) {
            emissao = (kmDia / kmLitro) * 1.5;
        }

        return emissao;
    }

}
