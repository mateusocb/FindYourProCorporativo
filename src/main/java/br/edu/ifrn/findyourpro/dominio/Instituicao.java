package br.edu.ifrn.findyourpro.dominio;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = "id")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Instituicao implements Comparable<Instituicao> {
    
    private Localizacao endereco;
    private String telefone;
    private String nomeFantasia;
    private String cnpj;
    private Usuario usuario;
    
    @Override
    public int compareTo(Instituicao o) {
        int result = this.usuario.compareTo(o.usuario);
        if (result == 0) {
            result = this.cnpj.compareTo(o.cnpj);
	}
        return result;
    }
}
