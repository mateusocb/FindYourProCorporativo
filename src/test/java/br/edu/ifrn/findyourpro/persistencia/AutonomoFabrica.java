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

import br.edu.ifrn.findyourpro.dominio.Autonomo;
import br.edu.ifrn.findyourpro.dominio.Usuario;

@Named
public class AutonomoFabrica {

	private static final String CPF1 = "400";
	private static final String CPF2 = "500";
	private static final String CPF3 = "600";

	@Inject
	private AutonomoRepository autonomoRepository;

	@Inject
	private UsuarioFabrica usuarioFabrica;

	public Autonomo autonomo(String cpf, Usuario usuario) {
		Autonomo autonomo = this.autonomoRepository.findByCpf(cpf);
		if (autonomo == null) {
			autonomo = Autonomo.builder()
				.cpf(cpf)
				.usuario(usuario)
				.build();
			this.autonomoRepository.save(autonomo);
		}
		return autonomo;
	}

	public Autonomo eletriscista() {
		return autonomo(CPF1, this.usuarioFabrica.johann());
	}

	public Autonomo encanador() {
		return autonomo(CPF2, this.usuarioFabrica.mateus());
	}

	public Autonomo ti() {
		return autonomo(CPF3, this.usuarioFabrica.wendell());
	}
}
