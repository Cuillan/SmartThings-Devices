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

        	attribute "unreachable", "number" // This is a new temporary counter to keep track of no responses
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

	// simulator metadata
	simulator {
		// status messages
		status "on": "on/off: 1"
		status "off": "on/off: 0"

		// reply messages
		reply "zcl on-off on": "on/off: 1"
		reply "zcl on-off off": "on/off: 0"
	}

	/* T */
	preferences {
		input name: "linkLevelAndColor", type: "bool", title: "Link level change with color temperature?", defaultValue: true, displayDuringSetup: true, required: false
		input name: "delay", type: "number", title: "Delay between level and color temperature change in milliseconds", defaultValue: 0, displayDuringSetup: true, required: false
		input name: "colorTempMin", type: "number", title: "Color temperature at lowest level(1%)", defaultValue: 2200, range: "2200..4000", displayDuringSetup: true, required: false
		input name: "colorTempMax", type: "number", title: "Color temperature at highest level(100%)", defaultValue: 3200, range: "2200..4000", displayDuringSetup: true, required: false
		input name: "colorNameAsKelvin", type: "bool", title: "Display color temperature as kelvin", defaultValue: false, displayDuringSetup: true, required: false
	}
	 
	 
	// UI tile definitions
	tiles (scale: 2){
		multiAttributeTile(name: "switch", type: "lighting", width: 6, height: 4, canChangeIcon: true) {
        		tileAttribute("device.switchColor", key: "PRIMARY_CONTROL") {
				attributeState "off", label: '${currentValue}', action: "switch.on", icon: "st.switches.switch.off", backgroundColor: "#ffffff"
				attributeState "Red", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ff0000"
				attributeState "Brick Red", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ff3700"
    				attributeState "Safety Orange", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ff6F00"
    				attributeState "Dark Orange", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ff9900"
	            		attributeState "Amber", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ffbf00"
        	    		attributeState "Gold", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ffe1000"
            			attributeState "Yellow", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ffff00"
    				attributeState "Electric Lime", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#bfff00"
	            		attributeState "Lawn Green", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#88ff00"
        	    		attributeState "Bright Green", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#48ff00"
            			attributeState "Lime", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#00ff11"
            			attributeState "Spring Green", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#00ff6a"
	            		attributeState "Turquoise", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#00ffd0"
        	    		attributeState "Aqua", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#00ffff"
            			attributeState "Sky Blue", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#00bfff"
            			attributeState "Dodger Blue", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#007bff"
	            		attributeState "Navy Blue", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#0050ff"
        	    		attributeState "Blue", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#0000ff"
            			attributeState "Han Purple", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#3b00ff"
            			attributeState "Electric Indigo", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#6600ff"
	            		attributeState "Electric Purple", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#b200ff"
        	    		attributeState "Orchid Purple", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#e900ff"
            			attributeState "Magenta", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ff00dc"
            			attributeState "Hot Pink", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ff00aa"
	            		attributeState "Deep Pink", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ff007b"
        	    		attributeState "Raspberry", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ff0061"
            			attributeState "Crimson", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#ff003b"
            			attributeState "White", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#79b821"
	               		attributeState "Color Loop", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#79b821"
			}
            		tileAttribute ("device.color", key: "COLOR_CONTROL") {
            			attributeState "color", action: "setAdjustedColor"
            		}
            		tileAttribute ("device.level", key: "SECONDARY_CONTROL") {
            			attributeState "level", label: 'Level is ${currentValue}%'
            		}
        	}
        	standardTile("refresh", "device.switch", height: 2, width: 2, inactiveLabel: false, decoration: "flat") {
			state "default", label:"", action:"refresh.refresh", icon:"st.secondary.refresh"
		}
		controlTile("levelSliderControl", "device.level", "slider", height: 1, width: 4, inactiveLabel: false) {
			state "level", action:"switch level.setLevel"
		}
        	controlTile("colorTempSliderControl", "device.colorTemperature", "slider", height: 1, width: 4, inactiveLabel: false, range:"(2000..6500)") {
        		state "colorTemperature", action:"color temperature.setColorTemperature"
        	}
        	valueTile("colorTemp", "device.colorTemperature", height: 1, width: 2, inactiveLabel: false, decoration: "flat") {
        		state "colorTemperature", label: '${currentValue} K'
        	}
        	valueTile("colorName", "device.colorName", height: 1, width: 2, inactiveLabel: false, decoration: "flat") {
        		state "colorName", label: '${currentValue}'
        	}
        	valueTile("colorMode", "device.colorMode", height: 2, width: 2, inactiveLabel: false, decoration: "flat") {
        		state "colorMode", label: '${currentValue}'
        	}
        	standardTile("loop", "device.loopActive", height: 2, width: 2, inactiveLabel: false, decoration: "flat") {
			state "Active", label:'${currentValue}', action: "stopLoop", backgroundColor: "#79b821", nextState: "stoppingLoop"
        		state "startingLoop", label: "Starting Loop", action: "stopLoop", backgroundColor: "#79b821", nextState: "stoppingLoop"
			state "Inactive", label:'${currentValue}', action: "startLoop", backgroundColor: "#ffffff", nextState: "startingLoop"
        		state "stoppingLoop", label: "Stopping Loop", action: "startLoop", backgroundColor: "#ffffff", nextState: "startingLoop"
		}
        	controlTile("loopTimeControl", "device.loopTime", "slider", height: 2, width: 4, range: "(1..60)", inactiveLabel: false) {
        		state "loopTime", action: "setLoopTime"
        	}
        	standardTile("loopDir", "device.loopDirection", height: 2, width: 2, inactiveLabel: false, decoration: "flat") {
        		state "default", label: '${currentValue}', action: "setDirection"
        	}
        
		main(["switch"])
		details(["switch", "levelSliderControl", "colorName", "colorTempSliderControl", "colorTemp", "colorMode", "loop", "refresh", "loopTimeControl", "loopDir"])
	}
	 
	/* T */
	// UI tile definitions
  	tiles(scale: 2) {
    		multiAttributeTile(name:"switch", type: "lighting", width: 6, height: 4, canChangeIcon: true){
      			tileAttribute ("device.switch", key: "PRIMARY_CONTROL") {
        			attributeState "on", label:'${name}', action:"switch.off", icon:"st.switches.light.on", backgroundColor:"#00a0dc", nextState:"turningOff"
        			attributeState "off", label:'${name}', action:"switch.on", icon:"st.switches.light.off", backgroundColor:"#ffffff", nextState:"turningOn"
        			attributeState "turningOn", label:'${name}', action:"switch.off", icon:"st.switches.light.on", backgroundColor:"#00a0dc", nextState:"turningOff"
        			attributeState "turningOff", label:'${name}', action:"switch.on", icon:"st.switches.light.off", backgroundColor:"#ffffff", nextState:"turningOn"
      			}
      
      			tileAttribute ("device.level", key: "SLIDER_CONTROL") {
        			attributeState "level", action:"setLevel"
        		}
    		}

    		controlTile("colorTempSliderControl", "device.colorTemperature", "slider", width: 4, height: 1, inactiveLabel: false, range:"(2200..4000)") {
      			state "colorTemperature", action:"setColorTemperature"
    		}

    		valueTile("colorName", "device.colorName", inactiveLabel: false, decoration: "flat", width: 4, height: 1) {
      			state "colorName", label: '${currentValue}'
    		}

    		standardTile("refresh", "device.refresh", inactiveLabel: false, decoration: "flat", width: 2, height: 1) {
      			state "default", label:"", action:"refresh.refresh", icon:"st.secondary.refresh"
    		}
    
    		standardTile("nextColor", "device.default", inactiveLabel: false, decoration: "flat", width: 2, height: 1) {
      			state "default", label:"", action:"nextColor", icon:"https://github.com/edvaldeysteinsson/SmartThingsResources/raw/master/images/next_color.png"
    		}

    		standardTile("colorRelax", "device.default", inactiveLabel: false, width: 2, height: 2) {
      			state "default", label:"", action:"setColorRelax", backgroundColor:"#ECCF73"
    		}

    		standardTile("colorEveryday", "device.default", inactiveLabel: false, width: 2, height: 2) {
      			state "default", label:"", action:"setColorEveryday", backgroundColor:"#FBECCB"
    		}

    		standardTile("colorFocus", "device.default", inactiveLabel: false, width: 2, height: 2) {
      			state "default", label:"", action:"setColorFocus", backgroundColor:"#F5FBFB"
    		}

    		main(["switch"])
    		details(["switch", "colorTempSliderControl", "colorName", "refresh", "nextColor", "colorRelax", "colorEveryday", "colorFocus"])
  	}

 }
