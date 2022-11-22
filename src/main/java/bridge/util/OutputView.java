package bridge.util;

import bridge.BridgeInfo;
import bridge.constant.Message;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<BridgeInfo> infos) {
        System.out.print(BridgeInfo.HEAD.getMart());
        System.out.print(String.join(BridgeInfo.DELIMITER.getMart(),
                infos.stream().map(BridgeInfo::getMart).collect(Collectors.toList())));
        System.out.println(BridgeInfo.TAIL.getMart());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean result, int count) {
        System.out.print(Message.GAME_IS_CLEAR.getMessage());
        System.out.println(Message.getClear(result).getMessage());
        System.out.print(Message.GAME_COUNT.getMessage());
        System.out.print(count);
    }

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public void printErrorMessage(String message) {
        System.out.print("[ERROR] ");
        System.out.println(message);
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
