/*
 * Copyright 2017 FindYourPro.
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

import br.edu.ifrn.findyourpro.dominio.Localizacao;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author johan
 */

@Named
public class LocalizacaoFabrica {
	
	public final static String IFRN = "100";
	public final static String IFRN1 = "250";
	public final static String MIDWAY = "100";
	public final static String MIDWAY1 = "255";

	@Inject
	private LocalizacaoRepository localizacaoRepository;

	public Localizacao localizacao(String latitude, String longitude) {
		Localizacao localizacao = this.localizacaoRepository.findByLatitudeAndLongitude(latitude, longitude);
		if (localizacao == null) {
			localizacao = Localizacao.builder()
				.latitude(latitude)
				.longitude(longitude)
				.build();
			this.localizacaoRepository.save(localizacao);
		}
		return localizacao;
	}

	public Localizacao ifrn() {
		return localizacao(IFRN, IFRN1);
	}

	public Localizacao midway() {
		return localizacao(MIDWAY, MIDWAY1);
	}
}
