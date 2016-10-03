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

package br.edu.ifrn.findyourpro.servico;

import java.io.Serializable;

import javax.inject.Named;

import br.edu.ifrn.findyourpro.dominio.Conta;

/**
 * Servico de Conta.
 * @param <T> tipo da conta
 * @param <ID> tipo do id da conta
 * @author Marcelo Fernandes
 */
@Named
public class ContaServico<T extends Conta, ID extends Serializable> extends CrudServico<T, ID> {
}
