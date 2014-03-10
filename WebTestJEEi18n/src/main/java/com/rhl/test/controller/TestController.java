/**
 * 
 */
package com.rhl.test.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author vishwaka
 * 
 */
@Controller
public class TestController {

	static final Logger log = LoggerFactory.getLogger(TestController.class);

	@Autowired
	MessageSource messageSource;

	/**
	 * Create a new project item
	 * @param project
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/start")
	@ResponseBody
	public String addTest(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		log.info("Locale: "+locale.toString());
		log.warn("Message: "+ messageSource.getMessage("welcome.controller.calling",null, locale));
		return locale.toString();
	}


    /**
     * Exception handler to log error
     * @param ex Exception
     */
    @ExceptionHandler({Exception.class})
    public void handleException(Exception ex) {
    	//TODO: Handle general exceptions here
    	log.error(ex.getMessage(),ex);;
    }
	
}
