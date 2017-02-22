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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

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
 *
 * @author Johann Guerra
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"latitude", "longitude"})
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_localizacao", name = "ID_SEQUENCE", allocationSize = 1)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Localizacao implements Serializable, Comparable<Localizacao> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	private Long id;

	@Column(nullable = true, name = "numero")
	private String numero;

	@Column(nullable = true, name = "rua")
	private String rua;

	@Column(nullable = true, name = "bairro")
	private String bairro;

	@Column(nullable = true, name = "cidade")
	private String cidade;

	@Column(nullable = true, name = "estado")
	private String estado;

	@Column(nullable = true, name = "cep")
	private String cep;

	@Column(nullable = false, name = "latitude")
	private String latitude;

	@Column(nullable = false, name = "longitude")
	private String longitude;

	@Column(nullable = true, name = "complemento")
	private String complemento;

	@Override
	public int compareTo(Localizacao o) {
		int result=0;
		if(this.cep!=null){
			result = this.cep.compareTo(o.cep);
		}
		if(this.latitude!=null && this.longitude!=null){
			if (result == 0) {
				result = this.latitude.compareTo(o.latitude);
			}
			if (result == 0) {
				result = this.longitude.compareTo(o.longitude);
			}
		}
		return result;
	}
}
