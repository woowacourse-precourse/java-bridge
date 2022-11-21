package bridge.ui;

import bridge.business.enumeration.MovingKey;

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
    public void printMap(boolean success, List<String> bridge) {
        String upLane = getLane(MovingKey.UP.getKey(), success, bridge);
        String downLane = getLane(MovingKey.DOWN.getKey(), success, bridge);

        System.out.println(upLane);
        System.out.println(downLane);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isSuccess, int count) {
        System.out.println("게임 성공 여부: " + getSuccess(isSuccess));
        System.out.println("총 시도한 횟수: " + count);
    }

    public void printValue(String value) {
        System.out.println(value);
    }

    public void printStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("");
    }

    public void printEnd(){
        System.out.println("최종 게임 결과");
    }

    public void printLength(){
        System.out.println("다리의 길이를 입력해주세요.");
    }
    public void printNextStep(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printReStart(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printSpace() {
        System.out.println("");
    }

    public void printError(IllegalArgumentException e) {
        System.out.println("[ERROR] "+ e.getMessage());
    }

    private String getLane(String isUp, boolean isSuccess, List<String> bridge){
        StringBuilder lane = drawLane(isUp, bridge);
        if(bridge.get(bridge.size()-1).equals(isUp) && !isSuccess){
            changeLastValue(lane);
        }
        return lane.toString();
    }

    private StringBuilder drawLane(String isUp, List<String> bridge){
        StringBuilder lane = new StringBuilder("[");
        for(String position : bridge){
            if(position.equals(isUp)){
                lane.append(" O |");
                continue;
            }
            lane.append("   |");
        }
        lane.replace(lane.length()-1, lane.length(), "]");
        return lane;
    }

    private void changeLastValue(StringBuilder lane){
        lane.replace(lane.length()-3, lane.length(), "X ]");
    }

    private String getSuccess(boolean isSuccess){
        if(isSuccess){
            return "성공";
        }
        return "실패";
    }
}
