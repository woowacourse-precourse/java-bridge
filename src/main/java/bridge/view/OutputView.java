package bridge.view;

import bridge.domain.game.BridgeGame;
import bridge.domain.game.BridgeGameResult;

import java.util.List;
import java.util.stream.Collectors;


public class OutputView {
    StringBuilder sb = new StringBuilder();

    public void printMap(BridgeGameResult bridgeGameResult) {
        String bridgeStatus = getBridgeStatus(bridgeGameResult);
        System.out.println(bridgeStatus);
    }

    public void printFinalResult(BridgeGame bridgeGame, boolean isCorrect) {
        printFinalResultGuide();
        printMap(bridgeGame.getGameResult());
        System.out.println(getResultString(bridgeGame.getGameRoundCount(), isCorrect));
    }

    public void printStartGuide() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printInputBridgeLengthGuide() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printInputMovingGuide() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printInputRestartOptionGuide() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printFinalResultGuide() {
        System.out.println("최종 게임 결과");
    }

    public String getBridgeStatus(BridgeGameResult bridgeGameResult) {
        sb.setLength(0);
        sb.append(getSingleBridgeStatus(bridgeGameResult.getUpperBridge()))
                .append("\n")
                .append(getSingleBridgeStatus(bridgeGameResult.getDownBridge()))
                .append("\n");
        return sb.toString();
    }

    private String getSingleBridgeStatus(List<String> bridge) {
        return bridge.stream()
                .collect(Collectors.joining(" | ", "[ ", " ]"));
    }

    private String getResultString(int count, boolean isCorrect) {
        sb.setLength(0);

        sb.append(getIsCorrectString(isCorrect))
                .append("\n")
                .append(getCountString(count))
                .append("\n");
        return sb.toString();
    }

    private String getCountString(int count) {
        return String.format("총 시도한 횟수: %d", count);
    }

    private String getIsCorrectString(boolean isCorrect) {
        return String.format("게임 성공 여부: %s", changeIsCorrectToString(isCorrect));
    }

    private String changeIsCorrectToString(boolean isCorrect) {
        if (isCorrect) {
            return "성공";
        }
        return "실패";
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printRetryGuide(int tryCnt, int maxtry) {
        System.out.printf("[ERROR] 다시 입력해주십시오. (최대 %d번의 기회 제공, 현재 %d번 시도)\n", maxtry, tryCnt);
    }
}
