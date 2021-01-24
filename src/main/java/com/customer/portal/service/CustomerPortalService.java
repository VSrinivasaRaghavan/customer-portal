package com.customer.portal.service;

import com.customer.portal.bean.CustomerDetailBean;
import com.customer.portal.entity.Accounts;
import com.customer.portal.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerPortalService {

	@Autowired
	AccountRepository accountRepository;

	/**
	 * Create customer account if not exists
	 *
	 * @param customerDetailBean
	 * @return
	 */
	public String createCustomerAccount(CustomerDetailBean customerDetailBean) {
		if (accountRepository.findByUsernameOrEmail(customerDetailBean.getUsername(), customerDetailBean.getEmail())
				.isPresent())
			return "EXISTS";
		Accounts accounts = new Accounts();
		accounts.setUsername(customerDetailBean.getUsername());
		accounts.setPassword(customerDetailBean.getPassword());
		accounts.setEmail(customerDetailBean.getEmail());
		accounts.setCreatedOn(new Date());
		accountRepository.save(accounts);
		return "SUCCESS";
	}
}
