package br.com.tgid.spring.domains.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private int cod;
    private String descricao;

    public static TipoCliente toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(TipoCliente x : TipoCliente.values()) { // Itera sobre os valores da enum
            if(cod.equals(x.getCod())) { // Compara o cod passado com o cod de cada enum
                return x; // Retorna a instância da enum que corresponde ao cod
            }
        }
        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
