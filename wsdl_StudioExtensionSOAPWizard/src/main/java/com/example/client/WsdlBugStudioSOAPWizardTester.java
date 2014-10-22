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

package com.example.client;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.example.wsdlbugstudiosoapwizard.WsdlBugStudioSOAPWizardService;
import com.example.wsdlbugstudiosoapwizard.types.Customer;

public final class WsdlBugStudioSOAPWizardTester {

	// The WsdlBugStudioSOAPWizardService proxy will be injected either by
	// spring or by a direct call to the setter
	WsdlBugStudioSOAPWizardService customerService;

	public WsdlBugStudioSOAPWizardService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(
			WsdlBugStudioSOAPWizardService customerService) {
		this.customerService = customerService;
	}

	@Test
	public void testCustomerService() {
		Customer customer = null;

		// First we test the positive case where customers are found and we
		// retreive
		// a list of customers
		System.out.println("Sending request for customers named Smith");
		customer = (Customer) customerService.getCustomersByName("Smith");
		System.out.println("Response received");
		assertEquals("Smith", customer.getName());
		customer = (Customer) customerService.getCustomersByName("None");
		assertEquals(null, customer);
		// Assert.fail("We should get a NoSuchCustomerException here");

		// The implementation of updateCustomer is set to sleep for some
		// seconds.
		// Still this method should return instantly as the method is declared
		// as a one way method in the WSDL

		System.out.println("All calls were successful");
	}

}
