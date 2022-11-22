package bridge;

import java.util.List;
import java.util.ArrayList;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> userMoving, boolean iscorrect) {
        List<String> printMap = new ArrayList<>();
        printMap.add(getMap(userMoving, iscorrect, "U"));
        printMap.add(getMap(userMoving, iscorrect, "D"));

        for(String map : printMap){
            System.out.println(map);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> result, boolean flag, int count) {
        System.out.println("최종 게임 결과");
        printMap(result, flag);

        System.out.println("게임 성공 여부: " + isSuccess(flag));
        System.out.println("총 시도한 횟수: " + count);
    }

    public String getMap(List<String> userMoving, boolean iscorrect, String command){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < userMoving.size() - 1; i++){
            sb.append(compareMove(userMoving.get(i), command));
        }
        sb.append(compareLastMove(userMoving.get(userMoving.size() - 1), command, iscorrect));

        return sb.toString();
    }

    public String isSuccess(boolean flag){
        if(flag){
            return "성공";
        }
        return "실패";
    }

    public String compareMove(String userMove, String correctMove){
        if(userMove.equals(correctMove)){
            return " O |";
        }
        return "   |";
    }

    public String compareLastMove(String userMove, String correctMove, boolean iscorrect){
        if(userMove.equals(correctMove)){
            if(iscorrect){
                return " O ]";
            }
            return " X ]";
        }
        return "   ]";
    }
}
