package bridge.view;

import static bridge.view.SystemMessage.FINAL_GAME_RESULTS_MESSAGE;
import static bridge.view.SystemMessage.GAME_SUCCESS_MESSAGE;
import static bridge.view.SystemMessage.TOTAL_NUMBER_OF_ATTEMPTS;

import bridge.domain.BridgeGame;
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

    public static void printUpMap(List<MoveResult> moveResults){
        StringJoiner upResult = new StringJoiner(" | ", "[ ", " ]");
        for(int i = 0; i<moveResults.size(); i++){
            upResult.add(createUpMap(moveResults.get(i)));
        }

        String upMap = upResult.toString();
        System.out.println(upMap);
    }

    public static void printDownMap(List<MoveResult> moveResults){
        StringJoiner downResult = new StringJoiner(" | ", "[ ", " ]");
        for(int i = 0; i<moveResults.size(); i++){
            downResult.add(createDownMap(moveResults.get(i)));
        }

        String downMap = downResult.toString();
        System.out.println(downMap);
    }

    private static String createUpMap(MoveResult moveResult){
        if(moveResult.isUpMove() && moveResult.isSuccessMove()){
            return "O";
        }
        if(moveResult.isUpMove() && !moveResult.isSuccessMove()){
            return "X";
        }
        return " ";
    }

    private static String createDownMap(MoveResult moveResult){
        if(!moveResult.isUpMove() && moveResult.isSuccessMove()){
            return "O";
        }
        if(!moveResult.isUpMove() && !moveResult.isSuccessMove()){
            return "X";
        }
        return " ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame, List<MoveResult> moveResults) {
        System.out.println(FINAL_GAME_RESULTS_MESSAGE);
        printUpMap(moveResults);
        printDownMap(moveResults);
        System.out.println(GAME_SUCCESS_MESSAGE+ getPrintIsSuccess(bridgeGame));
        System.out.println(TOTAL_NUMBER_OF_ATTEMPTS+ bridgeGame.getCount());
    }
    public static String getPrintIsSuccess(BridgeGame bridgeGame) {
        if (bridgeGame.notExit()) {
            return "성공";
        }
        return "실패";
    }

    public static void printSentence(String s) {
        System.out.println(s);
    }

}
