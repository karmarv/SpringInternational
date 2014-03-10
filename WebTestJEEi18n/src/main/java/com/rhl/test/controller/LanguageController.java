package com.rhl.test.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Rahul
 * 
 */

@Controller
public class LanguageController {

	static final Logger log = LoggerFactory.getLogger(LanguageController.class);

	@Autowired
	ReloadableResourceBundleMessageSource messageSource;

	@RequestMapping("/reconfigure")
	public String reload(HttpServletRequest request,Locale locale) {
		log.info("Current Locale: "+locale.toLanguageTag());
		messageSource.clearCache();
		return "redirect:/";
	}
	
	@RequestMapping(value = "/welcome")
	public ModelAndView welcomeLoad(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		log.info("Hey This is the international test i was looking from: "+request.getRemoteHost().toString());
		log.info("Locale: "+locale.toLanguageTag());
		log.info(messageSource.getMessage("welcome.controller.calling",null, locale));
		ModelAndView model = new ModelAndView("welcome");
		return model;
	}

	@RequestMapping(value = "/dashboard")
	public ModelAndView dashboardLoad(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		log.info("So dashboard got a call from: "+request.getRemoteHost().toString());
		log.info("Locale: "+locale.toLanguageTag());
		ModelAndView model = new ModelAndView("dashboard");
		return model;
	}
	
	@RequestMapping(value = "/error")
	public ModelAndView throwItNow(HttpServletRequest request, HttpServletResponse response, Locale locale) throws Exception {
		throw new Exception("Knowingly threw error to meess with you");
	}
	
	/**
     * Exception handler to log error
     * @param ex Exception
     */
    @ExceptionHandler({Exception.class})
    public void handleException(Exception ex, Locale locale) {
    	log.error(messageSource.getMessage("welcome.controller.calling",null, locale));
    	log.error(ex.getMessage(),ex);;
    }


}
