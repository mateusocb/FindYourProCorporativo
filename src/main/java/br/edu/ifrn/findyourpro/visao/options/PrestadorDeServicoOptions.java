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

import br.edu.ifrn.findyourpro.servico.AutonomoServico;
import br.edu.ifrn.findyourpro.servico.InstituicaoServico;
import br.edu.ifrn.findyourpro.dominio.PrestadorDeServico;

/**
 * Options de PrestadorDeServico.
 * @author Johann Guerra
 */
@ViewScoped
@Named
public class PrestadorDeServicoOptions extends Options<PrestadorDeServico, Long> {

	private static final long serialVersionUID = 1L;

	private transient AutonomoServico autonomo;

	private transient InstituicaoServico instituicao;

	@Inject
	public void setAutonomoServico(AutonomoServico autonomo) {
		this.autonomo = autonomo;
	}

	@Inject
	public void setInstituicaoServico(InstituicaoServico instituicao) {
		this.instituicao = instituicao;
	}

	@Override
	public String label(PrestadorDeServico e) {
		return e.getUsuario().getNome();
	}

	@Override
	protected Object key(PrestadorDeServico e) {
		return e.getId();
	}

	@Override
	protected List<PrestadorDeServico> fillList() {
		List<PrestadorDeServico> result = new ArrayList<>();

		result.addAll(toList(this.autonomo.findAll()));
		result.addAll(toList(this.instituicao.findAll()));

		return result;
	}
}
