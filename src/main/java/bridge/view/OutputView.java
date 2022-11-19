package bridge.view;

import bridge.constant.GameStatus;
import bridge.model.Bridge;
import bridge.model.BridgeGame;

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
    public void printMap(Bridge bridge, int round, GameStatus status) {
        String map = drawMapToPreviousRound(bridge, round);
        map += drawMapForCurrentRound(bridge.getBlocks().get(round), status);
        String firstLineMap = map.replace("D", " ").replace("d", " ");
        firstLineMap = firstLineMap.replace("U", "O").replace("u", "X");
        String secondLineMap = map.replace("U", " ").replace("u", " ");
        secondLineMap = secondLineMap.replace("D", "O").replace("d", "X");
        System.out.println(firstLineMap);
        System.out.println(secondLineMap);
        System.out.println();
    }

    private String drawMapToPreviousRound(Bridge bridge, int round){
        List<String> blocks = bridge.getBlocks();
        String line = "[";
        for(int i = 0 ; i < round; i++){
            if(i != 0){
                line += "|";
            }
            line += " " + blocks.get(i) + " ";
        }
        return line;
    }

    private String drawMapForCurrentRound(String block, GameStatus status){
        String line = "|";
        if(status == GameStatus.FAIL) {
            line += " " + reverse(block).toLowerCase() + " ]";
            return line;
        }
        line += " " + block + " ]";
        return line;
    }

    private String reverse(String input){
        if(input.equals("U")){
            return "D";
        }
        return "U";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getBridge(), bridgeGame.getRound(), bridgeGame.getGameStatus());
        System.out.println("게임 성공 여부: " + bridgeGame.getGameStatus());
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
    }

    public void printGameStart(){
        System.out.println("다리 건너기 게임을 시작합니다");
        System.out.println();
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printChooseMoving(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printChooseBridgeSize(){
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printChooseGameCommand(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

}
