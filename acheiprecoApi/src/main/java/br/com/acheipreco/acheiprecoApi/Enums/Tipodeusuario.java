package br.com.acheipreco.acheiprecoApi.Enums;

public enum Tipodeusuario {
    EMPRESA(1),//crud
    CLIENTE(2),//lista de empresas, lista de produtos, geolocalização
    ADMIN(3);//TODOS OS PODERES

    private final int number;
    Tipodeusuario(int number) {
        this.number=number;
    }

    public int getNumber(){
        return number;
    }
}
