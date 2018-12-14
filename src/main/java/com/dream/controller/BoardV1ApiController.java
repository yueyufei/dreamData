package com.dream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.api.BoardV1Api;
import com.dream.service.BoardV1ApiImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-10-31T06:06:33.615Z")

@Controller
public class BoardV1ApiController implements BoardV1Api {


	@Autowired
	BoardV1ApiImpl boardV1ApiImpl;


}
