package br.edu.ifrn.findyourpro.dominio;

import java.util.Date;
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
@EqualsAndHashCode(exclude={"nota","descricao"})
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Avaliacao implements Comparable<Avaliacao> {

    private Servico servico;
    private Usuario cliente;
    private int nota;
    private String descricao;
    private Date data;

    @Override
    public int compareTo(Avaliacao o) {
        int result = this.data.compareTo(o.data);
        if (result == 0) {
            result = this.servico.compareTo(o.servico);
        }
        if (result == 0) {
            result = this.cliente.compareTo(o.cliente);
        }
        return result;
    }
}