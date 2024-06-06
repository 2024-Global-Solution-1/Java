package models;

public final class ContagemRegistro {

    private static int qtdOng = 0;
    private static int qtUser = 0;
    private static int qtdEmpre = 0;


    private ContagemRegistro() {
    }

    public static int getQtdOng() {
        return qtdOng;
    }

    public static void setQtdOng(int qtdOng) {
        ContagemRegistro.qtdOng = qtdOng;
    }

    public static int getQtUser() {
        return qtUser;
    }

    public static void setQtUser(int qtUser) {
        ContagemRegistro.qtUser = qtUser;
    }

    public static int getQtdEmpre() {
        return qtdEmpre;
    }

    public static void setQtdEmpre(int qtdEmpre) {
        ContagemRegistro.qtdEmpre = qtdEmpre;
    }

    public static void addUser(Usuario novoUsuario) {
        setQtUser(getQtUser() + 1);
    }
    public static void addEmpre(Empresa novaEmpre) {
        setQtdEmpre(getQtdEmpre() + 1);
    }
    public static void addOng(ONG novaONG) {
        setQtdOng(getQtdOng() + 1);
    }




}

