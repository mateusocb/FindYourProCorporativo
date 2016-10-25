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

public class Avaliacao implements Comparable<Avaliacao> {
    private static final long serialVersionUID = 1L;
    
    private Autonomo profissional;
    private Instituicao instituicao;
    private Usuario cliente;
    private float nota;
    private String descricao;
    
    @Override
    public int compareTo(Avaliacao o) {
        //TODO: 
    }
}
