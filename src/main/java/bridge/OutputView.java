package bridge;

import java.util.ArrayList;
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
    public void printMap(int num, List<String> bridge, int isAnswer) {
        if(num == 1){
            printOneValue(bridge, isAnswer);
            return;
        }
        printManyValue(num, bridge, isAnswer);
        return;

    }
    public void printLine(List<String> upString, List<String> downString) {
        upString.add("| ");
        downString.add("| ");
    }

    public void printUp(List<String> upString, List<String> downString) {
        upString.add("O ");
        downString.add("  ");
    }

    public void printDown(List<String> upString, List<String> downString) {
        upString.add("  ");
        downString.add("O ");
    }

    public void printUpFailed(List<String> upString, List<String> downString) {
        upString.add("X ");
        downString.add("  ");
    }

    public void printDownFailed(List<String> upString, List<String> downString) {
        upString.add("  ");
        downString.add("X ");
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int num, List<String> bridge, int isAnswer) {
        System.out.println("최종 게임 결과");
        printMap(num, bridge, isAnswer);
        System.out.println("");
        if(isAnswer == 0){
            System.out.println("게임 성공 여부 : 실패");
        }
        if(isAnswer == 1){
            System.out.println("게임 성공 여부 : 성공");
        }

    }
    public void checkValue(char c, List<String> upSting, List<String> downString) {
        if(c == 'U') {
            printUp(upSting, downString);
        }
        if(c == 'D') {
            printDown(upSting, downString);
        }
    }

    public void checkFailedValue(char c, List<String> upString, List<String> downString) {
        if(c == 'U') {
            printDownFailed(upString, downString);
        }
        if(c == 'D') {
            printUpFailed(upString, downString);
        }
    }
    public void printOneValue(List<String> bridge, int isAnswer){
        List<String> upString = new ArrayList<>();
        List<String> downString = new ArrayList<>();

        if(isAnswer == 1){
            checkValue(bridge.get(0).charAt(0), upString, downString);
        }
        if(isAnswer == 0){
            checkFailedValue(bridge.get(0).charAt(0), upString, downString);
        }
        System.out.println("[ " + String.join(",",upString).replace(",", "") + "]");
        System.out.println("[ " + String.join(",",downString).replace(",","")+ "]");
    }
    public void printManyValue(int num, List<String> bridge, int isAnswer) {
        if(isAnswer == 0) {
            printIsFailedValue(bridge, num);
            return;
        }
        if(isAnswer == 1) {
            printIsSuccessValue(bridge, num);
            return;
        }
    }

    public void printIsSuccessValue(List<String> bridge, int num) {
        List<String> upString = new ArrayList<>();
        List<String> downString = new ArrayList<>();

        for(int i = 0; i < num; i++) {
            if(i > 0) printLine(upString, downString);
            checkValue(bridge.get(i).charAt(0), upString, downString);
        }

        System.out.println("[ " + String.join(",",upString).replace(",", "") + "]");
        System.out.println("[ " + String.join(",",downString).replace(",","")+ "]");
    }

    public void printIsFailedValue(List<String> bridge, int num) {
        List<String> upString = new ArrayList<>();
        List<String> downString = new ArrayList<>();


        for(int i = 0; i < num-1; i++) {
            if(i > 0) printLine(upString, downString);
            checkValue(bridge.get(i).charAt(0), upString, downString);
        }
        printLine(upString, downString);
        checkFailedValue(bridge.get(num-1).charAt(0), upString, downString);


        System.out.println("[ " + String.join(",",upString).replace(",", "") + "]");
        System.out.println("[ " + String.join(",",downString).replace(",","")+ "]");
    }

    public void printGameCnt(int gameCnt) {
        System.out.println("총 시도한 횟수: "+gameCnt);
    }
    public void printMoveQuestion() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printStartComment() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("");
        System.out.println("다리의 길이를 입력해주세요.");
    }
    public void printRestartComment(){
        System.out.println("게임을 다시 시도하지 여부를 입력해주세요. (재시도: R, 종료: Q");
    }


}
