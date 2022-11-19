package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStartScript() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printBridgeSizeInputScript() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printMovingInputScript() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printGameCommandInputScript() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printGameResultScript() {
        System.out.println("최종 게임 결과");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<BridgeGameStage> currentGameStages) {
        List<String> upBridgeBlockViews = new ArrayList<>(), downBridgeBlockViews = new ArrayList<>();
        for (BridgeGameStage gameStage : currentGameStages) {
            upBridgeBlockViews.add(getUpBridgeBlockView(gameStage.getBridgeBlock(), gameStage.getStatus()));
            downBridgeBlockViews.add(getDownBridgeBlockView(gameStage.getBridgeBlock(), gameStage.getStatus()));
        }
        System.out.println(buildBridgeView(upBridgeBlockViews));
        System.out.println(buildBridgeView(downBridgeBlockViews));
    }

    private String getUpBridgeBlockView(String bridgeBlock, Status blockStatus) {
        if (Objects.equals(bridgeBlock, "U")) {
            if (blockStatus == Status.CROSSED) return " O ";
            return "   ";
        }
        if (blockStatus == Status.NOT_CROSSED) return " X ";
        return "   ";
    }

    private String getDownBridgeBlockView(String bridgeBlock, Status blockStatus) {
        if (Objects.equals(bridgeBlock, "D")) {
            if (blockStatus == Status.CROSSED) return " O ";
            return "   ";
        }
        if (blockStatus == Status.NOT_CROSSED) return " X ";
        return "   ";
    }

    private String buildBridgeView(List<String> bridgeBlockViews) {
        StringBuilder builder = new StringBuilder();
        builder.append("[").append(bridgeBlockViews.remove(0));
        bridgeBlockViews.forEach(view -> builder.append("|").append(view));
        builder.append("]");
        return builder.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isSuccess, int numberOfAttempt) {
        String gameResultPhrase = getGameResultPhrase(isSuccess);
        System.out.println("게임 성공 여부: " + gameResultPhrase);
        System.out.println("총 시도한 횟수: " + numberOfAttempt);
    }

    private String getGameResultPhrase(boolean isSuccess) {
        if (isSuccess) return "성공";
        return "실패";
    }
}
