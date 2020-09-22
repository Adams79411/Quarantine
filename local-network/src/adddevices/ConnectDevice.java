/**
 * 
 */
package adddevices;

import java.util.List;
import java.util.Objects;

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
	 * @param routeList
	 */
	public void connectDevice(List<Device> deviceList, List<Connection> connectionList, String[] commandLineArray) {
		if (commandLineArray.length == 1 || commandLineArray.length == 2) {
			System.out.println("Error: Invalid command syntax.");
			return;
		}
		if (commandLineArray[1].equals(commandLineArray[2])) {
			System.out.println("Error: Cannot connect device to itself.");
			return;
		}
		Connection connection = connectionList.stream().filter(data -> {
			return (commandLineArray[1].equals(data.getSourceDevice())
					&& commandLineArray[2].equals(data.getDestinationDevice()));
		}).findAny().orElse(null);
		if (Objects.nonNull(connection)) {
			System.out.println("Error: Devices are already connected.");
			return;
		}
		Connection connect = new Connection();
		connect.setDestinationDevice(commandLineArray[2]);
		connect.setSourceDevice(commandLineArray[1]);
		connectionList.add(connect);
		System.out.println("Successfully connected.");
	}
}
