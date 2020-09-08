/**
 * 
 */
package adddevices;

import java.util.List;

import entity.Device;
import enumeration.DeviceInformations;

/**
 * 
 * AddDevicetoNetwork class is used to add the devices that are specified in the
 * console.
 * 
 * @author Steny Adams J
 *
 */
public class AddDevicetoNetwork {
	/**
	 * RegisterData is used to add device data to the memory.
	 * 
	 * @param deviceList
	 * @param commandLineArray
	 * @param repeatedListForRepeaters
	 * @param repeatedListForComputers
	 */
	public void registerData(List<Device> deviceList, String[] commandLineArray, List<String> repeatedListForComputers,
			List<String> repeatedListForRepeaters) {
		int CONSTANT_ONE = 1;
		int CONSTANT_TWO = 2;
		int DEFAULT_STRENGTH = 5;
		if (commandLineArray.length == CONSTANT_ONE) {
			System.out.println("Error: Invalid command syntax.");
		} else if (commandLineArray[CONSTANT_ONE].equals(DeviceInformations.COMPUTER.name())
				|| commandLineArray[CONSTANT_ONE].equals(DeviceInformations.REPEATER.name())) {
			if (repeatedListForComputers.contains(commandLineArray[CONSTANT_TWO])
					|| repeatedListForRepeaters.contains(commandLineArray[CONSTANT_TWO])) {
				System.out.println("Error: That name already exists.");
			} else {
				if (commandLineArray[CONSTANT_ONE].equals(DeviceInformations.COMPUTER.name())) {
					repeatedListForComputers.add(commandLineArray[CONSTANT_TWO]);
				} else {
					repeatedListForRepeaters.add(commandLineArray[CONSTANT_TWO]);
				}
				Device device = new Device();
				device.setDeviceId(commandLineArray[CONSTANT_ONE]);
				device.setDeviceName(commandLineArray[CONSTANT_TWO]);
				device.setDeviceStrength(DEFAULT_STRENGTH);
				deviceList.add(device);
				System.out.println("Successfully added " + commandLineArray[CONSTANT_TWO]);
			}
		} else {
			System.out.println("Error: Invalid command syntax.");
		}
	}
}
