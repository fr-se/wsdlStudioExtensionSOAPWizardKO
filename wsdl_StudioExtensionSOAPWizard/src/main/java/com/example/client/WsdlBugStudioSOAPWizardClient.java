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

import java.io.File;
import java.net.URL;

import com.example.wsdlbugstudiosoapwizard.WsdlBugStudioSOAPWizardService;
import com.example.wsdlbugstudiosoapwizard.WsdlBugStudioSOAPWizardServiceService;

public class WsdlBugStudioSOAPWizardClient {
    protected WsdlBugStudioSOAPWizardClient() {
    }
    
    public static void main(String args[]) throws Exception {
        WsdlBugStudioSOAPWizardServiceService wsdlBugStudioSOAPWizardServiceService;
        if (args.length != 0 && args[0].length() != 0) {
            File wsdlFile = new File(args[0]);
            URL wsdlURL;
            if (wsdlFile.exists()) {
                wsdlURL = wsdlFile.toURI().toURL();
            } else {
                wsdlURL = new URL(args[0]);
            }
            // Create the service client with specified wsdlurl
            wsdlBugStudioSOAPWizardServiceService = new WsdlBugStudioSOAPWizardServiceService(wsdlURL);
        } else {
            // Create the service client with its default wsdlurl
            wsdlBugStudioSOAPWizardServiceService = new WsdlBugStudioSOAPWizardServiceService();
        }

        WsdlBugStudioSOAPWizardService customerService = wsdlBugStudioSOAPWizardServiceService.getWsdlBugStudioSOAPWizardServicePort();
        
        // Initialize the test class and call the tests
        WsdlBugStudioSOAPWizardTester client = new WsdlBugStudioSOAPWizardTester();
        client.setCustomerService(customerService);
        client.testCustomerService();
        System.exit(0); 
    }
}
