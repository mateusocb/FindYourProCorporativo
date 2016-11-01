package br.edu.ifrn.findyourpro.dominio;

import java.util.Set;
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
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false, of = "cnpj")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Instituicao extends PrestadordeServico {

    private Localizacao endereco;
    private String telefone;
    private String nomeFantasia;
    private String cnpj;

    @Builder
    public Instituicao(Usuario user, Set<Servico> servicos, 
            Localizacao endereco, String telefone, String nomeFantasia, 
            String cnpj) {
        super(user, servicos);
        this.endereco = endereco;
        this.telefone = telefone;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }
}
