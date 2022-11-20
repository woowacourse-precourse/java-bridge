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
    private static final String GAME_END_MESSAGE = "최종 게임 결과";
    private static final String IS_SUCCESS_MESSAGE = "게임 성공 여부: %s\n";
    private static final String TRY_COUNT_MESSAGE = "총 시도한 횟수: %d";
    private static final String SUCCESS_MESSAGE = "성공";
    private static final String FAIL_MESSAGE = "실패";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String[]> boards) {
        String upMap=OPEN_BRIDGE_FORMAT;
        String downMap=OPEN_BRIDGE_FORMAT;

        for(String[] board: boards){
            String[] map = makeMap(board,upMap,downMap);
            upMap = map[0];
            downMap=map[1];
        }
        System.out.println(upMap.substring(0,upMap.length()-1)+CLOSE_BRIDGE_FORMAT);
        System.out.println(downMap.substring(0,downMap.length()-1)+CLOSE_BRIDGE_FORMAT);
    }

    private String[] makeMap(String[] board, String upMap,String downMap){
        if(board[0].equals(GameRule.UP_BOARD)){
            upMap+=" "+board[1]+" "+BRIDGE_DIVISION_FORMAT;
            downMap+=" "+" "+" "+BRIDGE_DIVISION_FORMAT;
        } else if (board[0].equals(GameRule.DOWN_BOARD)){
            downMap+=" "+board[1]+" "+BRIDGE_DIVISION_FORMAT;
            upMap+=" "+" "+" "+BRIDGE_DIVISION_FORMAT;
        }
        return new String[]{upMap,downMap};
    }



    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeRecord bridgeRecord, boolean isSuccess) {
        System.out.println(GAME_END_MESSAGE);
        printMap(bridgeRecord.getBoards());
        System.out.printf(IS_SUCCESS_MESSAGE, convertToMessage(isSuccess));
        System.out.printf(TRY_COUNT_MESSAGE,bridgeRecord.getTryCount());
    }

    private String convertToMessage(boolean isSuccess){
        if(isSuccess){
            return SUCCESS_MESSAGE;
        }
        return FAIL_MESSAGE;
    }

    public void printStart() {
        System.out.println(GAME_START_MESSAGE);
    }


}
