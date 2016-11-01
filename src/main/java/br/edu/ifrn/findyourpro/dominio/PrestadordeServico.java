package br.edu.ifrn.findyourpro.dominio;

import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "usuario")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class PrestadordeServico implements Comparable<PrestadordeServico> {

    private Usuario usuario;
    private Set<Servico> servicos;

    @Override
    public int compareTo(PrestadordeServico o) {
        if (o instanceof Instituicao && this instanceof Instituicao) {
            Instituicao a = (Instituicao) this;
            Instituicao b = (Instituicao) o;
            return a.getNomeFantasia().compareTo(b.getNomeFantasia());
        } else {
            return this.usuario.compareTo(o.usuario);
        }
    }
}
