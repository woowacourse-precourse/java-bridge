package bridge.view;

import bridge.domain.game.BridgeGameResult;

import java.util.List;


public class OutputView {
    StringBuilder sb = new StringBuilder();

    public void printMap(BridgeGameResult bridgeGameResult) {
        String bridgeStatus = getBridgeStatus(bridgeGameResult);
        System.out.println(bridgeStatus);
    }

    public void printResult(int count, boolean isCorrect) {
        printFinalResultGuide();
        System.out.println(getResultString(count, isCorrect));
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

    public String getBridgeStatus(List<String> upperBridge, List<String> downBridge){
        sb.setLength(0);
        sb.append(getSingleBridgeStatus(upperBridge))
                .append("\n")
                .append(getSingleBridgeStatus(downBridge))
                .append("\n");
        return sb.toString();
    }

    private String getSingleBridgeStatus(List<String> bridge){
        tmp.setLength(0);

        tmp.append(getStartBridgeNotation())
                .append(String.join(" | ", bridge))
                .append(getEndBridgeNotation());
        return tmp.toString();
    }


    private String getStartBridgeNotation(){
        return "[ ";
    }

    private String getEndBridgeNotation(){
        return " ]";
    }

    private String getResultString(int count, boolean isCorrect) {
        sb.setLength(0);

        sb.append(getIsCorrectString(isCorrect))
                .append("\n")
                .append(getCountString(count))
                .append("\n");
        return sb.toString();
    }

    private String getCountString(int count){
        tmp.setLength(0);
        tmp.append("총 시도한 횟수: ").append(count);
        return tmp.toString();
    }

    private String getIsCorrectString(boolean isCorrect){
        tmp.setLength(0);
        tmp.append("게임 성공 여부: ").append(changeIsCorrectToString(isCorrect));
        return tmp.toString();
    }

    private String changeIsCorrectToString(boolean isCorrect){
        if(isCorrect){
            return "성공";
        }
        return "실패";
    }
}
