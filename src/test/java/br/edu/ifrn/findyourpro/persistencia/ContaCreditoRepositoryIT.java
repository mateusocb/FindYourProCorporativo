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

import br.edu.ifrn.conta.ContaApplication;
import br.edu.ifrn.conta.dominio.Categoria;
import br.edu.ifrn.conta.dominio.ContaCredito;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ContaCreditoRepositoryIT {

	@Inject
	private ContaCreditoRepository contaCreditoRepository;

	@Inject
	private ContaCreditoFabrica contaCreditoFabrica;

	@Test
	public void repositorioNaoEhNulo() {
		assertThat(this.contaCreditoRepository).isNotNull();
	}

	@Test
	public void findOneByExample() {
		// cria o ambiente de teste
		ContaCredito contaCredito = this.contaCreditoFabrica.estagio();

		ContaCredito contaCreditoExemplo = ContaCredito.builder()
			.categoria(Categoria.builder().descricao(CategoriaFabrica.SALARIO).build())
			.build();

		// executa a operacao a ser testada
		// verifica o efeito da execucao da operacao a ser testada
		assertThat(this.contaCreditoRepository.findOne(Example.of(contaCreditoExemplo)))
			.isEqualTo(contaCredito);
	}

}
