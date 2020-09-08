/**
 * 
 */
package adddevices;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entity.Connection;
import entity.Device;

/**
 * ConnectDevice class is used to connect the classes given and it is used to
 * check whether the device has already been added.
 * 
 * @author Steny Adams J
 *
 */
public class ConnectDevice {
	/**
	 * connectDevice method is used to connect the devices and to check whether the
	 * device given for connection is already registered or not.
	 * 
	 * @param deviceList
	 * @param connectionList
	 * @param commandLineArray
	 * @param repeatedListForComputers
	 * @param repeatedListForRepeaters
	 * @param alreadyExistedConnectionMap
	 * @param routeList
	 */
	public void connectDevice(List<Device> deviceList, List<Connection> connectionList, String[] commandLineArray,
			List<String> repeatedListForComputers, List<String> repeatedListForRepeaters,
			Map<String, List<String>> alreadyExistedConnectionMap) {
		int CONSTANT_ONE = 1;
		int CONSTANT_TWO = 2;
		if (commandLineArray.length == CONSTANT_ONE || commandLineArray.length == CONSTANT_TWO) {
			System.out.println("Error: Invalid command syntax.");
		} else if (commandLineArray[CONSTANT_ONE].equals(commandLineArray[CONSTANT_TWO])) {
			System.out.println("Error: Cannot connect device to itself.");
		} else {
			if (alreadyExistedConnectionMap.containsKey(commandLineArray[CONSTANT_ONE]) && alreadyExistedConnectionMap
					.get(commandLineArray[CONSTANT_ONE]).contains(commandLineArray[CONSTANT_TWO])) {
				System.out.println("Error: Devices are already connected.");
			} else {
				Connection connect = new Connection();
				connect.setDestinationDevice(commandLineArray[CONSTANT_TWO]);
				connect.setSourceDevice(commandLineArray[CONSTANT_ONE]);
				if (alreadyExistedConnectionMap.containsKey(commandLineArray[CONSTANT_ONE])) {
					alreadyExistedConnectionMap.get(commandLineArray[CONSTANT_ONE]).add(commandLineArray[CONSTANT_TWO]);
				} else {
					List<String> routeList = new ArrayList<>();
					routeList.add(commandLineArray[CONSTANT_TWO]);
					alreadyExistedConnectionMap.put(commandLineArray[CONSTANT_ONE], routeList);
				}
				connectionList.add(connect);
				System.out.println("Successfully connected.");
			}
		}
	}
}
