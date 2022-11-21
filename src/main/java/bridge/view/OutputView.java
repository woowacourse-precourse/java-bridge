package bridge.view;

import bridge.domain.BridgeGame;

public class OutputView {
    private static final String START = "[";
    private static final String END = "]";
    private static final String SEPARATOR = "|";
    private static final String CORRECT = " O ";
    private static final String INCORRECT = " X ";
    private static final String BLANK = "   ";
    private static final String GAME_RESULT = "최종 게임 결과";
    private static final String GAME_SUCCESS_MESSAGE = "성공";
    private static final String GAME_FAIL_MESSAGE = "실패";

    private final StringBuilder upperBridge = new StringBuilder();
    private final StringBuilder lowerBridge = new StringBuilder();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame, String direction) {
        makeMap(bridgeGame.getCurrentIndex(), bridgeGame.isGameContinue(), direction);
        System.out.println(START + upperBridge + END);
        System.out.println(START + lowerBridge + END);
        System.out.println();
    }

    private void makeMap(int bridgeIndex, boolean isCorrect, String direction) {
        addSeparator(upperBridge, bridgeIndex);
        addSeparator(lowerBridge, bridgeIndex);
        if (direction.equals("U")) {
            addStatus(upperBridge, isCorrect);
            addBlank(lowerBridge);
            return;
        }
        addBlank(upperBridge);
        addStatus(lowerBridge, isCorrect);
    }

    private void addBlank(StringBuilder str) {
        str.append(BLANK);
    }

    private void addStatus(StringBuilder str, boolean isCorrect) {
        if (isCorrect) {
            str.append(CORRECT);
            return;
        }
        str.append(INCORRECT);
    }

    private void addSeparator(StringBuilder str, int bridgeIndex) {
        if (bridgeIndex != 0) {
            str.append(SEPARATOR);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(GAME_RESULT);
        System.out.println(START + upperBridge + END);
        System.out.println(START + lowerBridge + END);
        System.out.println();
        System.out.printf("게임 성공 여부: %s%n", getResult(bridgeGame));
        System.out.printf("총 시도한 횟수: %d", bridgeGame.getTrialCount());
    }

    private String getResult(BridgeGame bridgeGame) {
        if (bridgeGame.isGameSuccess()) {
            return GAME_SUCCESS_MESSAGE;
        }
        return GAME_FAIL_MESSAGE;
    }
}
