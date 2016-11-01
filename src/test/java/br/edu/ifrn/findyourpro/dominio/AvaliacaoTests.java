'package br.edu.ifrn.findyourpro.dominio;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AvaliacaoTests {

    private static final String TIPO_SERVICO1 = "eletricista";
    private static final String TIPO_SERVICO2 = "encanador";
    private static final String DESCRICAO_SERVICO1 = "servico muito bom";
    private static final String DESCRICAO_SERVICO2 = "servico muito ruim";
    private static final String LOGIN1 = "johann";
    private static final String LOGIN2 = "mateus";
    private static final int NOTA1 = 10;
    private static final int NOTA2 = 5;
    private static final String DESCRICAO1 = "ele fez bem";
    private static final String DESCRICAO2 = "ele fez mal";

    private Avaliacao avaliacao(String tipoServico, String descricaoServico, String login, int nota, String descricao, Date data) {
        return Avaliacao.builder()
                .servico(Servico.builder().tipo(tipoServico).descricao(descricaoServico).build())
                .cliente(Usuario.builder().login(login).build())
                .nota(nota)
                .descricao(descricao)
                .data(data)
                .build();
    }

    @Test
    public void avalicaoServicoUsuarioDataIguaisDescricaoNotaDiferentes() {
        Date hoje = new Date();

        Avaliacao avaliacao1 = avaliacao(TIPO_SERVICO1, DESCRICAO_SERVICO1, LOGIN1, NOTA1, DESCRICAO1, hoje);
        Avaliacao avaliacao2 = avaliacao(TIPO_SERVICO1, DESCRICAO_SERVICO1, LOGIN1, NOTA2, DESCRICAO2, hoje);

        assertThat(avaliacao1).isEqualTo(avaliacao2);
    }

    @Test
    public void avalicaoServicoUsuarioDataDiferentesDescricaoNotaIguais() {
        Avaliacao avaliacao1 = avaliacao(TIPO_SERVICO1, DESCRICAO_SERVICO1, LOGIN1, NOTA1, DESCRICAO1, new Date());
        Avaliacao avaliacao2 = avaliacao(TIPO_SERVICO2, DESCRICAO_SERVICO2, LOGIN2, NOTA1, DESCRICAO1, new Date());

        assertThat(avaliacao1).isNotEqualTo(avaliacao2);
    }

    @Test
    public void compareToComDatasDiferentes() {
        Set<Avaliacao> avaliacoes = new TreeSet<>();

        Avaliacao avaliacao1 = avaliacao(TIPO_SERVICO1, DESCRICAO_SERVICO1, LOGIN1, NOTA1, DESCRICAO1, new Date());
        Avaliacao avaliacao2 = avaliacao(TIPO_SERVICO1, DESCRICAO_SERVICO1, LOGIN1, NOTA1, DESCRICAO1, new Date());
        avaliacoes.add(avaliacao2);
        avaliacoes.add(avaliacao1);

        assertThat(avaliacoes.iterator().next()).isEqualTo(avaliacao1);
    }

    @Test
    public void compareToComServicosDiferentes() {
        Date hoje = new Date();

        Set<Avaliacao> avaliacoes = new TreeSet<>();

        Avaliacao avaliacao1 = avaliacao(TIPO_SERVICO1, DESCRICAO_SERVICO1, LOGIN1, NOTA1, DESCRICAO1, hoje);
        Avaliacao avaliacao2 = avaliacao(TIPO_SERVICO2, DESCRICAO_SERVICO2, LOGIN1, NOTA1, DESCRICAO1, hoje);
        avaliacoes.add(avaliacao2);
        avaliacoes.add(avaliacao1);

        assertThat(avaliacoes.iterator().next()).isEqualTo(avaliacao1);
    }

    @Test
    public void compareToComUsuariosDiferentes() {
        Date hoje = new Date();

        Set<Avaliacao> avaliacoes = new TreeSet<>();

        Avaliacao avaliacao1 = avaliacao(TIPO_SERVICO1, DESCRICAO_SERVICO1, LOGIN1, NOTA1, DESCRICAO1, hoje);
        Avaliacao avaliacao2 = avaliacao(TIPO_SERVICO1, DESCRICAO_SERVICO1, LOGIN2, NOTA1, DESCRICAO1, hoje);
        avaliacoes.add(avaliacao2);
        avaliacoes.add(avaliacao1);

        assertThat(avaliacoes.iterator().next()).isEqualTo(avaliacao1);
    }
}
