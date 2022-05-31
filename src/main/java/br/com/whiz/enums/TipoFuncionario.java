package br.com.whiz.enums;

public enum TipoFuncionario {

    VENDEDOR(1, "Vendedor"),
    GERENTE(2, "Gerente");

    private final int cod;
    private final String funcao;

    TipoFuncionario(int cod, String funcao) {
        this.cod = cod;
        this.funcao = funcao;
    }

    public int getCod() {
        return cod;
    }

    public String getFuncao() {
        return funcao;
    }

    public static TipoFuncionario toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        for (TipoFuncionario tf : TipoFuncionario.values()){
            if (cod.equals(tf.getCod())){
                return tf;
            }
        }

        throw new IllegalArgumentException("value is not valid" + cod);

    }

}
