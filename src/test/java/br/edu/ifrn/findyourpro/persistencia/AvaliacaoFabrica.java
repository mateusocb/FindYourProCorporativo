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

import br.edu.ifrn.findyourpro.dominio.Avaliacao;
import br.edu.ifrn.findyourpro.dominio.Servico;
import br.edu.ifrn.findyourpro.dominio.Usuario;
import java.util.Date;

@Named
public class AvaliacaoFabrica {

	private static final int NOTA1 = 10;
	private static final int NOTA2 = 5;

	@Inject
	private AvaliacaoRepository avaliacaoRepository;

	@Inject
	private ServicoFabrica servicoFabrica;

	@Inject
	private UsuarioFabrica usuarioFabrica;

	public Avaliacao avaliacao(int nota, Servico servico, Usuario cliente) {
		Avaliacao avaliacao = this.avaliacaoRepository.findByNotaAndServicoAndUsuario(nota, servico, cliente);
		if (avaliacao == null) {
			Date data= new Date();
			avaliacao = Avaliacao.builder()
				.servico(servico)
				.cliente(cliente)
				.nota(nota)
				.data(data)
				.build();
			this.avaliacaoRepository.save(avaliacao);
		}
		return avaliacao;
	}

	public Avaliacao nota10() {
		return avaliacao(NOTA1,this.servicoFabrica.eletrico(), this.usuarioFabrica.johann());
	}

	public Avaliacao nota5() {
		return avaliacao(NOTA1,this.servicoFabrica.encanamento(), this.usuarioFabrica.johann());
	}
}
