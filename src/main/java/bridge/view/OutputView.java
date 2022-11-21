package bridge.view;

import bridge.domain.BridgeLog;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeLog log) {
        printOneWidthBridge(log.getMap(0));
        printOneWidthBridge(log.getMap(1));
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeLog log, boolean isSuccess, int retryCount) {
        printResultMap(log);

        System.out.println("게임 성공 여부: " + successOrFailure(isSuccess));
        System.out.println("총 시도한 횟수: " + retryCount);
    }

    public void printResultMap(BridgeLog log) {
        System.out.println("최종 게임 결과");
        printMap(log);
    }

    private String successOrFailure(boolean isSuccess) {
        if (isSuccess) {
            return "성공";
        }
        return "실패";
    }

    private void printOneWidthBridge(List<String> bridgeLog) {
        String oneLine = String.join(" | ", bridgeLog);
        System.out.println("[ " + oneLine + " ]");
    }
}
