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

//  Conjunto de métodos que incrementam o valor da quantidade de X em 1 quando X se cadastra.
    public static void addUser(Usuario novoUsuario) {
        setQtUser(getQtUser() + 1);
    }
    public static void addEmpre(Empresa novaEmpre) {
        setQtdEmpre(getQtdEmpre() + 1);
    }
    public static void addOng(ONG novaONG) {
        setQtdOng(getQtdOng() + 1);
    }
//  Conjunto de métodos que checa se X está cadastrado e retorna o respectivo boolean
    public static boolean checkCadastro(Usuario user) {
        boolean cadastro = true;
        if (!user.isEstaCadastrado()) {
            cadastro = false;
        }
        return cadastro;
    }
    public static boolean checkCadastro(Empresa empresa) {
        boolean cadastro = true;
        if (!empresa.isEstaCadastrado()) {
            cadastro = false;
        }
        return cadastro;
    }
    public static boolean checkCadastro(ONG ong) {
        boolean cadastro = true;
        if (!ong.isEstaCadastrado()) {
            cadastro = false;
        }
        return cadastro;
    }





}

