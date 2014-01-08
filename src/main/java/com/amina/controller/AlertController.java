package com.amina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amina.domain.Alert;
import com.amina.service.AlertService;

@Controller
@RequestMapping("teradata")
public class AlertController {
        
        AlertService alertService;
        
        @Autowired
        public AlertController(AlertService alertService) {
                this.alertService = alertService;
        }
        
        /**
         * Get all alerts from Teradata database, accessible at /teradata/alerts
         * @param id
         * @return
         */
        @RequestMapping("/alerts")
        @ResponseBody
        public List<Alert> getAllPeople(){
        	return alertService.getAllAlerts();
        }

}
