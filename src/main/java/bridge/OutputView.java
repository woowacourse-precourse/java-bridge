package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void startGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public static void getBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static void getMove() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void getRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
    /**
    // 메서드 이름 변경 불가!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    // 메서드 줄이기
    public static void printMap(List<String> bridge, List<String> choice) {
        String upLetter = "[ ";
        String downLetter = "[ ";
         for(int i =0; i<choice.size(); i++) {
            if(bridge.get(i).equals(choice.get(i)) && choice.get(i).equals("U")) {upLetter += "O"; downLetter += " ";}
            if(bridge.get(i).equals(choice.get(i)) && choice.get(i).equals("D")) {downLetter += "O"; upLetter += " ";}
            if(!bridge.get(i).equals(choice.get(i)) && choice.get(i).equals("U")) {upLetter += "X"; downLetter += " ";}
            if(!bridge.get(i).equals(choice.get(i)) && choice.get(i).equals("D")) {downLetter += "X"; upLetter += " ";}
            if(i==choice.size()-1) {upLetter+=" ]"; downLetter+=" ]"; break;}
            upLetter+=" | "; downLetter+=" | ";
        }
        System.out.println(upLetter);
        System.out.println(downLetter);
    }
    /**
    // 메서드 이름 변경 불가!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(int count, boolean isBridgeSuccess) {
        String result = "";
        if(isBridgeSuccess) {result="성공";}
        if(!isBridgeSuccess) {result="실패";}
        System.out.println("게임 성공 여부 : " + result);
        System.out.println("총 시도한 횟수 : " + count);
    }

}
