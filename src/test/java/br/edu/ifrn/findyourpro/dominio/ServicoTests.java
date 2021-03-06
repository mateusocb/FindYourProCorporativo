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

public class ServicoTests {

	private static final String TIPO1 = "eletricista";
	private static final String TIPO2 = "encanador";
	private static final String DESCRICAO1 = "luz";
	private static final String DESCRICAO2 = "agua";
	private static final String NOME3 = "Mateus";
	private static final String LOGIN3 = "mateusocb";
	private static final String SENHA3 = "mesa";
	private static final String CPF1 = "400";

	private Usuario getUsuario() {
		return Usuario.builder().nome(NOME3).login(LOGIN3).senha(SENHA3).build();
	}

	private Autonomo autonomo() {
		return Autonomo.builder().usuario(this.getUsuario()).cpf(CPF1).build();
	}

	@Test
	public void tipoEDescricaoIguais() {
		assertThat(Servico.builder().tipo(TIPO1).descricao(DESCRICAO1).prestador(this.autonomo()).build())
				.isEqualTo(Servico.builder().tipo(TIPO1).descricao(DESCRICAO1).prestador(this.autonomo()).build());
	}

	@Test
	public void tipoEDescricaoDiferentes() {
		assertThat(Servico.builder().tipo(TIPO1).descricao(DESCRICAO1).prestador(this.autonomo()).build())
				.isNotEqualTo(Servico.builder().tipo(TIPO2).descricao(DESCRICAO2).prestador(this.autonomo()).build());
	}

	@Test
	public void tipoIgualDescricaoDiferente() {
		assertThat(Servico.builder().tipo(TIPO1).descricao(DESCRICAO1).prestador(this.autonomo()).build())
				.isNotEqualTo(Servico.builder().tipo(TIPO1).descricao(DESCRICAO2).prestador(this.autonomo()).build());
	}

	@Test
	public void descricaoIgualTipoDiferente() {
		assertThat(Servico.builder().tipo(TIPO1).descricao(DESCRICAO1).prestador(this.autonomo()).build())
				.isNotEqualTo(Servico.builder().tipo(TIPO2).descricao(DESCRICAO1).prestador(this.autonomo()).build());
	}

	@Test
	public void compareToComTiposDiferentes() {
		Set<Servico> servicos = new TreeSet<>();

		Servico servico1 = Servico.builder().tipo(TIPO1).descricao(DESCRICAO1).prestador(this.autonomo()).build();
		Servico servico2 = Servico.builder().tipo(TIPO2).descricao(DESCRICAO1).prestador(this.autonomo()).build();
		servicos.add(servico2);
		servicos.add(servico1);

		assertThat(servicos.iterator().next()).isEqualTo(servico1);
	}

	@Test
	public void compareToComDescricoesDiferentes() {
		Set<Servico> servicos = new TreeSet<>();

		Servico servico1 = Servico.builder().tipo(TIPO1).descricao(DESCRICAO1).prestador(this.autonomo()).build();
		Servico servico2 = Servico.builder().tipo(TIPO1).descricao(DESCRICAO2).prestador(this.autonomo()).build();
		servicos.add(servico1);
		servicos.add(servico2);

		assertThat(servicos.iterator().next()).isEqualTo(servico2);
	}
}
