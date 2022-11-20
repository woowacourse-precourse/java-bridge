package bridge.view;

import bridge.util.ConstantMessage;
import bridge.util.Exceptions;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static String printGameStartPhrase() {
        return "다리 건너기 게임을 시작합니다.";
    }

    public static String printBridgeLengthInputPhrase() {
        return "다리의 길이를 입력해주세요.";
    }

    public static String printBridgeLengthErrorMessage(String readLine) {
        String result;
        result = Exceptions.validateBridgeLength(readLine);
        if (!result.equals(ConstantMessage.BRIDGE_LENGTH_ERROR_MESSAGE)) {
            return result;
        }
        System.out.println(result);
        return result;
    }

    public static String printMovindBlockInputPhrase() {
        return "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
