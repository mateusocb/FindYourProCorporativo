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

import br.edu.ifrn.conta.dominio.Categoria;
import br.edu.ifrn.conta.dominio.ContaDebito;

@Named
public class ContaDebitoFabrica {

	public final static String GASOLINA = "gasolina";
	public final static String DESPESA_CONJUGE = "despesa com cônjuge";

	@Inject
	private ContaDebitoRepository contaDebitoRepository;

	@Inject
	private CategoriaFabrica categoriaFabrica;

	private ContaDebito contaDebito(String descricao, Categoria categoria) {
		ContaDebito contaDebito = this.contaDebitoRepository.findByDescricao(descricao);
		if (contaDebito == null) {
			contaDebito = ContaDebito.builder()
				.descricao(descricao)
				.categoria(categoria)
				.build();
			this.contaDebitoRepository.save(contaDebito);
		}
		return contaDebito;
	}

	public ContaDebito gasolina() {
		return contaDebito(GASOLINA, this.categoriaFabrica.transporte());
	}

	public ContaDebito despesaComConjuge() {
		return contaDebito(DESPESA_CONJUGE, this.categoriaFabrica.categoriaDespesaConjuge());
	}
}
