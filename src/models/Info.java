package models;

import java.util.ArrayList;

public class Info {
    private static ArrayList<String> informacoes = new ArrayList<>();

    private Info() {
    }

    public static ArrayList<String> getInformacoes() {
        return informacoes;
    }

    public static void setInformacoes(ArrayList<String> informacoes) {
        Info.informacoes = informacoes;
    }

    public static void addInfo(String info) {
        informacoes.add(info);
    }
}
