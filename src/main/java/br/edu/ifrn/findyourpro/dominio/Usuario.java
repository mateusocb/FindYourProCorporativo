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

public abstract class Usuario implements Comparable<Usuario> {

    private static final long serialVersionUID = 1L;

    private Localizacao endereco;
    private String telefone;
    private String login;
    private String nome;
    private String senha;

    @Override
    public int compareTo(Usuario o) {
        return this.login.compareTo(o.login);
    }
}
