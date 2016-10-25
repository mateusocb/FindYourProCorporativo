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
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Autonomo implements Comparable<Autonomo>{
    private static final long serialVersionUID = 1L;
    
    private Profissao profissao;
    private String descricao;
    private Usuario usuario;
    private String cpf;
    
    @Override
    public int compareTo(Autonomo o) {
        return this.cpf.compareTo(o.cpf);
    }
}
