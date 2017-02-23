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

package br.edu.ifrn.findyourpro.servico;

import javax.inject.Inject;

import br.edu.ifrn.findyourpro.FindYourProApplication;
import br.edu.ifrn.findyourpro.dominio.Usuario;
import br.edu.ifrn.findyourpro.persistencia.UsuarioFabrica;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FindYourProApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UsuarioServicoIT {

	@Inject
	private UsuarioServico usuarioServico;

	@Inject
	private UsuarioFabrica usuarioFabrica;

	@Test
	public void repositorioNaoEhNulo() {
		assertThat(this.usuarioServico)
				.isNotNull();
	}

	@Test
	public void salvarUm() {
		// executa a operacao a ser testada
		Usuario usuario = this.usuarioFabrica.johann();

		// verifica o efeito da execucao da operacao a ser testada
		assertThat(usuario.getId())
				.isNotNull();
	}

	@Test
	public void deletarUm() {
		// cria o ambiente de teste
		Usuario usuario = this.usuarioFabrica.thiago();

		// executa a operacao a ser testada
		this.usuarioServico.delete(usuario);

		// verifica o efeito da execucao da operacao a ser testada
		assertThat(this.usuarioServico.findOne(usuario.getId()))
				.isNull();
	}
}
