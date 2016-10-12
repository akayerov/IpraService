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

package com.akayerov.ipraservice.jpa.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import com.akayerov.ipraservice.jpa.domain.Mo;
import com.akayerov.ipraservice.jpa.service.CityService;
import com.akayerov.ipraservice.jpa.service.MoDAO;
import com.akayerov.ipraservice.jpa.service.MoService;

@Controller
  public class SampleController  {

	@Autowired
	private CityService cityService;
	@Autowired
	private MoDAO mo;
	@Autowired
	private MoService moService;

	
	@GetMapping("/mo")
	@ResponseBody
	@Transactional(readOnly = true)
	public String helloWorld() {
//		return this.cityService.getCity("Bath", "UK").getName();
		return this.mo.getById(3).getName();
	}

	@GetMapping("/molist")
	@ResponseBody
	@Transactional(readOnly = true)
	public List<Mo> moList () {
		return this.mo.list();
	}

	@GetMapping("/morepo")
	@ResponseBody
	@Transactional(readOnly = true)
	public  List<Mo> moListRepository () {
		return this.moService.findAll();
/*
	public  Page<Mo> moListRepository () {
		return this.moService.findMo(new Pageable() {
			
			@Override
			public Pageable previousOrFirst() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Pageable next() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean hasPrevious() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Sort getSort() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getPageSize() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getPageNumber() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getOffset() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Pageable first() {
				// TODO Auto-generated method stub
				return null;
			}
		});
*/
	}


}
