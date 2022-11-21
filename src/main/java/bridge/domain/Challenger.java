package bridge.domain;

import java.util.List;

public class Challenger {

	private String moving;
	private String result;
	private List<Integer> userMoving;
	private final List<Integer> top;
	private final List<Integer> bottom;

	public Challenger(List<Integer> top, List<Integer> bottom) {
		this.top = top;
		this.bottom = bottom;
	}

	public void setMoving(String shape, String moving) {
		this.moving = changeMoving(shape, moving);
	}

	public void setUserMoving(List<Integer> userMoving) {
		this.userMoving = userMoving;
	}

	public void setResult() {
		top.add(userMoving.get(0));
		bottom.add(userMoving.get(1));
		this.result = convertListToString(top) + "\n" + convertListToString(bottom);
	}

	public String getResult() {
		return result;
	}

	public String getMoving() {
		return moving;
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

	/**
	 *
	 * @param shape 다리의 모양
	 * @param moving 입력받은 움직임
	 * @return 움직임이 다리의 모양과 같지 않으면 wrong value 반환
	 */
	public String changeMoving(String shape, String moving) {
		moving = isWrongMoving(shape, moving);

		return moving;
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

}
