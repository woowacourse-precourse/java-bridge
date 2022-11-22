package bridge.view;

import bridge.controller.BridgeController;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String OUTPUT_START = "다리 건너기 게임을 시작합니다.";
    private static final String FINAL_GAME_RESULT = "최종 게임 결과";
    private static final String GAME_IS_SUCCES = "게임 성공 여부: ";
    private static final String GAME_COUNT = "총 시도한 횟수: ";
    private final BridgeController controller;

    public OutputView(BridgeController controller){
        this.controller = controller;
    }
    public static void printStart(){
        System.out.println(OUTPUT_START);
        System.out.println();
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        System.out.println(controller.outputPlayerBridge());
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(FINAL_GAME_RESULT);
        System.out.println(controller.outputPlayerBridge());
        System.out.println();
        System.out.print(GAME_IS_SUCCES);
        System.out.println(controller.outputResult());
        System.out.print(GAME_COUNT);
        System.out.println(controller.outputGameCount());
    }
}
