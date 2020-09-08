/**
 * 
 */
package adddevices;

import java.util.List;
import java.util.regex.Pattern;

import entity.Device;

/**
 * AddDeviceStrength class is used to add device Strength for the already added
 * device via console.
 * 
 * @author Steny Adams J
 *
 */
public class AddDeviceStrength {
	/**
	 * registerDeviceStrength method is used to register the device strength for the
	 * already registered devices.
	 * 
	 * @param deviceList
	 * @param commandLineArray
	 * @param repeatedListForComputers
	 * @param repeatedListForRepeaters
	 */
	public void registerDeviceStrength(List<Device> deviceList, String[] commandLineArray,
			List<String> repeatedListForComputers) {
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
		int CONSTANT_ONE = 1;
		int CONSTANT_TWO = 2;
		if (commandLineArray.length == CONSTANT_ONE || commandLineArray.length == CONSTANT_TWO) {
			System.out.println("Error: Invalid command syntax.");
		} else if (repeatedListForComputers.contains(commandLineArray[CONSTANT_ONE])) {
			if (!pattern.matcher(commandLineArray[CONSTANT_TWO]).matches()) {
				System.out.println("Error: Invalid command syntax.");
			} else {
				int deviceStrength = Integer.parseInt(commandLineArray[CONSTANT_TWO]);
				deviceList.stream().filter(device -> device.getDeviceName().equals(commandLineArray[CONSTANT_ONE]))
						.forEach(data -> data.setDeviceStrength(deviceStrength));
				System.out.println("Successfully Defined strength");
			}
		} else {
			System.out.println("Error: Invalid command syntax.");
		}
	}
}
