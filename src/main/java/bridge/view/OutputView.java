package bridge.view;

import bridge.domain.BridgeBlock;
import bridge.domain.MovingResult;
import bridge.util.BridgeMessageMaker;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class OutputView {

    public static final String BLANK = " ";

    private final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final String INIT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String SELECT_BLOCK_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    private final BridgeMessageMaker bridgeMessageMaker;

    public OutputView(BridgeMessageMaker bridgeMessageMaker) {
        this.bridgeMessageMaker = bridgeMessageMaker;
    }

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
        System.out.println(INIT_BRIDGE_SIZE_MESSAGE);
    }

    public void printSelectBlock() {
        System.out.println(SELECT_BLOCK_MESSAGE);
    }

    public void printMap(List<MovingResult> movingResults) {
        Iterator<MovingResult> resultIter = movingResults.iterator();
        while (resultIter.hasNext()){
            makeMessage(resultIter);
        }
        System.out.println("[ " + bridgeMessageMaker.getUpperLine() + " ]");
        System.out.println("[ " + bridgeMessageMaker.getLowerLine() + " ]");
    }

    //TODO : 좀 더 깔끔하게 처리 불가능한가?
    private void makeMessage(Iterator<MovingResult> resultIter) {
        String state = resultIter.next().getState();
        if (resultIter.next().getBridgeBlock().equals(BridgeBlock.U)) {
            bridgeMessageMaker.upLineMessageMaker(state, resultIter.hasNext());
            bridgeMessageMaker.downLineMessageMaker(BLANK, resultIter.hasNext());
        }
        if (resultIter.next().getBridgeBlock().equals(BridgeBlock.D)) {
            bridgeMessageMaker.downLineMessageMaker(state, resultIter.hasNext());
            bridgeMessageMaker.upLineMessageMaker(BLANK, resultIter.hasNext());
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
