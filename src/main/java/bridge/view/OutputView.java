package bridge.view;

import bridge.BridgeGame;
import bridge.BridgeRestart;
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
    private final String FINAL_MSG = "\n최종 게임 결과";
    private final String SUCCESS_FAIL_MSG  = "\n게임 성공 여부: ";
    private final String TRY_COUNT_MSG = "총 시도한 횟수: ";

    private BridgeGame bridgeGame = new BridgeGame();
    private BridgeRestart bridgerestart = new BridgeRestart();
    public static int tryCount = 1;
    public static String successFail = "성공";

    public int printMap(List<String> correctBridge) {
        bridgeGame.clearBridge(); bridgeGame.needRestart = 0; int stopPlaying = 0;
        for(int i=0; i<correctBridge.size(); i++) {
            bridgeGame.move(correctBridge.get(i), InputView.readMoving());
            printUpDown();
            if(bridgeGame.getNeedRestart() == 1 ) { stopPlaying = bridgerestart.bridgeRestartCheck(InputView.readGameCommand());
                break;
            } if(bridgeGame.getUpBridge().size() == correctBridge.size()) { stopPlaying = 2;}
        } return stopPlaying ;
    }

    public void printUpDown() {
        String strUp =  String.join("|", bridgeGame.getUpBridge());
        String strDown =  String.join("|", bridgeGame.getDownBridge());
        System.out.println("["+strUp+"]");
        System.out.println("["+strDown+"]");
    }

    public void printUpDown(List<String> upBridge, List<String> downBridge) {
        String strUp =  String.join("|", upBridge);
        String strDown =  String.join("|", downBridge);
        System.out.println("["+strUp+"]");
        System.out.println("["+strDown+"]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(FINAL_MSG);
        printUpDown();
        System.out.println(SUCCESS_FAIL_MSG + successFail);
        System.out.println(TRY_COUNT_MSG + tryCount);
    }
}
