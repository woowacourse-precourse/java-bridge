package bridge.view;

import java.util.List;

import bridge.GameRule;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeRecord;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String OPEN_BRIDGE_FORMAT = "[";
    private static final String CLOSE_BRIDGE_FORMAT = "]";
    private static final String BRIDGE_DIVISION_FORMAT = "|";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeRecord record) {
		List<String[]> recordBoards = record.getBoards();
        String upMap=OPEN_BRIDGE_FORMAT;
        String downMap=OPEN_BRIDGE_FORMAT;

        for(String[] board: recordBoards){
            makeMap(board,upMap,downMap);
        }
        System.out.println(upMap.substring(0,upMap.length()-1)+CLOSE_BRIDGE_FORMAT);
        System.out.println(downMap.substring(0,downMap.length()-1)+CLOSE_BRIDGE_FORMAT);
    }

    private void makeMap(String[] board, String upMap,String downMap){
        if(board[0].equals(GameRule.UP_BOARD)){
            upMap+=" "+board[1]+" "+BRIDGE_DIVISION_FORMAT;
            downMap+=" "+" "+" "+BRIDGE_DIVISION_FORMAT;
        } else if (board[0].equals(GameRule.DOWN_BOARD)){
            downMap+=" "+board[1]+" "+BRIDGE_DIVISION_FORMAT;
            upMap+=" "+" "+" "+BRIDGE_DIVISION_FORMAT;
        }
    }



    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printStart() {
        System.out.println(GAME_START_MESSAGE);
    }


}
