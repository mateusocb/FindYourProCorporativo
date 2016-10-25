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

public class Instituicao implements Comparable<Instituicao> {
    private static final long serialVersionUID = 1L;
    
    private Localizacao endereco;
    private String telefone;
    private String nomeFantasia;
    private String cnpj;
    private Usuario usuario;
    
    @Override
    public int compareTo(Instituicao o) {
        return this.cnpj.compareTo(o.cnpj);
    }
}
