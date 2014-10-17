/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.example.customerservice.server;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

import com.example.wsdlbugstudiosoapwizard.Customer;
import com.example.wsdlbugstudiosoapwizard.WsdlBugStudioSOAPWizardService;

public class CustomerServiceImpl implements WsdlBugStudioSOAPWizardService {

	/**
	 * The WebServiceContext can be used to retrieve special attributes like the
	 * user principal. Normally it is not needed
	 */
	@Resource
	WebServiceContext wsContext;

	public List<Customer> getCustomersByName(String name) {
		if ("None".equals(name)) {
			// do something fun
		}

		List<Customer> customers = new ArrayList<Customer>();
		for (int c = 0; c < 2; c++) {
			Customer cust = new Customer();
			cust.setName(name);
			customers.add(cust);
		}

		return customers;
	}

	public void updateCustomer(Customer customer) {
		System.out.println("update request was received");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// Nothing to do here
		}
		System.out.println("Customer was updated");
	}

}
