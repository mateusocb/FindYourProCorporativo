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

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * PrestadorDeServico entity.
 *
 * @author Johann Guerra
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "usuario")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SequenceGenerator(sequenceName = "seq_prestadorDeServico", name = "ID_SEQUENCE", allocationSize = 1)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public abstract class PrestadorDeServico implements Serializable, Comparable<PrestadorDeServico> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	private Long id;

	@NonNull
	@ManyToOne
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_prestador_usuario"))
	private Usuario usuario;

	@NonNull
	@ManyToMany
	@JoinTable(foreignKey = @ForeignKey(name = "fk_prestadores_servicos"), name = "prestadores_servicos", joinColumns = {
		@JoinColumn(foreignKey = @ForeignKey(name = "fk_prestadores_servicos_prestador_id"), name = "prestadorDeServico_id")}, inverseJoinColumns = {
		@JoinColumn(name = "servico_id", foreignKey = @ForeignKey(name = "fk_servicos_prestadores_servico_id"))})
	private Set<Servico> servicos;

	@Override
	public int compareTo(PrestadorDeServico o) {
		if (o instanceof Instituicao && this instanceof Instituicao) {
			Instituicao a = (Instituicao) this;
			Instituicao b = (Instituicao) o;
			return a.getNomeFantasia().compareTo(b.getNomeFantasia());
		}
		else {
			return this.usuario.compareTo(o.usuario);
		}
	}
}