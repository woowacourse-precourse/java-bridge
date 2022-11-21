package bridge.view;

import bridge.domain.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String MAKE_BRIDGE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVE_CHOOSE_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String CHOOSE_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String FINAL_RESULT_MESSAGE = "\n최종 게임 결과";
    private static final String CLEAR_CONFIRM = "\n게임 성공 여부: %s\n";
    private static final String TOTAL_TRY_COUNT = "총 시도한 횟수: %d\n";


    private BridgePrinter bridgePrinter = new BridgePrinter();

    public void printStartMessage(){
        System.out.println(START_MESSAGE);
        System.out.println(MAKE_BRIDGE_MESSAGE);
    }

    public void printMoveChooseMessage(){
        System.out.println(MOVE_CHOOSE_MESSAGE);
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param bridgeGame
     */
    public void printMap(BridgeGame bridgeGame) {
        bridgePrinter.print(bridgeGame);
    }

    public void printChooseRetry() {
        System.out.println(CHOOSE_RETRY);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param bridgeGame
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(FINAL_RESULT_MESSAGE);
        printMap(bridgeGame);
        System.out.printf(CLEAR_CONFIRM, bridgeGame.getClearConfirm());
        System.out.printf(TOTAL_TRY_COUNT,bridgeGame.getTryCount());
    }
}
