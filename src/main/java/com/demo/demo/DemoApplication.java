package com.demo.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bean.UserDetailsBean;
import com.demo.restServices.DemoRestController;
import com.demo.services.DemoServices;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = { "com.demo.restServices", "com.demo.bean"})
public class DemoApplication {
	@Autowired
	DemoRestController restController;
	@Autowired
	UserDetailsBean userBean;
	public static final Logger logger = LogManager.getLogger(DemoApplication.class);
	@Value("${spring.application.name}")
	private String appName;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		logger.warn("started");
	}

	@GetMapping("/home")
	public String homePage() {
		return restController.homePage();
	}

	// @GetMapping("/")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {
		return restController.index();
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping(value = "/saveUser/{name}", method = RequestMethod.POST)
	public ResponseEntity<Object> saveUser(@RequestParam(value = "id") int id, @RequestBody UserDetailsBean userBean1,
			@PathVariable("name") String name) {
		userBean1.setId(userBean1.getId());
		userBean1.setName(name);
		userBean.setExp(userBean1.getExp());
		return new ResponseEntity<Object>(restController.saveUser(userBean1), HttpStatus.OK);
	}

	@RequestMapping(value = "/getUser/{name}", method = RequestMethod.GET)
	public ResponseEntity<Object> getUser(@RequestParam(value = "id") int id, @PathVariable("name") String name) {
		userBean.setId(id);
		userBean.setName(name);
		// userBean.setExp(userBean1.getExp());
		return new ResponseEntity<Object>(restController.getUser(userBean), HttpStatus.OK);
	}

}
