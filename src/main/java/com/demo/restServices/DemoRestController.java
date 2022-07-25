package com.demo.restServices;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bean.UserDetailsBean;
import com.demo.demo.DemoApplication;

@Component
public class DemoRestController {
@Autowired
UserDetailsBean userBen;
    public String homePage(){
		return "Hello";
	}
	public String index(){
		return "Welcome";
	}
	public String saveUser(UserDetailsBean userBn){
		userBen.setId(userBn.getId());
		userBen.setName(userBn.getName());
		userBen.setExp(userBn.getExp());
		DemoApplication.logger.warn(userBen.getName()+" data saved sucessfully");
		return userBen.getName()+" data saved sucessfully";
	} 
	public List<UserDetailsBean> getUser(UserDetailsBean userBn){
		List<UserDetailsBean> list=new LinkedList<>();
		list.add(userBen);
		list.add(userBn);
		return list;
	}   
}
