package interfaces;
import models.Usuario;

public interface Emissoes {
    double calcularEmissao(Usuario user);

    void pegarInformacoes(Usuario user);
}
