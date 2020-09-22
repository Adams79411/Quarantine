/**
 * 
 */
package localnetworkapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import adddevices.AddDeviceStrength;
import adddevices.AddDevicetoNetwork;
import adddevices.ConnectDevice;
import adddevices.RouteDetection;
import entity.Connection;
import entity.Device;
import enumeration.LocalNetworkCommands;

/**
 * 
 * LocalNetwork class is used to create a network with attributes and data that
 * are needed for communication purpose.
 * 
 * @author Steny Adams J
 *
 */
public class LocalNetwork {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner dataScanner = new Scanner(System.in);
		List<Device> deviceList = new ArrayList<>();
		List<Connection> connectionList = new ArrayList<>();
		String commandLine;
		while ((commandLine = dataScanner.nextLine()).equals("END") == false) {
			String[] commandLineArray = new String[20];
			commandLineArray = commandLine.split(" ", commandLine.length());
			if (commandLineArray[0].equals(LocalNetworkCommands.ADD.name())) {
				AddDevicetoNetwork addDevice = new AddDevicetoNetwork();
				addDevice.registerData(deviceList, commandLineArray);
			}
			if (commandLineArray[0].equals(LocalNetworkCommands.SET_DEVICE_STRENGTH.name())) {
				AddDeviceStrength addStrength = new AddDeviceStrength();
				addStrength.registerDeviceStrength(deviceList, commandLineArray);
			}
			if (commandLineArray[0].equals(LocalNetworkCommands.CONNECT.name())) {
				ConnectDevice connectDevice = new ConnectDevice();
				connectDevice.connectDevice(deviceList, connectionList, commandLineArray);
			}
			if (commandLineArray[0].equals(LocalNetworkCommands.INFO_ROUTE.name())) {
				RouteDetection route = new RouteDetection();
				route.getRoute(deviceList, connectionList, commandLineArray);
			}
		}
	}
}