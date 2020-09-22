/**
 * 
 */
package adddevices;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import entity.Connection;
import entity.Device;
import enumeration.DeviceInformations;

/**
 * RouteDetection class is used to print the route at which the specified
 * devices can get connected.
 * 
 * @author Steny Adams J
 *
 */
public class RouteDetection {
	/**
	 * getRoute method is used to print the route at which the specified devices can
	 * get connected.
	 * 
	 * @param deviceList
	 * @param connectionList
	 * @param commandLineArray
	 */
	public void getRoute(List<Device> deviceList, List<Connection> connectionList, String[] commandLineArray) {
		if (commandLineArray.length == 1 || commandLineArray.length == 2) {
			System.out.println("Error: Invalid command syntax.");
			return;
		}
		Device device = deviceList.stream().filter(data -> commandLineArray[1].equals(data.getDeviceId())).findAny()
				.orElse(null);
		Device secondaryDevice = deviceList.stream().filter(data -> commandLineArray[2].equals(data.getDeviceId()))
				.findAny().orElse(null);
		if (connectionList.size() > 1 || Objects.isNull(device) || Objects.isNull(secondaryDevice)) {
			System.out.println("Error: Node not found");
			return;
		}
		if (DeviceInformations.REPEATER.name().equals(device.getDeviceName())
				&& DeviceInformations.REPEATER.name().equals(secondaryDevice.getDeviceName())) {
			System.out.println("Error: Route cannot be calculated with a repeater.");
			return;
		}
		List<Connection> connection = connectionList.stream().filter(data -> {
			return (!commandLineArray[1].equals(data.getSourceDevice())
					&& !commandLineArray[2].equals(data.getDestinationDevice()));
		}).collect(Collectors.toList());
		if (connection.size() < 1) {
			System.out.println("Error: Route not found!");
			return;
		}
		findConnection(connectionList, commandLineArray[1], commandLineArray[2]);
	}

	/**
	 * prints the route
	 * 
	 * @param connectionList
	 * @param source
	 * @param destination
	 */
	private void findConnection(List<Connection> connectionList, String source, String destination) {
		System.out.println(source + "->");
		List<String> dupRouteList = new ArrayList<>();
		dupRouteList.add(source);
		dupRouteList.add(destination);
		connectionList.stream().filter(data -> {
			return (source.equals(data.getSourceDevice()) && destination.equals(data.getDestinationDevice())
					&& source.equals(data.getDestinationDevice()) && destination.equals(data.getSourceDevice()));
		}).forEach(predicate -> {
			if (!dupRouteList.contains(predicate.getSourceDevice())
					&& !dupRouteList.contains(predicate.getDestinationDevice())) {
				System.out.println(predicate.getSourceDevice() + "->" + predicate.getDestinationDevice());
				dupRouteList.add(predicate.getSourceDevice());
				dupRouteList.add(predicate.getDestinationDevice());
			}
		});
		System.out.println(destination);
	}
}