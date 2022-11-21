package bridge;

public enum Order {
	UP(0, "U"),
	DOWN(1, "D"),
	RESTART(2, "R"),
	QUIT(3, "Q");

	private int orderId;
	private String orderAlias;

	private Order(int orderId, String orderAlias) {
		this.orderId = orderId;
		this.orderAlias = orderAlias;
	}

	public boolean isOrder(String orderAlias) {
		for (Order order : Order.values()) {
			if (order.orderAlias.equals(orderAlias)) {
				return true;
			}
		}
		return false;
	}
}
