/**
 * 
 */
package adddevices;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import entity.Connection;
import entity.Device;

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
	 * @param repeatedListForComputers
	 * @param repeatedListForRepeaters
	 * @param alreadyExistedConnectionMap
	 */
	public void getRoute(List<Device> deviceList, List<Connection> connectionList, String[] commandLineArray,
			List<String> repeatedListForComputers, List<String> repeatedListForRepeaters,
			Map<String, List<String>> alreadyExistedConnectionMap) {
		int CONSTANT_ONE = 1;
		int CONSTANT_TWO = 2;
		if (connectionList.size() > CONSTANT_ONE) {
			List<String> sourceIdList = new ArrayList<>();
			List<String> destinationIdList = new ArrayList<>();
			connectionList.stream().forEach(connection -> {
				sourceIdList.add(connection.getSourceDevice());
				destinationIdList.add(connection.getDestinationDevice());
			});
			if (commandLineArray.length == CONSTANT_ONE || commandLineArray.length == CONSTANT_TWO) {
				System.out.println("Error: Invalid command syntax.");
			} else if (repeatedListForRepeaters.size() > CONSTANT_ONE
					&& repeatedListForRepeaters.contains(commandLineArray[CONSTANT_ONE])
					|| repeatedListForRepeaters.contains(commandLineArray[CONSTANT_TWO])) {
				System.out.println("Error: Route cannot be calculated with a repeater.");
			} else if (repeatedListForComputers.size() > CONSTANT_ONE
					&& (!repeatedListForComputers.contains(commandLineArray[CONSTANT_ONE])
							|| !repeatedListForComputers.contains(commandLineArray[CONSTANT_TWO]))) {
				System.out.println("Error: Node not found");
			} else if (repeatedListForRepeaters.size() > CONSTANT_ONE
					&& (!repeatedListForRepeaters.contains(commandLineArray[CONSTANT_ONE])
							|| !repeatedListForRepeaters.contains(commandLineArray[CONSTANT_TWO]))) {
				System.out.println("Error: Node not found");
			} else if (!destinationIdList.contains(commandLineArray[CONSTANT_TWO])
					&& !sourceIdList.contains(commandLineArray[CONSTANT_ONE])) {
				System.out.println("Error: Route not found!");
			} else {
				if (alreadyExistedConnectionMap.size() != 0) {
					alreadyExistedConnectionMap.entrySet().stream().forEach(data -> {
						List<String> dataList = data.getValue();
						dataList.stream().forEach(list -> {
							System.out.println(list);
						});
					});
				}
			}
		} else {
			System.out.println("Error: Node not found");
		}
	}
}
