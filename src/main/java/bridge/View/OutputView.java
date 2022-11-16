package bridge.View;

import java.util.ArrayList;
import java.util.List;

import bridge.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(String[][] map) {
		//맨 마지막에 StringBuffer사용. append()랑 indexOf("찾을문자") 이용해서 | 끼워넣자
		//출력할 때 맨 마지막에 [,] 넣자
		//makeMap();

		for (int rowIndex = 0; rowIndex < map.length; rowIndex++) {
			StringBuffer mapResult = new StringBuffer();
			mapResult.append("[");
			for (int colIndex = 0; colIndex < map[rowIndex].length; colIndex++) {
				mapResult.append(map[rowIndex][colIndex]);

				if(colIndex<map[rowIndex].length -1){
					mapResult.append("|");
				}
			}
			mapResult.append("]");
			System.out.println(mapResult);
		}

	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult() {
	}
}
