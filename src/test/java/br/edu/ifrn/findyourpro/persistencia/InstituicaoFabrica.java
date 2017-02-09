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

import br.edu.ifrn.findyourpro.dominio.Instituicao;
import br.edu.ifrn.findyourpro.dominio.Localizacao;
import br.edu.ifrn.findyourpro.dominio.Usuario;

@Named
public class InstituicaoFabrica {
	private static final String CNPJ1 = "400";
	private static final String CNPJ2 = "500";
	private static final String NOMEFANTASIA1 = "CHITOS";
	private static final String NOMEFANTASIA2 = "BOKUS";

	@Inject
	private InstituicaoRepository instituicaoRepository;

	@Inject
	private UsuarioFabrica usuarioFabrica;

	@Inject
	private LocalizacaoFabrica localizacaoFabrica;

	public Instituicao instituicao(String cnpj, String nomeFantasia, Usuario usuario, Localizacao endereco) {
		Instituicao instituicao = this.instituicaoRepository.findByCnpj(cnpj);
		if (instituicao == null) {
			instituicao = Instituicao.builder()
				.cnpj(cnpj)
				.nomeFantasia(nomeFantasia)
				.usuario(usuario)
				.endereco(endereco)
				.build();
			this.instituicaoRepository.save(instituicao);
		}
		return instituicao;
	}

	public Instituicao ifrn() {
		return instituicao(CNPJ1, NOMEFANTASIA1, this.usuarioFabrica.johann(), this.localizacaoFabrica.ifrn());
	}

	public Instituicao ufrn() {
		return instituicao(CNPJ2, NOMEFANTASIA2, this.usuarioFabrica.mateus(), this.localizacaoFabrica.midway());
	}
}
