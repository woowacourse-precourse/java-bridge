package bridge.game;

import bridge.Application;
import bridge.BridgeRandomNumberGenerator;
import bridge.convertor.InputConvertor;
import bridge.message.GameMessage;
import bridge.view.OutputView;
import java.util.List;
import java.util.StringJoiner;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String U = "U";
    private static final String D = "D";
    private static final String R = "R";
    private static final String Q = "Q";
    private static final String O = "O";
    private static final String X = "X";
    private static final String SPACE = " ";
    private static final String MID_SYMBOL = " | ";
    private final OutputView outputView = new OutputView();
    private final List<String> bridge;
    private int currentLocation = 0;
    private int retryCount = 1;
    private boolean clear = false;
    private StringJoiner topMap;
    private StringJoiner bottomMap;

    // singleton test
    /*public static BridgeGame getInstance() {
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
    }*/


    public BridgeGame() {
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator())
                .makeBridge(
                        InputConvertor.inputParseNumber(
                                Application.sizeValidation()
                        )
                );
        clearMap();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        String move = Application.moveValidation();
        if (!goMove(move)) {
            callResultPrint();
            return false;
        }
        return true;
    }

    private boolean goMove(String move) {
        if (compare(move)) {
            bridgeUpdate(move, O);
            callBridgeMapPrint();
        }

        if (!compare(move)) {
            bridgeUpdate(move, X);
            callBridgeMapPrint();
            String s = Application.retryValidation();
            if (s.equals(R)) {
                retry();
                return true;
            }

            if (s.equals(Q)) {
                System.out.println(GameMessage.GAME_FINISH_MSG);
                callBridgeMapPrint();
                return false;
            }
        }
        plusCurrentLocation();
        clearBridge();
        if (clear) {
            System.out.println(GameMessage.GAME_FINISH_MSG);
            callBridgeMapPrint();
            return false;
        }
        return true;
    }

    private void bridgeUpdate(String move, String OXBox) {
        if (move.equals(U)) {
            topMap.add(OXBox);
            bottomMap.add(SPACE);
        }
        if (move.equals(D)) {
            topMap.add(SPACE);
            bottomMap.add(OXBox);
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
        clearMap();
    }

    private void clearMap() {
        topMap = new StringJoiner(MID_SYMBOL);
        bottomMap = new StringJoiner(MID_SYMBOL);
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

    private void callBridgeMapPrint() {
        outputView.printMap(topMap.toString(), bottomMap.toString());
    }

    private void callResultPrint() {
        outputView.printResult(clear, retryCount);
    }
}
