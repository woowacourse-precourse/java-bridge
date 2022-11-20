package bridge.view;

import bridge.constants.OutputMessage;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    OutputMessage outputMessage = new OutputMessage();
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String map) {
        StringBuilder sb = new StringBuilder();
        String bridge = map.replace(", ", " | ")
                .replace("[", "[ ")
                .replace("]", " ]");
        sb.append(bridge).append("\n");
        printMessage(sb.toString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String userBridge, boolean isFail, int tryCount) {
        printMessage("\n" + outputMessage.RESULT_MESSAGE);
        printMap(userBridge);
        if(isFail) {
            printMessage(outputMessage.FINAL_GAME_RESULT + outputMessage.FAIL);
        }
        if(!isFail) {
            printMessage(outputMessage.FINAL_GAME_RESULT + outputMessage.SUCCESS);
        }
        printMessage(outputMessage.TRY_COUNT + tryCount);
    }
}
