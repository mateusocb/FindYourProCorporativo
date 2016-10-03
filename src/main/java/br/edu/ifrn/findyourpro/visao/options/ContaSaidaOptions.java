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

package br.edu.ifrn.findyourpro.visao.options;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrn.findyourpro.dominio.Conta;
import br.edu.ifrn.findyourpro.servico.ContaCreditoServico;
import br.edu.ifrn.findyourpro.servico.ContaPatrimonioServico;

/**
 * Options de ContaSaida.
 * @author Marcelo Fernandes
 */
@ViewScoped
@Named
public class ContaSaidaOptions extends Options<Conta, Long> {

	private static final long serialVersionUID = 1L;

	private transient ContaCreditoServico contaCreditoServico;

	private transient ContaPatrimonioServico contaPatrimonioServico;

	@Inject
	public void setContaCreditoServico(ContaCreditoServico contaCreditoServico) {
		this.contaCreditoServico = contaCreditoServico;
	}

	@Inject
	public void setContaPatrimonioServico(ContaPatrimonioServico contaPatrimonioServico) {
		this.contaPatrimonioServico = contaPatrimonioServico;
	}

	@Override
	public String label(Conta e) {
		return e.getDescricao() + " - " + e.getCategoria().getDescricao();
	}

	@Override
	protected Object key(Conta e) {
		return e.getId();
	}

	@Override
	protected List<Conta> fillList() {
		List<Conta> result = new ArrayList<>();

		result.addAll(toList(this.contaCreditoServico.findAll()));
		result.addAll(toList(this.contaPatrimonioServico.findAll()));

		return result;
	}

}
