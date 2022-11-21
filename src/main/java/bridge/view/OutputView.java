package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    StringBuilder sb = new StringBuilder();
    StringBuilder tmp = new StringBuilder();
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upperBridge, List<String> downBridge) {
        String bridgeStatus = getBridgeStatus(upperBridge, downBridge);
        System.out.println(bridgeStatus);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int count, boolean isCorrect) {
        System.out.println(getResultString(count, isCorrect));
    }

    public void printStartGuide(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printInputBridgeLengthGuide(){
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printInputMoveOptionGuide(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printInputRestartOptionGuide(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printFinalResultGuide(){
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

    private String getResultString(int count, boolean isCorrect){
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
