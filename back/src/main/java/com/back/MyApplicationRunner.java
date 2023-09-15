package com.back;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.back.api.controller.ApiController;

@Component
public class MyApplicationRunner implements ApplicationRunner {

	  private final ApiController apiController; 

	    public MyApplicationRunner(ApiController apiController) {
	        this.apiController = apiController;
	    }

	
    @Override
    public void run(ApplicationArguments args) throws Exception {
    	apiController.updateBoxofficeFromApi();
    }
}
