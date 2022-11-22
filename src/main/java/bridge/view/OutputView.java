package bridge.view;

import bridge.model.CurrentLocationInformation;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String gameState) {
        System.out.println(gameState);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int challengeCount, boolean state) {
        String resultLocation = CurrentLocationInformation.getResultLocation();
        System.out.println(GameMessage.GAME_RESULT_MESSAGE.getGameMessage());
        System.out.println(resultLocation);
        System.out.println();
        printWinOrFail(state);
        System.out.print(GameMessage.GAME_TRY_COUNT_MESSAGE.getGameMessage() + challengeCount);
    }

    private void printWinOrFail(boolean state) {
        if (state) {
            System.out.println(GameMessage.GAME_WIN_MESSAGE.getGameMessage());
        }
        if (!state) {
            System.out.println(GameMessage.GAME_FAIL_MESSAGE.getGameMessage());
        }
    }

    public void printStartMessage() {
        System.out.println(GameMessage.GAME_START_MESSAGE.getGameMessage());
        System.out.println();
    }
}
