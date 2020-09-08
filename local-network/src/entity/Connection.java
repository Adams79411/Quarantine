/**
 * 
 */
package entity;

/**
 * @author Steny Adams J
 *
 */
public class Connection {
	/** The sourceDevice */
	public String sourceDevice;
	/** The destinationDevice */
	public String destinationDevice;

	public String getSourceDevice() {
		return this.sourceDevice;
	}

	public String getDestinationDevice() {
		return this.destinationDevice;
	}

	public void setSourceDevice(String sourceDevice) {
		this.sourceDevice = sourceDevice;
	}

	public void setDestinationDevice(String destinationDevice) {
		this.destinationDevice = destinationDevice;
	}
}
