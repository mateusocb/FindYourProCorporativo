package br.edu.ifrn.findyourpro.dominio;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutonomoTests {

    private static final String CPF1 = "400";
    private static final String CPF2 = "500";
    private static final String NOME1 = "Mateus";
    private static final String NOME2 = "Wendell";
    private static final String LOGIN1 = "mateusocb";
    private static final String LOGIN2 = "w3nd3ll";
    private static final String SENHA1 = "mesa";
    private static final String SENHA2 = "cadeira";

        
    private Usuario getUsuario1() {
        return Usuario.builder().nome(NOME1).login(LOGIN1).senha(SENHA1).build();
    }
    
    
    private Usuario getUsuario2() {
        return Usuario.builder().nome(NOME2).login(LOGIN2).senha(SENHA2).build();
    }
    
    @Test
    public void cpfIguais() {
        assertThat(Autonomo.builder().usuario(this.getUsuario1()).
                cpf(CPF1).build())
                .isEqualTo(Autonomo.builder().usuario(this.getUsuario1()).
                        cpf(CPF1).build());
    }
    
    @Test
    public void cpfDiferente() {
        assertThat(Autonomo.builder().cpf(CPF1).
                usuario(this.getUsuario1()).build())
                .isNotEqualTo(Autonomo.builder().cpf(CPF2).
                       usuario(this.getUsuario2()).build());
    }

    @Test
    public void compareTo() {
        Set<Autonomo> autonomos = new TreeSet<>();

        Autonomo autonomo2 = Autonomo.builder().usuario(this.getUsuario2())
                .build();
        autonomos.add(autonomo2);
        Autonomo autonomo1 = Autonomo.builder().usuario(this.getUsuario1())
                .build();
        autonomos.add(autonomo1);

        assertThat(autonomos.iterator().next()).isEqualTo(autonomo1);
    }
}