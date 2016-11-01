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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Localizacao entity.
 * @author Johann Guerra
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"latitude", "longitude"})
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Localizacao implements Comparable<Localizacao> {

	private String numero;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String latitude;
	private String longitude;
	private String complemento;

	@Override
	public int compareTo(Localizacao o) {
		int result = this.cep.compareTo(o.cep);
		if (result == 0) {
			result = this.latitude.compareTo(o.latitude);
		}
		if (result == 0) {
			result = this.longitude.compareTo(o.longitude);
		}
		return result;
	}
}
