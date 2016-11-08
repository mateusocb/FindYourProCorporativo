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

public class InstituicaoTests {

	private static final String CNPJ1 = "400";
	private static final String CNPJ2 = "500";
	private static final String NOMEFANTASIA1 = "IFRN";
	private static final String NOMEFANTASIA2 = "UFRN";

	@Test(expected = NullPointerException.class)
	public void cnpjENomefantasiaIguais() {
		assertThat(Instituicao.builder().cnpj(CNPJ1).nomeFantasia(NOMEFANTASIA1).build())
				.isEqualTo(Instituicao.builder().cnpj(CNPJ1).nomeFantasia(NOMEFANTASIA1).build());
	}

	@Test(expected = NullPointerException.class)
	public void cnpjIgualENomefantasiaDiferente() {
		assertThat(Instituicao.builder().cnpj(CNPJ1).nomeFantasia(NOMEFANTASIA1).build())
				.isEqualTo(Instituicao.builder().cnpj(CNPJ1).nomeFantasia(NOMEFANTASIA2).build());
	}

	@Test(expected = NullPointerException.class)
	public void cnpjDiferenteENomefantasiaIgual() {
		assertThat(Instituicao.builder().cnpj(CNPJ1).nomeFantasia(NOMEFANTASIA1).build())
				.isNotEqualTo(Instituicao.builder().cnpj(CNPJ2).nomeFantasia(NOMEFANTASIA1).build());
	}

	@Test(expected = NullPointerException.class)
	public void cnpjENomefantasiaDiferente() {
		assertThat(Instituicao.builder().cnpj(CNPJ1).nomeFantasia(NOMEFANTASIA1).build())
				.isNotEqualTo(Instituicao.builder().cnpj(CNPJ2).nomeFantasia(NOMEFANTASIA2).build());
	}

	@Test(expected = NullPointerException.class)
	public void compareTo() {
		Set<Instituicao> instituicoes = new TreeSet<>();

		Instituicao instituicao1 = Instituicao.builder().cnpj(CNPJ1).nomeFantasia(NOMEFANTASIA1).build();
		instituicoes.add(instituicao1);
		Instituicao instituicao2 = Instituicao.builder().cnpj(CNPJ2).nomeFantasia(NOMEFANTASIA2).build();
		instituicoes.add(instituicao2);

		assertThat(instituicoes.iterator().next()).isEqualTo(instituicao1);
	}
}
