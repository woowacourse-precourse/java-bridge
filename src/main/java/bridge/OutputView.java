package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String FORMAT_BORDER = "[%s]";
    private static final String GAME_END_MESSAGE = "\n최종 게임 결과";
    private static final String GAME_SUCCESS_OR_NOT_RESULT_MESSAGE = "\n게임 성공 여부: %s";
    private static final String NUMBER_OF_GAME_PLAY_MESSAGE = "총 시도한 횟수: %d";
    private static final String SUCCESS = "성공";
    private static final String NOT = "실패";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeResults bridgeResults) {
        System.out.println(String.format(FORMAT_BORDER, bridgeResults.getUpBridgeResult()));
        System.out.println(String.format(FORMAT_BORDER, bridgeResults.getDownBridgeResult()));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeResults bridgeResults, boolean gameResult, int gameCount) {
        System.out.println(GAME_END_MESSAGE);
        printMap(bridgeResults);
        String gameSuccessOrNotResult= SUCCESS;
        if(gameResult) {
            gameSuccessOrNotResult = NOT;
        }
        System.out.println(String.format(GAME_SUCCESS_OR_NOT_RESULT_MESSAGE, gameSuccessOrNotResult));
        System.out.println(String.format(NUMBER_OF_GAME_PLAY_MESSAGE, gameCount));
    }
}
