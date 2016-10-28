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
@ToString
@EqualsAndHashCode(exclude="prestador")
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Servico implements Comparable<Servico> {

   private String tipo;
   private String descricao;
   Set<PrestadordeServico> prestador;
   

    @Override
    public int compareTo(Servico o) {
        int result= this.tipo.compareTo(o.tipo);
        if(result==0){
            result=this.descricao.compareTo(o.descricao);
        }
        return result;
    }
}