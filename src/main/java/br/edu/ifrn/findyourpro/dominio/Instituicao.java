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
@EqualsAndHashCode(of={"cnpj","prestador"})
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Instituicao implements Comparable<Instituicao> {

    private Localizacao endereco;
    private String telefone;
    private String nomeFantasia;
    private String cnpj;
    private PrestadordeServico prestador;

    @Override
    public int compareTo(Instituicao o) {
        int result = this.cnpj.compareTo(o.cnpj);
        if(result==0){
            result = this.prestador.compareTo(o.prestador);
        }
        return result;
    }
}