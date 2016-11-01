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
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=false, of="cpf")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Autonomo extends PrestadordeServico {
    private String cpf;
    
    @Builder
    public Autonomo(Usuario usuario, Set<Servico> servicos, String cpf) {
        super(usuario, servicos);
        this.cpf = cpf;
    }

    @Override
    public int compareTo(PrestadordeServico o) {
        return super.compareTo(o);
    }
}