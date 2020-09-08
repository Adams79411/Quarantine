/**
 * 
 */
package enumeration;

/**
 * 
 * LocalNetworkCommands provides the enum values for the connection command
 * representation.
 * 
 * @author Steny Adams J
 *
 */
public enum LocalNetworkCommands {
	ADD("add"), CONNECT("connect"), SET_DEVICE_STRENGTH("deviceStrength"), INFO_ROUTE("route");

	LocalNetworkCommands(String commands) {
		this.data = commands;
	}

	String data;
}