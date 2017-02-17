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

package br.edu.ifrn.findyourpro.persistencia;

import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrn.findyourpro.dominio.Localizacao;
import br.edu.ifrn.findyourpro.dominio.Usuario;

@Named
public class UsuarioFabrica {

	private static final String LOGIN1 = "jhannn";
	private static final String LOGIN2 = "mateusocb";
	private static final String LOGIN3 = "w3ndell";
	private static final String NOME1 = "johann";
	private static final String NOME2 = "mateus";
	private static final String NOME3 = "wendell";
	private static final String SENHA1 = "seilafio";
	private static final String SENHA2 = "soufodao";
	private static final String SENHA3 = "euamojogos";

	@Inject
	private UsuarioRepository usuarioRepository;

	@Inject
	private LocalizacaoFabrica localizacaoFabrica;

	public Usuario usuario(String login, String nome, String senha, Localizacao localizacao) {
		Usuario usuario = this.usuarioRepository.findByLogin(login);
		if (usuario == null) {
		usuario = Usuario.builder()
			.login(login)
			.nome(nome)
			.senha(senha)
			.localizacao(localizacao)
			.build();
		this.usuarioRepository.save(usuario);
		}
		return usuario;
	}

	public Usuario johann() {
		return usuario(LOGIN1, NOME1, SENHA1, this.localizacaoFabrica.ifrn());
	}

	public Usuario mateus() {
		return usuario(LOGIN2, NOME2, SENHA2, this.localizacaoFabrica.midway());
	}

	public Usuario wendell() {
		return usuario(LOGIN3, NOME3, SENHA3, this.localizacaoFabrica.ifrn());
	}
}
