package bridge.view;

import bridge.domain.MoveResult;
import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<MoveResult> moveResult) {
        printUpMap(moveResult);
        printDownMap(moveResult);
    }

    public static void printUpMap(List<MoveResult> moveResult){
        StringJoiner upResult = new StringJoiner(" | ", "[ ", " ]");
        for(int i = 0; i<moveResult.size(); i++){
            moveResult.get(i).pringMoveResult(moveResult.get(i));
            upResult.add(createUpMap(moveResult.get(i)));
        }

        String upMap = upResult.toString();
        System.out.println(upMap);
    }

    public static void printDownMap(List<MoveResult> moveResult){
        StringJoiner downResult = new StringJoiner(" | ", "[ ", " ]");
        for(int i = 0; i<moveResult.size(); i++){
            moveResult.get(i).pringMoveResult(moveResult.get(i));
            downResult.add(createDownMap(moveResult.get(i)));
        }

        String downMap = downResult.toString();
        System.out.println(downMap);
    }

    private static String createUpMap(MoveResult moveResult){
        if(moveResult.isUpMove(moveResult) && moveResult.isSuccessMove(moveResult)){
            return "O";
        }
        if(moveResult.isUpMove(moveResult) && !moveResult.isSuccessMove(moveResult)){
            return "X";
        }
        return " ";
    }

    private static String createDownMap(MoveResult moveResult){
        if(!moveResult.isUpMove(moveResult) && moveResult.isSuccessMove(moveResult)){
            return "O";
        }
        if(!moveResult.isUpMove(moveResult) && !moveResult.isSuccessMove(moveResult)){
            return "X";
        }
        return " ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
