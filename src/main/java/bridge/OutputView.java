package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void inputSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static void startGameMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    public static void movePrint(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void chooseEndPrint(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> up, List<String> down) {
        OutputView.printUpDown(up);
        OutputView.printUpDown(down);
    }

    public static void printUpDown(List<String> upOrDown){
        System.out.print("[");
        for(int i = 0; i < upOrDown.size() -1; i++){
            System.out.print(upOrDown.get(i) + "|");
        }
        System.out.print(upOrDown.get(upOrDown.size()-1));
        System.out.println("]");
        System.out.print("[");
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<String> up, List<String> down, boolean success, int tryCount) {
        System.out.println("최종 게임 결과");
        printMap(up, down);
        System.out.println();
        if(success) System.out.println("게임 성공 여부: 성공");
        if(!success) System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + tryCount);
    }
}
