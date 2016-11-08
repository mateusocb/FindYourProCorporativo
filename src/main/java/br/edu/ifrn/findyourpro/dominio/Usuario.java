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
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
 * Usuario entity.
 *
 * @author Johann Guerra
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "login")
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_usuario", name = "ID_SEQUENCE", allocationSize = 1)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Usuario implements Serializable, Comparable<Usuario> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	private Long id;

	@OneToOne
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_usuario_localizacao"))
	private Localizacao endereco;

	@Column(nullable = false, name="telefone")
	private String telefone;

	@Column(nullable = false, unique = true, name="login")
	private String login;

	@Column(nullable = false, name="nome")
	private String nome;

	@Column(nullable = false, name="senha")
	private String senha;

	@Override
	public int compareTo(Usuario o) {
		return this.login.compareTo(o.login);
	}
}
