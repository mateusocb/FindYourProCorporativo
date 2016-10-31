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
@EqualsAndHashCode(of="usuario")
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class PrestadordeServico implements Comparable<PrestadordeServico> {
    private Usuario usuario;

    @Override
    public int compareTo(PrestadordeServico o) {
        return this.usuario.compareTo(o.usuario);
    }
}