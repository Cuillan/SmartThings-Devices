/**
 *  New NUE RGBW Light Strip controller MultiAttribute
 *
 *  Merged functionality from Improved Zigbee Hue MA (sticks18) and IKEA Trådfri (Edvald Eysteinsson)
 *  
 *
 *  Copyright 2015 SmartThings
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
 
 metadata {
	// Automatically generated. Make future change here.
	definition (name: "NUE Zigbee RGBW Light Strip Controller - Test", namespace: "Cuillan", author: "Carl A") {
		capability "Switch Level"
		capability "Actuator"
		capability "Color Control"
		capability "Color Temperature"
		capability "Switch"
		capability "Configuration"
		capability "Polling"
		capability "Refresh"
		capability "Sensor"
		capability "Health Check" //T
		capability "Light" //T

       
        command "setAdjustedColor"
        command "startLoop"
        command "stopLoop"
        command "setLoopTime"
        command "setDirection"
        
        command "alert"
        command "toggle"

	command "setColorName" //T
 	command "setColorRelax" //T
	command "setColorEveryday" //T
	command "setColorFocus" //T
	command "nextColor" //T

        // This is a new temporary counter to keep track of no responses
        attribute "unreachable", "number"
        attribute "colorMode", "string"
        attribute "colorName", "string"
        attribute "switchColor", "string"
        attribute "loopActive", "string"
        attribute "loopDirection", "string"
        attribute "loopTime", "number"
        attribute "alert", "string"

	// NUE Zigbee RGBW Light Strip Controller (basic, identity, groups, scenes, on/off, level control, colour control)
	fingerprint profileId: "C05E", inClusters: "0000,0003,0004,0005,0006,0008,0300"
  }
