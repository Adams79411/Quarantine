/**
 * 
 */
package enumeration;

/**
 * DeviceInformations provides the details of the devices that can be added for
 * local network.
 * 
 * @author Steny Adams J
 *
 */
public enum DeviceInformations {
	COMPUTER("computer"), REPEATER("repeater");

	DeviceInformations(String deviceName) {
		this.device = deviceName;
	}

	String device;
}
