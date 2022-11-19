package bridge.ui;

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
    public void printMap(boolean isSuccess, List<Boolean> bridge) {
        String upLane = getLane(true, isSuccess, bridge);
        String downLane = getLane(false, isSuccess, bridge);

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

    private String getLane(boolean isUp, boolean isSuccess, List<Boolean> bridge){
        StringBuilder lane = drawLane(isUp, bridge);
        changeLastValue(isSuccess, lane);

        return lane.toString();
    }
    private StringBuilder drawLane(boolean isUp, List<Boolean> bridge){
        StringBuilder lane = new StringBuilder("[");

        for(boolean position : bridge){
            if(position == isUp){
                lane.append(" O |");
                continue;
            }
            lane.append("   |");
        }
        return lane;
    }

    private void changeLastValue(boolean isSuccess, StringBuilder lane){
        if(!isSuccess){
            lane.replace(lane.length()-3, lane.length(), "X ]");
        }
        lane.replace(lane.length()-1, lane.length(), "]");
    }

    private String getSuccess(boolean isSuccess){
        if(isSuccess){
            return "성공";
        }
        return "실패";
    }
}
