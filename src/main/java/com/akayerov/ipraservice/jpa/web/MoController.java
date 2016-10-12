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
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
import com.akayerov.ipraservice.jpa.service.CityService;
import com.akayerov.ipraservice.jpa.service.MoDAO;
import com.akayerov.ipraservice.jpa.service.MoService;

//@Controller
@RestController
@CrossOrigin

public class MoController {

	@Autowired
	private MoDAO mo;
	@Autowired
	private MoService moService;

	
	@GetMapping("/mo1")
	@ResponseBody
	@Transactional(readOnly = true)
	public  List<Mo> moListRepository () {
        System.out.println("MoController (/mo1): Get  LIST MO"); 
		return this.moService.findAll();
	}

	@RequestMapping(path = "/mo1/{sid}", method = RequestMethod.GET)
	@ResponseBody
	@Transactional(readOnly = true)
	public  Mo moGetById1 (@PathVariable String sid, Model model) {
        System.out.println("MoController (/mo1): Get id=" + sid); 
		return this.moService.getMo(Integer.parseInt(sid));
	}

	@RequestMapping(path = "/mo1/{sid}", method = RequestMethod.PUT)
	@ResponseBody
	@Transactional(readOnly = false)
	public  void moUpdate (@PathVariable String sid, @RequestBody Mo input, Model model) {
        System.out.println("MoController (/mo1): Put"); 
 // простой метод через репозиторий почему то не работает, будем делать через DAO
  //      this.moService.update(input);
        int id = input.getId(); 
        if(id > 0)
          this.mo.update(id, input);
        else
          this.mo.save(input);
	}
// Пока не знаю как будет использоваться POST
	@RequestMapping(path = "/mo1/{sid}", method = RequestMethod.POST)
	@ResponseBody
	@Transactional(readOnly = false)
	public  void moCreate (@PathVariable String sid, @RequestBody Mo input, Model model) {
        System.out.println("MoController (/mo1): Post"); 
 // простой метод через репозиторий почему то не работает, будем делать через DAO
  //      this.moService.update(input);
  //      this.mo.save(input);
	}

	@DeleteMapping("/mo1/{sid}")
	@ResponseBody
	@Transactional(readOnly = false)
	public  void moDeleteRepository (@PathVariable String sid, @RequestBody Mo input, Model model) {
        System.out.println("MoController (/mo1): Delete"); 
        this.mo.delete(input);
	}

}
