/*
 * Copyright 2017 FindYourPro.
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
package br.edu.ifrn.findyourpro.persistencia;

import javax.inject.Inject;

import br.edu.ifrn.findyourpro.FindYourProApplication;
import br.edu.ifrn.findyourpro.dominio.Usuario;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author johan
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FindYourProApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UsuarioRepositoryIT {
	
	@Inject
	private UsuarioRepository usuarioRepository;

	@Inject
	private UsuarioFabrica usuarioFabrica;

	@Test
	public void repositorioNaoEhNulo() {
		assertThat(this.usuarioRepository)
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
		Usuario usuario = this.usuarioFabrica.usuario("mateus");

		// executa a operacao a ser testada
		this.usuarioRepository.delete(usuario);

		// verifica o efeito da execucao da operacao a ser testada
		assertThat(this.usuarioRepository.findOne(usuario.getId()))
			.isNull();
	}
}
