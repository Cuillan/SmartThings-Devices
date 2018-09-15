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
	definition (name: "Improved Zigbee Hue Bulb MA - Test", namespace: "Sticks18", author: "Scott G") {
		capability "Switch Level"
		capability "Actuator"
		capability "Color Control"
        capability "Color Temperature"
		capability "Switch"
		capability "Configuration"
		capability "Polling"
		capability "Refresh"
		capability "Sensor"
       
        command "setAdjustedColor"
        command "startLoop"
        command "stopLoop"
        command "setLoopTime"
        command "setDirection"
        
        command "alert"
        command "toggle"
        
        // This is a new temporary counter to keep track of no responses
        attribute "unreachable", "number"
        attribute "colorMode", "string"
        attribute "colorName", "string"
        attribute "switchColor", "string"
        attribute "loopActive", "string"
        attribute "loopDirection", "string"
        attribute "loopTime", "number"
        attribute "alert", "string"

		fingerprint profileId: "C05E", inClusters: "0000,0003,0004,0005,0006,0008,0300,1000", outClusters: "0019"
	}
  
metadata {
  definition (name: "IKEA-Tradfri", namespace: "edvaldeysteinsson", author: "Edvald Eysteinsson") {
    capability "Actuator"
    capability "Color Temperature"
    capability "Configuration"
    capability "Health Check"
    capability "Refresh"
    capability "Switch"
    capability "Switch Level"
    capability "Light"

    attribute "colorName", "string"

    command "setColorName"
    command "setColorRelax"
    command "setColorEveryday"
    command "setColorFocus"
    command "nextColor"
	
    // Trådfri bulbs
    fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, 1000", outClusters: "0005, 0019, 0020, 1000", manufacturer: "IKEA of Sweden",  model: "TRADFRI bulb E27 WS�opal 980lm", deviceJoinName: "TRÅDFRI bulb E27 WS opal 980lm"
    fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, 1000", outClusters: "0005, 0019, 0020, 1000", manufacturer: "IKEA of Sweden",  model: "TRADFRI bulb E27 WS opal 980lm", deviceJoinName: "TRÅDFRI bulb E27 WS opal 980lm"
    fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, 1000", outClusters: "0005, 0019, 0020, 1000", manufacturer: "IKEA of Sweden",  model: "TRADFRI bulb E27 WS clear 950lm", deviceJoinName: "TRÅDFRI bulb E27 WS clear 950lm"
    fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, 1000", outClusters: "0005, 0019, 0020, 1000", manufacturer: "IKEA of Sweden",  model: "TRADFRI bulb E26 WS�opal 980lm", deviceJoinName: "TRÅDFRI bulb E26 WS opal 980lm"
    fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, 1000", outClusters: "0005, 0019, 0020, 1000", manufacturer: "IKEA of Sweden",  model: "TRADFRI bulb E26 WS opal 980lm", deviceJoinName: "TRÅDFRI bulb E26 WS opal 980lm"
    fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, 1000", outClusters: "0005, 0019, 0020, 1000", manufacturer: "IKEA of Sweden",  model: "TRADFRI bulb E26 WS clear 950lm", deviceJoinName: "TRÅDFRI bulb E26 WS clear 950lm"
    fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, 1000", outClusters: "0005, 0019, 0020, 1000", manufacturer: "IKEA of Sweden",  model: "TRADFRI bulb E14 WS opal 400lm", deviceJoinName: "TRÅDFRI bulb E14 WS opal 400lm"
    fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, 1000", outClusters: "0005, 0019, 0020, 1000", manufacturer: "IKEA of Sweden",  model: "TRADFRI bulb E12 WS opal 400lm", deviceJoinName: "TRÅDFRI bulb E12 WS opal 400lm"
    fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, 1000", outClusters: "0005, 0019, 0020, 1000", manufacturer: "IKEA of Sweden",  model: "TRADFRI bulb GU10 WS 400lm", deviceJoinName: "TRÅDFRI bulb GU10 WS 400lm"
    
    // FLOALT panels
    fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, 1000", outClusters: "0005, 0019, 0020, 1000", manufacturer: "IKEA of Sweden",  model: "FLOALT panel WS 30x30", deviceJoinName: "FLOALT panel WS 30x30"
    fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, 1000", outClusters: "0005, 0019, 0020, 1000", manufacturer: "IKEA of Sweden",  model: "FLOALT panel WS 30x90", deviceJoinName: "FLOALT panel WS 30x90"
    fingerprint profileId: "0104", inClusters: "0000, 0003, 0004, 0005, 0006, 0008, 0300, 0B05, 1000", outClusters: "0005, 0019, 0020, 1000", manufacturer: "IKEA of Sweden",  model: "FLOALT panel WS 60x60", deviceJoinName: "FLOALT panel WS 60x60"
  }
