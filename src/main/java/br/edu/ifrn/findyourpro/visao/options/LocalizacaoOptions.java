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

package br.edu.ifrn.findyourpro.visao.options;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.edu.ifrn.findyourpro.dominio.Localizacao;

/**
 * Options de Localizacao.
 * @author Johann Guerra
 */
@ViewScoped
@Named
public class LocalizacaoOptions extends Options<Localizacao, Long> {

	private static final long serialVersionUID = 1L;

	@Override
	public String label(Localizacao e) {
		return "Latitude: "+e.getLatitude()+", Longitude: "+e.getLongitude();
	}

	@Override
	protected Object key(Localizacao e) {
		return e.getId();
	}

}
