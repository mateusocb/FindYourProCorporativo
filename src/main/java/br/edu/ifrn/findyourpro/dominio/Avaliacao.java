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

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Autonomo entity.
 * @author Johann Guerra
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"nota", "descricao"})
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Avaliacao implements Comparable<Avaliacao> {

	private Servico servico;
	private Usuario cliente;
	private int nota;
	private String descricao;
	private Date data;

	@Override
	public int compareTo(Avaliacao o) {
		int result = this.data.compareTo(o.data);
		if (result == 0) {
			result = this.servico.compareTo(o.servico);
		}
		if (result == 0) {
			result = this.cliente.compareTo(o.cliente);
		}
		return result;
	}
}
