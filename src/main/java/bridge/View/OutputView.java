package bridge.View;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartMessage() {
        System.out.println(GameMessage.GAME_START_MESSAGE.getGameMessage());
    }

    public void printMapMessage() {
        System.out.println(GameMessage.GAME_MAP_MESSAGE.getGameMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> result) {
        StringBuilder resultMap = new StringBuilder();

        for (int index = 0; index < result.size(); index++) {
            boolean validBar = index != result.size() - 1;
            if (!validBar) resultMap.append(result.get(index));
            if (validBar) resultMap.append(result.get(index)).append(" | ");
        }

        System.out.println("[ " + resultMap + " ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isSuccess, int reGameCount) {
        if (isSuccess) {
            System.out.println(GameMessage.GAME_SUCCESS_STATUS.getGameMessage()
                    + GameMessage.GAME_SUCCESS.getGameMessage());
        }
        if (!isSuccess) {
            System.out.println(GameMessage.GAME_SUCCESS_STATUS.getGameMessage()
                    + GameMessage.GAME_FAILURE.getGameMessage());
        }
        System.out.println(GameMessage.GAME_TRY_COUNT.getGameMessage() + reGameCount);
    }
}
