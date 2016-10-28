package br.edu.ifrn.findyourpro.dominio;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
/*import lombok.NonNull;*/
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of="cnpj")
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Instituicao implements Comparable<Instituicao> {

    private Localizacao endereco;
    private String telefone;
    private String nomeFantasia;
    private String cnpj;

    @Override
    public int compareTo(Instituicao o) {
       return this.cnpj.compareTo(o.cnpj);
    }
}