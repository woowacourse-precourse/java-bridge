package bridge;

import javax.naming.BinaryRefAddr;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public InputView inputView = new InputView();
    public OutputView outputView = new OutputView();
    public List<String> bridge;
    public int tryCount = 0;


    public BridgeGame() {
        outputView.gameStart();
        int bridgeLength = inputView.readValidBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(bridgeLength);
    }


    public boolean checkAnswer(List<String> moves) {
        if (moves.size() < bridge.size()) {return false;}
        for (int i = 0; i < bridge.size(); i++) {
            if (!moves.get(i).equals(bridge.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> retry() {
        List<String> moves = List.of();
        boolean flag = false;

        while (!flag) {
            String gameCommand = inputView.readValidGameCommand();
            if (gameCommand.equals("Q")) {break;}
            moves = move();
            flag = checkAnswer(moves);
        }
        return moves;
    }



    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move() {
        tryCount++;
        ArrayList<String> moves = new ArrayList<>();
        for (String bridgeBlock : bridge) {
            String move = inputView.readValidMoving();
            if (stepForward(moves, bridgeBlock, move)) break;
        }
        return moves;
        }

    public boolean stepForward(ArrayList<String> moves, String bridgeBlock, String move) {


        if (move.equals(bridgeBlock)) moves.add(move);
        if (!move.equals(bridgeBlock)) {
            moves.add(move);
            outputView.printMap(bridge, moves);
            return true;
        }
        outputView.printMap(bridge, moves);
        return false;
    }

    /**
     * move
     * check answer
     * print
     * if right -> go back to move
     * else -> ask retry
     * if retry -> go back to move
     */

    public int measureBridgeLength() {
        return bridge.size();
    }

    public List<String> getBridge() {
        return bridge;
    }
    }



