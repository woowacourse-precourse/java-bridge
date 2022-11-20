package bridge.view;

import bridge.constant.GameStatus;
import bridge.constant.OutputMessage;
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
        String firstLineMap = map.replace("D", " ").replace("d", " ").replace("[|", "[");
        firstLineMap = firstLineMap.replace("U", "O").replace("u", "X");
        String secondLineMap = map.replace("U", " ").replace("u", " ").replace("[|", "[");
        secondLineMap = secondLineMap.replace("D", "O").replace("d", "X");
        System.out.println(firstLineMap);
        System.out.println(secondLineMap);
    }

    private String drawMapToPreviousRound(Bridge bridge, int round){
        List<String> blocks = bridge.getBlocks();
        String line = "[";
        for(int i = 0 ; i < round; i++){
            line += "| " + blocks.get(i) + " ";
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
        System.out.println();
        System.out.println(OutputMessage.FINAL_GAME_RESULT_MESSAGE);
        printMap(bridgeGame.getBridge(), bridgeGame.getRound(), bridgeGame.getGameStatus());
        System.out.println();
        System.out.println(OutputMessage.GAME_SUCCESS_OR_NOT_MESSAGE + bridgeGame.getGameStatus().korean());
        System.out.println(OutputMessage.TOTAL_TRY_COUNT_MESSAGE + bridgeGame.getTryCount());
    }

    public void printGameStart(){
        System.out.println(OutputMessage.GAME_START_MESSAGE);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printChooseMoving(){
        System.out.println();
        System.out.println(OutputMessage.MOVING_SELECT_MESSAGE);
    }

    public void printChooseBridgeSize(){
        System.out.println();
        System.out.println(OutputMessage.BRIDGE_SIZE_SELECT_MESSAGE);
    }

    public void printChooseGameCommand(){
        System.out.println();
        System.out.println(OutputMessage.GAME_COMMAND_SELECT_MESSAGE);
    }

}
