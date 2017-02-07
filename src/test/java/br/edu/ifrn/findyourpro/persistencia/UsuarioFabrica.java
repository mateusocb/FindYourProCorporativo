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

import br.edu.ifrn.findyourpro.dominio.Usuario;

@Named
class UsuarioFabrica {

	private static final String JOHANN = "johann";
	private static final String MATEUS = "mateus";

	@Inject
	private UsuarioRepository usuarioRepository;

	public Usuario usuario(String login) {
		Usuario usuario = this.usuarioRepository.findByLogin(login);
		if (usuario == null) {
		usuario = Usuario.builder()
			.login(login)
			.build();
		this.usuarioRepository.save(usuario);
		}
		return usuario;
	}

	public Usuario johann() {
		return usuario(JOHANN);
	}

	public Usuario mateus() {
		return usuario(MATEUS);
	}
}
