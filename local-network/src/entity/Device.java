/**
 * 
 */
package entity;

/**
 * @author Steny Adams J
 *
 */
public class Device {

	/** The deviceId */
	public String deviceId;
	/** The deviceName */
	public String deviceName;
	/** The deviceStrength */
	public int deviceStrength;

	public String getDeviceId() {
		return this.deviceId;
	}

	public String getDeviceName() {
		return this.deviceName;
	}

	public int getDeviceStrength() {
		return this.deviceStrength;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public void setDeviceStrength(int deviceStrength) {
		this.deviceStrength = deviceStrength;
	}
}
