package bridge;

import bridge.constant.BridgeGameStstus;
import bridge.constant.BridgeMoveCommand;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String BRIDGE_PASS = "O";
    private static final String BRIDGE_FAIL = "X";

    private List<String> upperBridge;
    private List<String> lowerBridge;

    private String upperBridgeView;
    private String lowerBridgeView;

    public OutputView() {
        upperBridge = new ArrayList<>();
        lowerBridge = new ArrayList<>();
    }

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * BridgeGame을 받아 다리의 상태를 출력
     */
    public void printMap(BridgeGame bridgeGame) {
        initBridgeMap();

        parseBridge(bridgeGame);

        completeBridgeMap();
        System.out.println(upperBridgeView);
        System.out.println(lowerBridgeView);
        System.out.println("");
    }

    private void parseBridge(BridgeGame bridgeGame) {
        List<String> bridge = bridgeGame.getBridge();
        int step = bridgeGame.getStep();
        BridgeGameStstus status = bridgeGame.getStatus();

        for (int i = 0; i < bridgeGame.getStep() - 1; i++) {
            addBridgeInfoByDirection(bridge.get(i), BRIDGE_PASS);
        }
        addBridgeInfoByDirection(bridge.get(step - 1), getPassOrFail(status));
    }

    private void initBridgeMap() {
        upperBridge.clear();
        lowerBridge.clear();
    }

    private void addBridgeInfoByDirection(String dir, String info) {
        if (dir.equals(BridgeMoveCommand.MOVE_UP.command)) {
            upperBridge.add(info);
            lowerBridge.add(" ");
            return;
        }
        lowerBridge.add(info);
        upperBridge.add(" ");
    }

    private String getPassOrFail(BridgeGameStstus status){
        if (status == BridgeGameStstus.FAIL) {
            return BRIDGE_FAIL;
        }
        return BRIDGE_PASS;
    }

    private void completeBridgeMap() {
        upperBridgeView = String.join(" | ", upperBridge);
        lowerBridgeView = String.join(" | ", lowerBridge);
        upperBridgeView = "[ " + upperBridgeView + " ]";
        lowerBridgeView = "[ " + lowerBridgeView + " ]";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * BridgeGame을 받아 최종 결과를 출력
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);
        printResultStatistic(bridgeGame);
    }

    private void printResultStatistic(BridgeGame bridgeGame){
        int step = bridgeGame.getStep();
        BridgeGameStstus status = bridgeGame.getStatus();
        String passOrFail = "성공";
        if(status == BridgeGameStstus.FAIL){
            passOrFail = "실패";
        }
        System.out.println("게임 성공 여부: " + passOrFail);
        System.out.println("총 시도한 횟수: " + (step - 1));
    }
}
