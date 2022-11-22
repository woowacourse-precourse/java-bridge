package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static bridge.Application.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

//    public enum guide{
//        START_GUIDANCE("다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요."),
//        MOVE_GUIDANCE("\n이동할 칸을 선택해주세요"),
//        RESTART_GUIDANCE("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도:R, 종료:Q)");
//
//        private String message;
//
//        guide(String message){
//            this.message = message;
//        }
//
//        public void viewMessage(){
//            System.out.println(message);
//        }
//
//        public String getMessage() {
//            viewMessage();
//            return message;
//        }
//    }
    List<String> first_Line_Bridge = new ArrayList<>();
    List<String> second_Line_Bridge = new ArrayList<>();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void startGuidance(){
        System.out.println("다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요.");
    }

    public void moveGuidance(){
        System.out.println("\n이동할 칸을 선택해주세요");
    }

    public void restartGuidance(){
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도:R, 종료:Q)");
    }

    public void resultGuidance(){
        System.out.print("\n게임 성공 여부: "+ resultOfPass());
        System.out.println("\n총 시도한 횟수: "+ trial_Number);
    }

    public String resultOfPass(){
        if(bridge_Length == final_Map_Number+1) return "성공";
        return "실패";
    }

    public void printMap(List<String> result, int num) {
        first_Line_Bridge.add(result.get(result.size()-2));
        second_Line_Bridge.add(result.get(result.size()-1));
        Map(first_Line_Bridge, second_Line_Bridge, num);
    }

    public void Map(List<String> first_Line_Bridge, List<String> second_Line_Bridge, int num){
        mapping(first_Line_Bridge, num);
        mapping(second_Line_Bridge, num);
    }

    public void mapping(List<String> bridge, int num){
        for(int i=0; i<=num; i++){
            if(i==0) System.out.print("[ ");
            if(i!=0) System.out.print(" | ");
            System.out.print(bridge.get(i));
            if(i==num) System.out.println(" ]");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println("최종 게임 결과");
        Map(first_Line_Bridge, second_Line_Bridge, final_Map_Number);
    }
}
