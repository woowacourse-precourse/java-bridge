package view.output;

import java.util.Arrays;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * <p>
 * 요구사항
 * 1. 제공된 OutputView 클래스를 활용해 구현해야 한다.
 * 2. OutputView 의 패키지는 변경할 수 있다.
 * 3. OutputView 의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 4. 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class OutputView {
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String END_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_OR_FAIL = "게임 성공 여부: ";
    private static final String TOTAL_NUMBER = "총 시도한 횟수: ";
    private static StringBuilder upSideBridge;
    private static StringBuilder downSideBridge;

    public void bridgeInit() {
        upSideBridge = new StringBuilder("[  ]");
        downSideBridge = new StringBuilder("[  ]");
    }
    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(boolean isAnswer, boolean isFirst, String crossBridge) {
        Arrays.stream(BridgePrinter.values())
                .filter(bridgePrinter -> isAnswer == bridgePrinter.isAnswer())
                .filter(bridgePrinter -> isFirst == bridgePrinter.isFirst())
                .filter(bridgePrinter -> crossBridge.equals(bridgePrinter.getMark()))
                .forEach(bridgePrinter -> bridgePrinter.addPrintBridge(upSideBridge, downSideBridge));
        System.out.println(upSideBridge + "\n" + downSideBridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int recursiveCount, String result) {
        System.out.println(END_MESSAGE);
        System.out.println(upSideBridge + "\n" + downSideBridge + "\n");
        System.out.println(SUCCESS_OR_FAIL + result + "\n" + TOTAL_NUMBER + recursiveCount);
    }
}