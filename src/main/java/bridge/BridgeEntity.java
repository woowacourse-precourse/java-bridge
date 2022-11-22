package bridge.persistence;


import static bridge.ui.BridgeStructure.FALSE;
import static bridge.ui.BridgeStructure.TRUE;
import static bridge.ui.BridgeStructure.UN_KNOWN;
import static bridge.ui.Expression.DOWN;
import static bridge.ui.Expression.UP;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeRepository;
import bridge.ui.Expression;
import java.util.LinkedList;
import java.util.List;

public class BridgeEntity implements BridgeRepository {

    private List<String> bridgeEntity;
    private BridgeMaker bridgeMaker;
    private StringBuilder upRow;
    private StringBuilder downRow;


    public BridgeEntity() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeEntity = new LinkedList<>();
        this.upRow = new StringBuilder("[");
        this.downRow = new StringBuilder("[");
    }

    @Override
    public List<String> manageStatus(int size) {

        bridgeEntity = bridgeMaker.makeBridge(size);

        return bridgeEntity;

    }

    public void move(Expression expression) {
        bridgeEntity.add(expression.expressThat());
    }

    public int size() {
        return bridgeEntity.size();
    }


    void setUpAndDown(Expression expression, boolean predicate) {
        if ( expression.equals(UP.expressThat())) {
            moveToUp(predicate);
        }
        if (expression.equals(DOWN.expressThat())) {
            moveToDown(predicate);
        }
    }

    private void moveToUp(boolean predicate) {
        downRow.append(UN_KNOWN.buildStructure());
        if (predicate == true) {
            upRow.append(TRUE.buildStructure());
        }
        upRow.append(UN_KNOWN.buildStructure());
    }

    private void moveToDown(boolean predicate) {
        upRow.append(UN_KNOWN.buildStructure());
        if (predicate == true) {
            downRow.append(TRUE.buildStructure());
        }
        downRow.append(FALSE.buildStructure());
    }


    public String mapToResult() {
        StringBuilder firstRow = new StringBuilder(upRow);
        StringBuilder secondRow = new StringBuilder(downRow);

        firstRow.setCharAt(firstRow.length()-1, ']');
        secondRow.setCharAt(firstRow.length()-1, ']');

        String mapFirstRow = firstRow.toString();
        String mapSecondRow = secondRow.toString();

        return mapFirstRow + "\n" + mapSecondRow;
    }
}
