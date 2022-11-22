package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private List<String> convertToMap(String line, List<String> board, int step){
        List<String> map = new ArrayList<>();
        for(int i = 0; i < step; i++){
            if(board.get(i).equals(line)){
                map.add("O");
                continue;
            }
            map.add(" ");
        }
        return map;
    }

    private void addFailResult(String line, String last, List<String> map){
        if(last.equals(line)){
            map.add(" ");
            return;
        }
        map.add("X");
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> board, int step, boolean isSuccess) {
        if(!isSuccess) step -= 1;
        List<String> resultUp = convertToMap("U", board, step);
        List<String> resultDown = convertToMap("D", board, step);
        if(!isSuccess){
            addFailResult("U", board.get(step), resultUp);
            addFailResult("D", board.get(step), resultDown);
        }
        System.out.println("[ "+String.join(" | ", resultUp)+" ]");
        System.out.println("[ "+String.join(" | ", resultDown)+" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과\n");
        printMap(bridgeGame.board, bridgeGame.step, bridgeGame.result);

        String result = "실패";
        if(bridgeGame.result) result = "성공";
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + bridgeGame.retryNum);
    }
}
