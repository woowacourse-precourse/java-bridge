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
	public void printMap(Bridge bridge,int idx , String block) {
		printUp(bridge,idx,block);
		printDown(bridge,idx,block);
	}

	public void printUp(Bridge bridge, int idx , String block){
		System.out.print("[ ");
		for (int i=0;i<idx;i++){
			if (bridge.getBridge().get(i).equals("U")){
				System.out.print("O ");
			}
			if (bridge.getBridge().get(i).equals("D")){
				System.out.print("  ");
			}
		}

		if (bridge.getBridge().get(idx).equals(block)){
			System.out.print("O ");
		}
		if (!bridge.getBridge().get(idx).equals(block)){
			System.out.print("X ");
		}

		System.out.println("]");
	}

	public void printDown(Bridge bridge, int idx, String block){
		System.out.print("[ ");
		for (int i=0;i<idx;i++){
			if (bridge.getBridge().get(i).equals("D")){
				System.out.print("O ");
			}
			if (bridge.getBridge().get(i).equals("U")){
				System.out.print("  ");
			}
		}

		if (bridge.getBridge().get(idx).equals(block)){
			System.out.print("O ");
		}
		if (!bridge.getBridge().get(idx).equals(block)){
			System.out.print("X ");
		}

		System.out.println("]");
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(Bridge bridge, int idx , String block) {
		System.out.println("최종 게임 결과");
		printUp(bridge,idx,block);
		printUp(bridge,idx,block);

		System.out.println("게임 성공 여부: ");
		System.out.println("총 시도한 횟수: ");
	}
}
