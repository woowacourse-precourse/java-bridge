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
	public void printMap(Bridge bridge, int idx, String block, boolean correct) {
		printUp(bridge, idx, block, correct);
		printDown(bridge, idx, block, correct);
	}

	public void printUp(Bridge bridge, int idx, String block, boolean correct) {
		System.out.print("[");
		for (int i = 0; i <= idx; i++) {
			checkFirstUpBlock(i, idx, bridge.getBridge().get(0), block);
			checkSecondToBeforeEndUpBlocks(i, idx, bridge.getBridge().get(i));
			checkEndBlockUpBlock(i, idx, block, correct);
		}
		System.out.println("]");
	}

	public void printDown(Bridge bridge, int idx, String block, boolean correct) {
		System.out.print("[");
		for (int i = 0; i <= idx; i++) {
			checkFirstDownBlock(i, idx, bridge.getBridge().get(0), block);
			checkSecondToBeforeEndDownBlocks(i, idx, bridge.getBridge().get(i));
			checkEndBlockDownBlock(i, idx, block, correct);
		}
		System.out.println("]");
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(Bridge bridge, int idx, String block, boolean correct, int numberOfAttempts) {
		System.out.println("최종 게임 결과");
		printUp(bridge, idx, block, correct);
		printDown(bridge, idx, block, correct);

		if (correct) {
			System.out.println("게임 성공 여부: 성공");
		} else {
			System.out.println("게임 성공 여부: 실패");
		}
		System.out.println("총 시도한 횟수: " + numberOfAttempts);
	}

	private void checkFirstUpBlock(int firstIdx, int idx, String bridgeBlock, String block) {
		if (firstIdx == 0 && idx == 0) {
			checkFirstUpBridgeAndBlockSameIndexZero(bridgeBlock, block);
			checkFirstUpBridgeAndBlockDifferentIndexZero(bridgeBlock, block);
		}
		if (firstIdx == 0 && idx != 0) {
			checkFirstUpBridgeAndBlockIndexNotZero(bridgeBlock);
		}
	}

	private void checkFirstDownBlock(int firstIdx, int idx, String bridgeBlock, String block) {
		if (firstIdx == 0 && idx == 0) {
			checkFirstDownBridgeAndBlockSameIndexZero(bridgeBlock, block);
			checkFirstDownBridgeAndBlockDifferentIndexZero(bridgeBlock, block);
		}
		if (firstIdx == 0 && idx != 0) {
			checkFirstDownBridgeAndBlockIndexNotZero(bridgeBlock);
		}
	}

	private void checkFirstUpBridgeAndBlockSameIndexZero(String bridgeBlock, String block) {
		if (bridgeBlock.equals("U") && block.equals("U")) {
			System.out.print(" O ");
		}
		if (bridgeBlock.equals("D") && block.equals("D")) {
			System.out.print("   ");
		}
	}

	private void checkFirstDownBridgeAndBlockSameIndexZero(String bridgeBlock, String block) {
		if (bridgeBlock.equals("D") && block.equals("D")) {
			System.out.print(" O ");
		}
		if (bridgeBlock.equals("U") && block.equals("U")) {
			System.out.print("   ");
		}
	}

	private void checkFirstUpBridgeAndBlockDifferentIndexZero(String bridgeBlock, String block) {
		if (bridgeBlock.equals("U") && block.equals("D")) {
			System.out.print("   ");
		}
		if (bridgeBlock.equals("D") && block.equals("U")) {
			System.out.print(" X ");
		}
	}

	private void checkFirstDownBridgeAndBlockDifferentIndexZero(String bridgeBlock, String block) {
		if (bridgeBlock.equals("D") && block.equals("U")) {
			System.out.print("   ");
		}

		if (bridgeBlock.equals("U") && block.equals("D")) {
			System.out.print(" X ");
		}
	}

	private void checkFirstUpBridgeAndBlockIndexNotZero(String bridgeBlock) {
		if (bridgeBlock.equals("U")) {
			System.out.print(" O ");
		}
		if (bridgeBlock.equals("D")) {
			System.out.print("   ");
		}
	}

	private void checkFirstDownBridgeAndBlockIndexNotZero(String bridgeBlock) {
		if (bridgeBlock.equals("D")) {
			System.out.print(" O ");
		}
		if (bridgeBlock.equals("U")) {
			System.out.print("   ");
		}
	}

	private void checkSecondToBeforeEndUpBlocks(int i, int idx, String block) {
		if (0 < i && i < idx) {
			if (block.equals("U")) {
				System.out.print("| O ");
			}
			if (block.equals("D")) {
				System.out.print("|   ");
			}
		}
	}

	private void checkSecondToBeforeEndDownBlocks(int i, int idx, String block) {
		if (0 < i && i < idx) {
			if (block.equals("D")) {
				System.out.print("| O ");
			}
			if (block.equals("U")) {
				System.out.print("|   ");
			}
		}
	}

	private void checkEndBlockUpBlock(int i, int idx, String block, boolean correct) {
		if (i == idx && idx != 0) {
			checkEndBlockUpBlockCorrect(block, correct);
			checkEndBlockUpBlockNotCorrect(block, correct);
		}
	}

	private void checkEndBlockDownBlock(int i, int idx, String block, boolean correct) {
		if (i == idx && idx != 0) {
			checkEndBlockDownBlockCorrect(block, correct);
			checkEndBlockDownBlockNotCorrect(block, correct);
		}
	}

	private void checkEndBlockUpBlockCorrect(String block, boolean correct) {
		if (correct) {
			if (block.equals("U")) {
				System.out.print("| O ");
			}
			if (block.equals("D")) {
				System.out.print("|   ");
			}
		}
	}

	private void checkEndBlockUpBlockNotCorrect(String block, boolean correct) {
		if (!correct) {
			if (block.equals("U")) {
				System.out.print("| X ");
			}
			if (block.equals("D")) {
				System.out.print("|   ");
			}
		}
	}

	private void checkEndBlockDownBlockCorrect(String block, boolean correct) {
		if (correct) {
			if (block.equals("D")) {
				System.out.print("| O ");
			}
			if (block.equals("U")) {
				System.out.print("|   ");
			}
		}
	}

	private void checkEndBlockDownBlockNotCorrect(String block, boolean correct) {
		if (!correct) {
			if (block.equals("D")) {
				System.out.print("| X ");
			}
			if (block.equals("U")) {
				System.out.print("|   ");
			}
		}
	}

}
