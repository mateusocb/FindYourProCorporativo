package br.edu.ifrn.findyourpro.dominio;

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
@EqualsAndHashCode(of={"cpf","prestador"})
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Autonomo implements Comparable<Autonomo> {
    private String descricao;
    private String cpf;
    private PrestadordeServico prestador;
    
    @Override
    public int compareTo(Autonomo o) {
        int result = this.cpf.compareTo(o.cpf);
        if(result==0){
            result = this.prestador.compareTo(o.prestador);
        }
        return result;
    }
 }