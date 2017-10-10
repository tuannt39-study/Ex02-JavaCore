package vn.its;

@SuppressWarnings("serial")
public class MediumCar extends Car {
	
	private boolean powerSteering;

	public MediumCar() {
		super();
	}

	public MediumCar(boolean powerSteering) {
		super();
		this.powerSteering = powerSteering;
	}

	public boolean isPowerSteering() {
		return powerSteering;
	}

	public void setPowerSteering(boolean powerSteering) {
		this.powerSteering = powerSteering;
	}

}
