package service;

import domain.GameMessage;

public class OutputView {
	public void printGameMessage(String type) {
		for (GameMessage messageType : GameMessage.values()) {
			if (messageType.toString().equals(type)) {
				System.out.println(messageType.getGameMessage());
				return;
			}
		}
	}
	
	public void printMap(String map) {
		System.out.println(map + "\n");
	}

	public void printResult(String map, String result, int count) {
		StringBuilder resultBuilder = new StringBuilder();

		resultBuilder.append(GameMessage.RESULT.getGameMessage());
		resultBuilder.append("\n" + map + "\n");
		resultBuilder.append("\n게임 성공 여부: " + result);
		resultBuilder.append("\n총 시도한 횟수: " + count);

		System.out.println(resultBuilder.toString());
	}

}
