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

import br.edu.ifrn.findyourpro.dominio.PrestadorDeServico;
import br.edu.ifrn.findyourpro.dominio.Servico;

@Named
public class ServicoFabrica {

	private static final String TIPO1 = "eletricista";
	private static final String TIPO2 = "encanador";
	private static final String DESCRICAO1 = "luz";
	private static final String DESCRICAO2 = "agua";

	@Inject
	private ServicoRepository servicoRepository;

	@Inject
	private AutonomoFabrica autonomoFabrica;


	public Servico servico(String tipo, String descricao, PrestadorDeServico autonomo) {
		Servico servico = this.servicoRepository.findByTipoAndDescricao(tipo, descricao);
		if (servico == null) {
			servico = Servico.builder()
				.tipo(tipo)
				.descricao(descricao)
				.prestador(autonomo)
				.build();
			this.servicoRepository.save(servico);
		}
		return servico;
	}

	public Servico eletrico() {
		return servico(TIPO1, DESCRICAO1, this.autonomoFabrica.eletriscista());
	}

	public Servico encanamento() {
		return servico(TIPO2, DESCRICAO2, this.autonomoFabrica.encanador());
	}

	public Servico ti() {
		return servico(TIPO2, DESCRICAO2, this.autonomoFabrica.ti());
	}
}
