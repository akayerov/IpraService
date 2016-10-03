/* CROSSORIGIN -ВАЖНО - я долго мучился с предполетными запросами
 *  @CrossOrigin - все встроено в Spring c версии 4.2
 *  В. т. ч и предполетные запросы OPTION  !!! (см. документацию!!!)
 *  Sencha везде где можно их использует
 *  отладка в броузере - в ответе сервера должно стоять разрешение на cross original и время alive
 *  Если сервер отвечает иначе то - ошибка 
 
 */
package com.akayerov.ipraservice.jpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.akayerov.ipraservice.jpa.domain.Mo;
import com.akayerov.ipraservice.jpa.domain.Mse;
import com.akayerov.ipraservice.jpa.service.CityService;
import com.akayerov.ipraservice.jpa.service.MoDAO;
import com.akayerov.ipraservice.jpa.service.MoService;
import com.akayerov.ipraservice.jpa.service.MseService;

//@Controller
@RestController
@CrossOrigin
public class MseController {

//	@Autowired
//	private MoDAO mo;
	@Autowired
	private MseService mseService;

	
	@GetMapping("/mse")
	@ResponseBody
	@Transactional(readOnly = true)
	public  List<Mse> moListRepository () {
        System.out.println("MseController (/mse): Get  LIST MSE"); 
		return this.mseService.findAll();
	}

	@RequestMapping(path = "/mse/{sid}", method = RequestMethod.GET)
	@ResponseBody
	@Transactional(readOnly = true)
	public  Mse moGetById1 (@PathVariable String sid, Model model) {
        System.out.println("MseController (/mse): Get id=" + sid); 
		return this.mseService.getMse(Integer.parseInt(sid));
	}

	@RequestMapping(path = "/mse/{sid}", method = RequestMethod.PUT)
	@ResponseBody
	@Transactional(readOnly = false)
	public  void mseUpdate (@PathVariable String sid, @RequestBody Mse input, Model model) {
        System.out.println("MseController (/mse): Put"); 
 // простой метод через репозиторий почему то не работает, будем делать через DAO
        this.mseService.update(input);
/*
        int id = input.getId(); 
        if(id > 0)
          this.mo.update(id, input);
        else
          this.mo.save(input);
 */         
	}
// Пока не знаю как будет использоваться POST
	@RequestMapping(path = "/mse/{sid}", method = RequestMethod.POST)
	@ResponseBody
	@Transactional(readOnly = false)
	public  void moCreate (@PathVariable String sid, @RequestBody Mo input, Model model) {
        System.out.println("(NOT MADE!!) MseController (/mse): Post"); 
	}

	@DeleteMapping("/mse/{sid}")
	@ResponseBody
	@Transactional(readOnly = false)
	public  void moDeleteRepository (@PathVariable String sid, @RequestBody Mse input, Model model) {
        System.out.println("(NOT MADE!!) MseController (/mse): Delete"); 
//        this.mo.delete(input);
	}

}
