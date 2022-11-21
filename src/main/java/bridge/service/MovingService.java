package bridge.service;

import java.util.List;

import bridge.domain.Bridge;

public class MovingService {

	public String changeMoving(String shape, String moving) {
		moving = isWrongMoving(shape, moving);

		return moving;
	}

	public String saveUserMoving(List<Integer> moving, List<Integer> top, List<Integer> bottom) {
		top.add(moving.get(Bridge.TOP.getSecond()));
		bottom.add(moving.get(Bridge.BOTTOM.getSecond()));

		return convertListToString(top) + "\n" + convertListToString(bottom);
	}

	private String isWrongMoving(String shape, String moving) {
		if (!shape.equals(moving)) {
			moving = setWrongMoving(moving);
		}
		return moving;
	}

	private String setWrongMoving(String moving) {
		String move = Bridge.UNKNOWN.getOrder();

		if (moving.equals(Bridge.TOP.getOrder())) {
			move = Bridge.WRONG.getOrder();
		}

		return move;
	}

	private String convertListToString(List<Integer> bridge) {
		StringBuilder map = new StringBuilder("[ ");

		judgement(map, bridge);
		map.append(" ]");

		return map.toString();
	}

	private void judgement(StringBuilder map, List<Integer> bridge) {
		for (int i = 0; i < bridge.size(); i++) {
			map.append(Bridge.findOrder(bridge.get(i)).getResult());

			if (i < bridge.size() - 1) {
				map.append(" | ");
			}
		}
	}

}
