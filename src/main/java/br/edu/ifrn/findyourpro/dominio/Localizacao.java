package br.edu.ifrn.findyourpro.dominio;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
/*import lombok.NonNull;*/
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode()
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Localizacao implements Comparable<Localizacao> {

    private String numero;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String latitude;
    private String longitude;
    private String complemento;

    @Override
    public int compareTo(Localizacao o) {
        int result = this.cep.compareTo(o.cep);
        if (result == 0) {
            return this.latitude.compareTo(o.latitude);
        }
        if (result == 0) {
            return this.longitude.compareTo(o.longitude);
        }
        return result;
    }
}