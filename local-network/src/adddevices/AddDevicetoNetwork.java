/**
 * 
 */
package adddevices;

import java.util.List;
import java.util.Objects;

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
	 */
	public void registerData(List<Device> deviceList, String[] commandLineArray) {
		if (commandLineArray.length == 1 && !commandLineArray[1].equals(DeviceInformations.COMPUTER.name())
				|| !commandLineArray[1].equals(DeviceInformations.REPEATER.name())) {
			System.out.println("Error: Invalid command syntax.");
			return;
		}
		Device device = deviceList.stream().filter(data -> commandLineArray[2].equals(data.getDeviceId())).findAny()
				.orElse(null);
		if (Objects.nonNull(device)) {
			System.out.println("Error: That name already exists.");
		} else {
			Device insertDevice = new Device();
			insertDevice.setDeviceId(commandLineArray[2]);
			insertDevice.setDeviceName(commandLineArray[1]);
			insertDevice.setDeviceStrength(5);
			deviceList.add(insertDevice);
			System.out.println("Successfully added " + commandLineArray[2]);
		}
	}
}
