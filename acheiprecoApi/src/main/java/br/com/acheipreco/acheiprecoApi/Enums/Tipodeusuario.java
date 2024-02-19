package br.com.acheipreco.acheiprecoApi.Enums;

public enum Tipodeusuario {
    EMPRESA("EMPRESA"),//crud
    CLIENTE("CLIENTE"),//lista de empresas, lista de produtos, geolocalização
    ADMIN("ADMIN");//TODOS OS PODERES

    private final String type;
    Tipodeusuario(String type) {
        this.type=type;
    }

    public String getType(){
        return type;
    }
}
