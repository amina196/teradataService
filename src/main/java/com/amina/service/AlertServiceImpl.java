package com.amina.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.amina.domain.Alert;
import com.amina.dao.AlertDao;

@Service
@Transactional
//@transactional requires the dependency spring-tx
public class AlertServiceImpl implements AlertService {
	
		@Autowired
		private AlertDao alertDao; 
		
        @Override
        public List<Alert> getAllAlerts(){
        	List<Alert> alerts = new LinkedList<Alert>();
        	alerts = this.alertDao.getAllAlert();
        	return alerts;
        	
        }
        
        private Integer randomQuantity() {
            Random random = new Random();
            return 10 + random.nextInt(100);
    }

}