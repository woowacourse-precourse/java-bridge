package bridge;

import java.util.Arrays;
import java.util.List;

public enum Order {
	MOVING("이동", Arrays.asList(Control.UP, Control.DOWN)),
	CONTROL("제어", Arrays.asList(Control.RESTART, Control.QUIT));

	private final String orderName;
	private final List<Control> orders;

	Order(String orderName, List<Control> orders) {
		this.orderName = orderName;
		this.orders = orders;
	}

	public static boolean isOrderMoving(String input) {
		for (Control control : MOVING.orders) {
			if (control.getControlOrder().equals(input)) {
				return true;
			}
		}
		return false;
	}
}
