package com.customer.portal.controller;

import com.customer.portal.bean.CustomerDetailBean;
import com.customer.portal.service.CustomerPortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customer")
public class CustomerPortalController {

	@Autowired
	private CustomerPortalService customerPortalService;

	/**
	 * To create customer account
	 *
	 * @param customerDetailBean
	 * @return
	 */
	@CrossOrigin
	@PostMapping("/create/account")
	public ResponseEntity<String> createCustomerAccount(@RequestBody CustomerDetailBean customerDetailBean) {
		return new ResponseEntity<String>(customerPortalService.createCustomerAccount(customerDetailBean),
				HttpStatus.OK);
	}
}
