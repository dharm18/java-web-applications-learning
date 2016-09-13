package test;

public class Battery extends Product{
	
	private boolean rechargeable;

	public boolean isRechargeable() {
		return rechargeable;
	}

	public void setRechargeable(boolean rechargeable) {
		this.rechargeable = rechargeable;
	}

	public Battery() {
		super();
	}

	public Battery(String name, double price) {
		super(name, price);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("battery [rechargable=");
		builder.append(rechargeable);
		builder.append("]");
		return builder.toString();
	}
	
}
