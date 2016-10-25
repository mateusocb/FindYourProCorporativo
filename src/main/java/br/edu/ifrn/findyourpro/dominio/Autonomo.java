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

public class Autonomo implements Comparable<Autonomo>{
    
    private Profissao profissao;
    private String descricao;
    private Usuario usuario;
    private String cpf;
    
    @Override
    public int compareTo(Autonomo o) {
        int result = this.usuario.compareTo(o.usuario);
        if (result == 0) {
            result = this.cpf.compareTo(o.cpf);
	}
        return result;
    }
}
