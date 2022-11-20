package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartGame(){
        System.out.println("다리 건너기 게임을 시작합니다");
    }

    public void printInputBridgeSize(){
        System.out.println("다리의 길이를 입력해주세요.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> move){
        for(String str : move){
            System.out.print(str);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> move, String success, int tryNum) {
        System.out.println("최종 게임 결과");
        printMap(move);
        System.out.println("게임 성공 여부: " + success);
        System.out.println("총 시도한 횟수: " + tryNum);
    }

    // U,D로 이루어진 배열을 매개변수로 받아 최종적으로 출력할 List를 반환한다.
    public List<String> makeMove(List<String> move, boolean success){
        List<String> result = new ArrayList<>();
        List<String> upperMove = makeUpperMove(move, success);
        List<String> underMove = makeUnderMove(move, success);
        upperMove = addBracket(addBar(upperMove));
        underMove = addBracket(addBar(underMove));
        result = mergeUpperUnderMove(upperMove, underMove);
        return result;
    }

    public List<String> makeUpperMove(List<String> move, boolean success){
        List<String> upperMove = new ArrayList<>();
        for(String str : move){
            upperMove.add(UToO(str));
        }
        if(!success){
            upperMove.set(move.size()-1, "X");
        }
        return upperMove;
    }

    public List<String> makeUnderMove(List<String> move, boolean success){
        List<String> underMove = new ArrayList<>();
        for(String str : move){
            underMove.add(DToO(str));
        }
        if(!success){
            underMove.set(move.size()-1, "X");
        }
        return underMove;
    }

    public String UToO(String move){
        if(move == "U"){
            return "O";
        }
        return " ";
    }

    public String DToO(String move){
        if(move == "D"){
            return "O";
        }
        return " ";
    }

    public List<String> mergeUpperUnderMove(List<String> upperMove, List<String> underMove){
        List<String> result = new ArrayList<>();
        for(String str : upperMove){
            result.add(str + " ");
        }
        result.add("\n");
        for(String str : underMove){
            result.add(str + " ");
        }
        return result;
    }

    // |를 추가하는 함수
    public List<String> addBar(List<String> move){
        List<String> result = new ArrayList<>();
        for(int i = 0; i < move.size() - 1; i++){
            result.add(move.get(i));
            result.add("|");
        }
        result.add(move.get(move.size()-1));
        return result;
    }

    // 대괄호를 추가하는 함수
    public List<String> addBracket(List<String> move){
        List<String> result = new ArrayList<>();
        result.add("[");
        for(String str : move){
            result.add(str);
        }
        result.add("]");
        return result;
    }
}
