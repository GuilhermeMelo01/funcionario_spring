package br.com.whiz.enums;

public enum TipoFuncionario {

    GERENTE(1, "Gerente"),
    VENDEDOR(2, "Vendedor");

    private final Integer cod;
    private final String cargo;

    TipoFuncionario(Integer cod, String descricao) {
        this.cod = cod;
        this.cargo = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getCargo() {
        return cargo;
    }

    public static TipoFuncionario toEnum(Integer cod){
        if (cod == null) {
            return null;
        }

        for (TipoFuncionario tipoFuncionario: TipoFuncionario.values()){
            if (cod.equals(tipoFuncionario.getCod())){
                return tipoFuncionario;
            }
        }

        throw new IllegalArgumentException("Value is not invalid! "+ cod);
    }
}

