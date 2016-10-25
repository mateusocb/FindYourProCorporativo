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

public class Avaliacao implements Comparable<Avaliacao> {
    
    private Autonomo profissional;
    private Instituicao instituicao;
    private Usuario cliente;
    private float nota;
    private String descricao;
    
    @Override
    public int compareTo(Avaliacao o) {
        int result=0;
        if(this.profissional!=null){
            result=this.profissional.compareTo(o.profissional);
        }
        else{
            result=this.instituicao.compareTo(o.instituicao);
        }
        if (result == 0) {
            result=this.cliente.compareTo(o.cliente);
        }
        if (result == 0) {
            result=this.descricao.compareTo(o.descricao);
        }
        return result;
    }
}
