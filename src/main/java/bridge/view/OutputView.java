package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.Results;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String OUTPUT_MESSAGE_RESULT = "\n최종 게임 결과";
    private static final String OUTPUT_MESSAGE_SUCCESSORFAIL = "게임 성공 여부: ";
    private static final String OUTPUT_MESSAGE_TRIAL = "총 시도한 횟수: ";
    private static final String CLOSED_BRACKET = " ]";
    private static final String PARTITION = " | ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Results results) {
        String up = results.getUp();
        String down = results.getDown();
        printUp(up);
        printDown(down);
    }

    private void printUp(String up) {
        System.out.print(up.substring(0, 3));
        for (int i = 3; i < up.length(); i++) {
            System.out.printf(PARTITION + "%c", up.charAt(i));
        }
        System.out.println(CLOSED_BRACKET);
    }

    private void printDown(String down) {
        System.out.print(down.substring(0, 3));
        for (int i = 3; i < down.length(); i++) {
            System.out.printf(" | %c", down.charAt(i));
        }
        System.out.println(CLOSED_BRACKET);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(OUTPUT_MESSAGE_RESULT);
        printMap(bridgeGame.getResults());
        System.out.println();
        System.out.printf(OUTPUT_MESSAGE_SUCCESSORFAIL + "%s\n", bridgeGame.getSuccessOrFail());
        System.out.printf(OUTPUT_MESSAGE_TRIAL + "%d", bridgeGame.getTrial());
    }
}
