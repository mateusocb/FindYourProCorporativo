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

@Named
public class InstituicaoFabrica {
	private static final String CNPJ1 = "400";
	private static final String CNPJ2 = "500";

	@Inject
	private InstituicaoRepository instituicaoRepository;

	public Instituicao instituicao(String cnpj) {
		Instituicao instituicao = this.instituicaoRepository.findByCnpj(cnpj);
		if (instituicao == null) {
			instituicao = Instituicao.builder()
				.cnpj(cnpj)
				.build();
			this.instituicaoRepository.save(instituicao);
		}
		return instituicao;
	}

	public Instituicao IFRN() {
		return instituicao(CNPJ1);
	}

	public Instituicao UFRN() {
		return instituicao(CNPJ2);
	}
}
