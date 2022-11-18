package bridge.game;

import bridge.Application;
import bridge.BridgeRandomNumberGenerator;
import bridge.convertor.InputConvertor;
import bridge.message.GameMessage;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static BridgeGame game = null;
    private static List<String> bridge;
    private int currentLocation = 0;
    private int retryCount = 1;
    private boolean clear = false;

    private final OutputView outputView = new OutputView();
    private StringJoiner topMap = new StringJoiner(" | ");
    private StringJoiner bottomMap = new StringJoiner(" | ");

    public static BridgeGame getInstance() { // singleton
        if (game == null) {
            game = new BridgeGame();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            bridge = bridgeMaker.makeBridge(
                    InputConvertor.inputParseNumber(
                            Application.sizeValidation()
                    )
            );
        }
        return game;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
//        String move = "U";
        String move = Application.moveValidation();
        if (!goMove(move)) {
            outputView.printResult(clear, retryCount);
            return false;
        }
        return true;
    }

    private boolean goMove(String move) {
        if (compare(move)) {
            bridgeUpdate(move, "O");
            outputView.printMap(topMap.toString(), bottomMap.toString());
        }

        if (!compare(move)) {
            bridgeUpdate(move, "X");
            outputView.printMap(topMap.toString(), bottomMap.toString());
            String s = Application.retryValidation();
            if (s.equals("R")) {
                retry();
                return true;
            }

            if (s.equals("Q")) {
                System.out.println(GameMessage.GAME_FINISH_MSG);
                outputView.printMap(topMap.toString(),bottomMap.toString());
                return false;
            }
        }
        plusCurrentLocation();
        clearBridge();
        if (clear) {
            System.out.println(GameMessage.GAME_FINISH_MSG);
            outputView.printMap(topMap.toString(),bottomMap.toString());
            return false;
        }
        return true;
    }

    private void bridgeUpdate(String move, String O) {
        if (move.equals("U")) {
            topMap.add(O);
            bottomMap.add(" ");
        }

        if (move.equals("D")) {
            topMap.add(" ");
            bottomMap.add(O);
        }
    }

    public boolean compare(String move) {
        return bridge.get(currentLocation).equals(move);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        clearCurrentLocation();
        plusRetryCount();
        topMap = new StringJoiner(" | ");
        bottomMap = new StringJoiner(" | ");
    }

    private void clearBridge() {
        if (bridge.size() == currentLocation) {
            clear = true;
        }
    }

    private void plusCurrentLocation() {
        currentLocation++;
    }

    private void clearCurrentLocation() {
        currentLocation = 0;
    }

    private void plusRetryCount() {
        retryCount++;
    }
}
