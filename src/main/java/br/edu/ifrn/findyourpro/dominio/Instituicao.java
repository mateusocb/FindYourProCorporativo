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
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Instituicao entity.
 *
 * @author Johann Guerra
 */
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, of = "cnpj")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Instituicao extends PrestadorDeServico implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_instituicao_localizacao"))
	private Localizacao endereco;

	@Column(nullable = false, name = "telefone")
	private String telefone;

	@Column(nullable = false, name = "nomeFantasia")
	private String nomeFantasia;

	@Column(unique = true, nullable = false, name = "cnpj")
	private String cnpj;

	@Builder
	public Instituicao(Long id, Usuario user, Set<Servico> servicos,
			Localizacao endereco, String telefone, String nomeFantasia,
			String cnpj) {
		super(id, user, servicos);
		this.endereco = endereco;
		this.telefone = telefone;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
	}
}
