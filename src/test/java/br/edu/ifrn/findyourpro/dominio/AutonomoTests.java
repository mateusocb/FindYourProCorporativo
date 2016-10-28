/*
 * Copyright 2016-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.edu.ifrn.findyourpro.dominio;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutonomoTests {

    private static final String CPF1 = "400";
    private static final String CPF2 = "500";
    private static final String ENCANADOR = "encanador";
    private static final String ELETRICISTA = "eletricista";

    @Test
    public void cpfEDescricaoIguais() {
        assertThat(Autonomo.builder().cpf(CPF1).descricao(ENCANADOR).build())
                .isEqualTo(Autonomo.builder().cpf(CPF1).descricao(ENCANADOR).build());
    }

    @Test
    public void cpfIgualEDescricaoDiferente() {
        assertThat(Autonomo.builder().cpf(CPF1).descricao(ENCANADOR).build())
                .isEqualTo(Autonomo.builder().cpf(CPF1).descricao(ELETRICISTA).build());
    }

    @Test
    public void cpfDiferenteEDescricaoIgual() {
        assertThat(Autonomo.builder().cpf(CPF1).descricao(ENCANADOR).build())
                .isNotEqualTo(Autonomo.builder().cpf(CPF2).descricao(ENCANADOR).build());
    }

    @Test
    public void cpfEDescricaoDiferente() {
        assertThat(Autonomo.builder().cpf(CPF1).descricao(ENCANADOR).build())
                .isNotEqualTo(Autonomo.builder().cpf(CPF2).descricao(ELETRICISTA).build());
    }

    @Test
    public void compareTo() {
        Set<Autonomo> autonomos = new TreeSet<>();

        Autonomo eletricista = Autonomo.builder().cpf(CPF2)
                .descricao(ELETRICISTA)
                .build();
        autonomos.add(eletricista);
        Autonomo encanador = Autonomo.builder().cpf(CPF1)
                .descricao(ENCANADOR)
                .build();
        autonomos.add(encanador);

        assertThat(autonomos.iterator().next()).isEqualTo(encanador);
    }
}