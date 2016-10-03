/*
 * Copyright 2012-2016 the original author or authors.
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

package com.akayerov.ipraservice.jpa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.akayerov.ipraservice.jpa.domain.City;
import com.akayerov.ipraservice.jpa.domain.HotelSummary;
import com.akayerov.ipraservice.jpa.domain.Mo;

@Component("moService")
@Transactional
class MoServiceImpl implements MoService {

	private final MoRepository moRepository;

	public MoServiceImpl(MoRepository moRepository) {
		this.moRepository = moRepository;
	}

	@Override
	public Page<Mo> findMo(Pageable pageable) {
		return this.moRepository.findAll(pageable);
	}


	@Override
	public Mo getMo(int id) {
		return this.moRepository.findById(id);
	}

	@Override
	public List<Mo> findAll() {
		return this.moRepository.findAll();
	}

	@Override
	public void update(Mo mo) {
		System.out.println("Update MO:" + mo);
// фигня -  метод save репозитория не работает, буду пробовать сохранять первоначальным способом, явно через интерфейс DAO
		this.moRepository.save(mo); 
		
	}
}
