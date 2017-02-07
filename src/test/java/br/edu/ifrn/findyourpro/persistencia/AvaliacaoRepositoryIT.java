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
import br.edu.ifrn.findyourpro.FindYourProApplication;
import br.edu.ifrn.findyourpro.dominio.Avaliacao;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 *
 * @author johan
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FindYourProApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class AvaliacaoRepositoryIT {

	@Inject
	private AvaliacaoRepository avaliacaoRepository;

	@Inject
	private AvaliacaoFabrica avaliacaoFabrica;

	@Test
	public void repositorioNaoEhNulo() {
		assertThat(this.avaliacaoRepository)
			.isNotNull();
	}

	@Test
	public void salvarUm() {
		// executa a operacao a ser testada
		Avaliacao avaliacao = this.avaliacaoFabrica.nota10();

		// verifica o efeito da execucao da operacao a ser testada
		assertThat(avaliacao.getId())
			.isNotNull();
	}

	@Test
	public void deletarUm() {
		// cria o ambiente de teste
		Avaliacao avaliacao = this.avaliacaoFabrica.nota5();

		// executa a operacao a ser testada
		this.avaliacaoRepository.delete(avaliacao);

		// verifica o efeito da execucao da operacao a ser testada
		assertThat(this.avaliacaoRepository.findOne(avaliacao.getId()))
			.isNull();
	}
}
