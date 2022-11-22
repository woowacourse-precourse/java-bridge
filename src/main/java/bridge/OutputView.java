package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public String printMap(String lastPrint, String moving, boolean tOrF) {
		String result = "X";
		String firstOrNot = "| ";
		String[] splitedResult = lastPrint.split("\n");
		if (tOrF)
			result = "O";
		if(splitedResult[0].length()<4)
			firstOrNot = "";

		if (moving.equals("U")) {
			splitedResult[0] = splitedResult[0].replace("]", firstOrNot + result + " ]");
			splitedResult[1] = splitedResult[1].replace("]", firstOrNot+ "  ]");
		}
		if (moving.equals("D")) {
			splitedResult[0] = splitedResult[0].replace("]", firstOrNot+ "  ]");
			splitedResult[1] = splitedResult[1].replace("]", firstOrNot+ result + " ]");
		}

		result = splitedResult[0] + "\n" + splitedResult[1]+ "\n";
		System.out.println(result);
		return result;
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(BridgeGame bridgeGame, boolean tOrF, int count) {
		System.out.println("최종 게임 결과\n" + bridgeGame.getLastPrint() + "\n");
		System.out.print("게임 성공 여부: ");
		if (tOrF)
			System.out.println("성공");
		if (!tOrF)
			System.out.println("실패");
		System.out.println("총 시도한 횟수: " + count);
	}
}
