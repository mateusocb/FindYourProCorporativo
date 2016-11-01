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
import java.util.TreeSet;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalizacaoTests {

	private static final String LATITUDE1 = "500";
	private static final String LATITUDE2 = "600";
	private static final String LONGITUDE1 = "400";
	private static final String LONGITUDE2 = "450";
	private static final String CEP1 = "10";
	private static final String CEP2 = "20";

	@Test
	public void latitudeLongitudeECepIguais() {
		assertThat(Localizacao.builder().latitude(LATITUDE1).longitude(LONGITUDE1).cep(CEP1).build())
				.isEqualTo(Localizacao.builder().latitude(LATITUDE1).longitude(LONGITUDE1).cep(CEP1).build());
	}

	@Test
	public void latitudeELongitudeIguaisCepDiferente() {
		assertThat(Localizacao.builder().latitude(LATITUDE1).longitude(LONGITUDE1).cep(CEP1).build())
				.isEqualTo(Localizacao.builder().latitude(LATITUDE1).longitude(LONGITUDE1).cep(CEP2).build());
	}

	@Test
	public void latitudeDiferenteLongitudeECepIguais() {
		assertThat(Localizacao.builder().latitude(LATITUDE1).longitude(LONGITUDE1).cep(CEP1).build())
				.isNotEqualTo(Localizacao.builder().latitude(LATITUDE2).longitude(LONGITUDE1).cep(CEP1).build());
	}

	@Test
	public void longitudeDiferenteLatitudeECepIguais() {
		assertThat(Localizacao.builder().latitude(LATITUDE1).longitude(LONGITUDE1).cep(CEP1).build())
				.isNotEqualTo(Localizacao.builder().latitude(LATITUDE1).longitude(LONGITUDE2).cep(CEP1).build());
	}

	@Test
	public void cepIgualLatitudeELongitudeDiferentes() {
		assertThat(Localizacao.builder().latitude(LATITUDE1).longitude(LONGITUDE1).cep(CEP1).build())
				.isNotEqualTo(Localizacao.builder().latitude(LATITUDE2).longitude(LONGITUDE2).cep(CEP1).build());
	}

	@Test
	public void latitudeLongitudeCepDiferentes() {
		assertThat(Localizacao.builder().latitude(LATITUDE1).longitude(LONGITUDE1).cep(CEP1).build())
				.isNotEqualTo(Localizacao.builder().latitude(LATITUDE2).longitude(LONGITUDE2).cep(CEP2).build());
	}

	@Test
	public void compareToComCepsDiferentes() {
		Set<Localizacao> localizacoes = new TreeSet<>();

		Localizacao localizacao1 = Localizacao.builder().latitude(LATITUDE1).longitude(LONGITUDE1).cep(CEP1).build();
		Localizacao localizacao2 = Localizacao.builder().latitude(LATITUDE1).longitude(LONGITUDE1).cep(CEP2).build();
		localizacoes.add(localizacao2);
		localizacoes.add(localizacao1);

		assertThat(localizacoes.iterator().next()).isEqualTo(localizacao1);
	}

	@Test
	public void compareToComLatitudesDiferentes() {
		Set<Localizacao> localizacoes = new TreeSet<>();

		Localizacao localizacao1 = Localizacao.builder().latitude(LATITUDE1).longitude(LONGITUDE1).cep(CEP1).build();
		Localizacao localizacao2 = Localizacao.builder().latitude(LATITUDE2).longitude(LONGITUDE1).cep(CEP1).build();
		localizacoes.add(localizacao2);
		localizacoes.add(localizacao1);

		assertThat(localizacoes.iterator().next()).isEqualTo(localizacao1);
	}

	@Test
	public void compareToComLongitudesDiferentes() {
		Set<Localizacao> localizacoes = new TreeSet<>();

		Localizacao localizacao1 = Localizacao.builder().latitude(LATITUDE1).longitude(LONGITUDE1).cep(CEP1).build();
		Localizacao localizacao2 = Localizacao.builder().latitude(LATITUDE1).longitude(LONGITUDE2).cep(CEP1).build();
		localizacoes.add(localizacao2);
		localizacoes.add(localizacao1);

		assertThat(localizacoes.iterator().next()).isEqualTo(localizacao1);
	}
}
