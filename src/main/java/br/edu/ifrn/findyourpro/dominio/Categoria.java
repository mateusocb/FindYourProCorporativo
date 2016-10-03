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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

/**
 * Categoria entity.
 * @author Marcelo Fernandes
 */
@Getter
@Setter
@ToString(exclude = "contas")
@EqualsAndHashCode(exclude = {"id", "contas"})
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_categoria", name = "ID_SEQUENCE", allocationSize = 1)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Categoria implements Serializable, Comparable<Categoria> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	private Long id;

	@Column(nullable = false, unique = true)
	private String descricao;

	@Singular
	@OneToMany(mappedBy = "categoria")
	private Set<Conta> contas;

	@Override
	public int compareTo(Categoria o) {
		int result = 0;
		if (this.descricao != null && o.descricao != null) {
			result = this.descricao.compareTo(o.descricao);
		}
		else if (this.descricao == null && o.descricao == null) {
			result = 0;
		}
		else if (this.descricao == null) {
			result = -1;
		}
		else {
			result = +1;
		}
		return result;
	}

}
