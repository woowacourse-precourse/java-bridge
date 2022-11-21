package bridge.view;

import bridge.Map;
import bridge.Move;

import java.util.List;

import static bridge.Utility.MOVE_NAME;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String gameStartMessage = "다리 건너기 게임을 시작합니다.";
    public static final String inputBridgeLengthMessage = "다리의 길이를 입력해주세요.";
    public static final String selectUpDownMessage = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String reGameOrNotMessage = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String finalResultMessage = "최종 게임 결과";
    public static final String gameResultMessage = "게임 성공 여부: ";
    public static final String successMessage = "성공";
    public static final String failMessage = "실패";
    public static final String totalTriesMessage = "총 시도한 횟수: ";


    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> totalMove, List <String> bridge) {
        for(int i=Move.UP.getNum(); i>=Move.DOWN.getNum(); i--){
            String _curMove = MOVE_NAME.get(i);
            String curMove = Move.valueOf(_curMove).getMoveType();
            String mapResult = createMapByLine(totalMove, bridge, curMove);
            printMessage(mapResult);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List <String> totalMove, List<String> bridge, String gameResult, int cntTries) {
        OutputView outputView = new OutputView();

        outputView.printMessage(finalResultMessage);
        printMap(totalMove, bridge);
        String resultMessage = gameResultMessage+gameResult;
        String triesMessage = totalTriesMessage+cntTries;
        outputView.printMessage(resultMessage);
        outputView.printMessage(triesMessage);
    }

    public String createMapByLine(List<String> totalMove, List <String> bridge, String type){
        String mapResult = "";
        mapResult = mapResult+ Map.MAP_START.getStringToAdd();
        for(int i=0; i<totalMove.size(); i++){
            String selectedCurMove = totalMove.get(i);
            String bridgeCurMove = bridge.get(i);
            mapResult = mapResult + getMapContent(selectedCurMove, bridgeCurMove, totalMove.size(), i, type);
        }
        mapResult = mapResult+Map.MAP_END.getStringToAdd();
        return mapResult;
    }
    public String getMapContent(String selectedCurMove, String bridgeCurMove, int totalMoveSize, int curInd, String type) {
        String content = "";
        if(!selectedCurMove.equals(type))
            content = content+Map.MAP_BLANK.getStringToAdd();
        if(selectedCurMove.equals(type) && selectedCurMove.equals(bridgeCurMove))
            content = content+Map.MAP_RIGHT.getStringToAdd();
        if(selectedCurMove.equals(type) && !selectedCurMove.equals(bridgeCurMove))
            content = content+Map.MAP_WRONG.getStringToAdd();
        if(curInd!=(totalMoveSize-1))
            content = content+Map.MAP_SEPARATOR.getStringToAdd();
        return content;
    }

}
