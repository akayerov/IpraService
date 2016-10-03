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
import com.akayerov.ipraservice.jpa.domain.Mse;

@Component("mseService")
@Transactional
class MseServiceImpl implements MseService {

	private final MseRepository mseRepository;

	public MseServiceImpl(MseRepository mseRepository) {
		this.mseRepository = mseRepository;
	}

	@Override
	public Page<Mse> findMse(Pageable pageable) {
		return this.mseRepository.findAll(pageable);
	}


	@Override
	public Mse getMse(int id) {
		return this.mseRepository.findById(id);
	}

	@Override
	public List<Mse> findAll() {
		return this.mseRepository.findAll();
	}

	@Override
	public void update(Mse mse) {
		System.out.println("Update Mse:" + mse);
// фигня -  метод save репозитория не работает, буду пробовать сохранять первоначальным способом, явно через интерфейс DAO
		this.mseRepository.save(mse); 
		
	}
}
