package vn.its;

@SuppressWarnings("serial")
public class ModernCar extends Car{
	
	private boolean positioningDevice;

	public ModernCar() {
		super();
	}

	public ModernCar(boolean positioningDevice) {
		super();
		this.positioningDevice = positioningDevice;
	}

	public boolean isPositioningDevice() {
		return positioningDevice;
	}

	public void setPositioningDevice(boolean positioningDevice) {
		this.positioningDevice = positioningDevice;
	}
	
}
