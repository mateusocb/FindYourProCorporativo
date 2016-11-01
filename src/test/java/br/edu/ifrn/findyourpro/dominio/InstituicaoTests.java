package br.edu.ifrn.findyourpro.dominio;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InstituicaoTests {

    private static final String CNPJ1 = "400";
    private static final String CNPJ2 = "500";
    private static final String NOMEFANTASIA1 = "IFRN";
    private static final String NOMEFANTASIA2 = "UFRN";

    @Test
    public void cnpjENomefantasiaIguais() {
        assertThat(Instituicao.builder().cnpj(CNPJ1).nomeFantasia(NOMEFANTASIA1).build())
                .isEqualTo(Instituicao.builder().cnpj(CNPJ1).nomeFantasia(NOMEFANTASIA1).build());
    }

    @Test
    public void cnpjIgualENomefantasiaDiferente() {
        assertThat(Instituicao.builder().cnpj(CNPJ1).nomeFantasia(NOMEFANTASIA1).build())
                .isEqualTo(Instituicao.builder().cnpj(CNPJ1).nomeFantasia(NOMEFANTASIA2).build());
    }

    @Test
    public void cnpjDiferenteENomefantasiaIgual() {
        assertThat(Instituicao.builder().cnpj(CNPJ1).nomeFantasia(NOMEFANTASIA1).build())
                .isNotEqualTo(Instituicao.builder().cnpj(CNPJ2).nomeFantasia(NOMEFANTASIA1).build());
    }

    @Test
    public void cnpjENomefantasiaDiferente() {
        assertThat(Instituicao.builder().cnpj(CNPJ1).nomeFantasia(NOMEFANTASIA1).build())
                .isNotEqualTo(Instituicao.builder().cnpj(CNPJ2).nomeFantasia(NOMEFANTASIA2).build());
    }

    @Test
    public void compareTo() {
        Set<Instituicao> instituicoes = new TreeSet<>();

        Instituicao instituicao1 = Instituicao.builder().cnpj(CNPJ1).nomeFantasia(NOMEFANTASIA1).build();
        instituicoes.add(instituicao1);
        Instituicao instituicao2 = Instituicao.builder().cnpj(CNPJ2).nomeFantasia(NOMEFANTASIA2).build();
        instituicoes.add(instituicao2);
    

        assertThat(instituicoes.iterator().next()).isEqualTo(instituicao1);
    }
}
