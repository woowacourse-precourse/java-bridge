package bridge.view;

import bridge.domain.BridgeGame;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String BRIDGE_NOT_GONE = "   ";
    private static final String BRIDGE_GONE_RIGHT = " O ";
    private static final String BRIDGE_GONE_FAILED = " X ";
    private static final String BRIDGE_SEPERATOR = "|";

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printBridgeSizeQuestion() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printBridgeGameUpDownQuestion() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRetryBridgeGame() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        List<String> bridge = bridgeGame.getBridge();
        List<String> user = bridgeGame.getUser();
        System.out.println(getBridgeTopLine(bridge, user));
        System.out.println(getBridgeBottomLine(bridge, user));
    }

    private String getBridgeTopLine(List<String> bridge, List<String> user) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> bridgeTopLineGroup = getBridgeTopLineGroup(bridge, user);
        for (String bridgeElement : bridgeTopLineGroup) {
            stringBuilder.append(bridgeElement);
        }
        return stringBuilder.toString();
    }

    private List<String> getBridgeTopLineGroup(List<String> bridge, List<String> user) {
        List<String> bridgeTopLineGroup = new ArrayList<>();
        bridgeTopLineGroup.add("[");
        for (int i = 0; i < user.size(); i++) {
            bridgeTopLineGroup.add(getBridgeTopSingleElement(bridge.get(i), user.get(i)));
            if (i != user.size() - 1) {
                bridgeTopLineGroup.add(BRIDGE_SEPERATOR);
            }
        }
        bridgeTopLineGroup.add("]");
        return bridgeTopLineGroup;
    }

    private String getBridgeTopSingleElement(String bridgeSingleElem, String userSingleElem) {
        if (bridgeSingleElem.equals("U") && userSingleElem.equals("U")) {
            return BRIDGE_GONE_RIGHT;
        }
        if (bridgeSingleElem.equals("U") && userSingleElem.equals("D")) {
            return BRIDGE_NOT_GONE;
        }
        if (bridgeSingleElem.equals("D") && userSingleElem.equals("U")) {
            return BRIDGE_GONE_FAILED;
        }
        return BRIDGE_NOT_GONE;
    }

    private String getBridgeBottomLine(List<String> bridge, List<String> user) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> bridgeBottomLineGroup = getBridgeBottomLineGroup(bridge, user);
        for (String bridgeElement : bridgeBottomLineGroup) {
            stringBuilder.append(bridgeElement);
        }
        return stringBuilder.toString();
    }

    private List<String> getBridgeBottomLineGroup(List<String> bridge, List<String> user) {
        List<String> bridgeBottomLineGroup = new ArrayList<>();
        bridgeBottomLineGroup.add("[");
        for (int i = 0; i < user.size(); i++) {
            bridgeBottomLineGroup.add(getBridgeBottomSingleElement(bridge.get(i), user.get(i)));
            if (i != user.size() - 1) {
                bridgeBottomLineGroup.add(BRIDGE_SEPERATOR);
            }
        }
        bridgeBottomLineGroup.add("]");
        return bridgeBottomLineGroup;
    }

    private String getBridgeBottomSingleElement(String bridgeSingleElem, String userSingleElem) {
        if (bridgeSingleElem.equals("U") && userSingleElem.equals("U")) {
            return BRIDGE_NOT_GONE;
        }
        if (bridgeSingleElem.equals("U") && userSingleElem.equals("D")) {
            return BRIDGE_GONE_FAILED;
        }
        if (bridgeSingleElem.equals("D") && userSingleElem.equals("U")) {
            return BRIDGE_NOT_GONE;
        }
        return BRIDGE_GONE_RIGHT;
    }

    public void printResultTitle() {
        System.out.println("최종 게임 결과");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isGameEnd, Integer tryCount) {
        System.out.println(getGameResult(isGameEnd));
        System.out.println("총 시도한 횟수: " + tryCount);
    }

    private String getGameResult(boolean isGameEnd) {
        if (isGameEnd) {
            return "게임 성공 여부: 성공";
        }
        return "게임 성공 여부: 실패";
    }
}
