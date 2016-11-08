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

	@Test(expected = NullPointerException.class)
	public void cpfIguais() {
		assertThat(Autonomo.builder().usuario(this.getUsuario1()).
				cpf(CPF1).build())
				.isEqualTo(Autonomo.builder().usuario(this.getUsuario1()).
						cpf(CPF1).build());
	}

	@Test(expected = NullPointerException.class)
	public void cpfDiferente() {
		assertThat(Autonomo.builder().cpf(CPF1).
				usuario(this.getUsuario1()).build())
				.isNotEqualTo(Autonomo.builder().cpf(CPF2).
						usuario(this.getUsuario2()).build());
	}

	@Test(expected = NullPointerException.class)
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
