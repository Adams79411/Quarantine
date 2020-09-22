/**
 * 
 */
package adddevices;

import java.util.List;
import java.util.Objects;
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
	 */
	public void registerDeviceStrength(List<Device> deviceList, String[] commandLineArray) {
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
		if (!pattern.matcher(commandLineArray[2]).matches() || commandLineArray.length != 3) {
			System.out.println("Error: Invalid command syntax.");
			return;
		}
		Device device = deviceList.stream().filter(data -> commandLineArray[1].equals(data.getDeviceId())).findAny()
				.orElse(null);
		if (Objects.nonNull(device)) {
			int deviceStrength = Integer.parseInt(commandLineArray[2]);
			deviceList.stream().filter(data -> data.getDeviceName().equals(commandLineArray[1]))
					.forEach(data -> data.setDeviceStrength(deviceStrength));
			System.out.println("Successfully Defined strength");
		}
	}
}