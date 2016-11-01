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

package br.edu.ifrn.findyourpro.dominio;

import java.util.Set;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Servico entity.
 * @author Johann Guerra
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = "prestadores")
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class Servico implements Comparable<Servico> {

	private String tipo;
	private String descricao;
	Set<PrestadorDeServico> prestadores;

	@Override
	public int compareTo(Servico o) {
		int result = this.tipo.compareTo(o.tipo);
		if (result == 0) {
			result = this.descricao.compareTo(o.descricao);
		}
		return result;
	}
}
