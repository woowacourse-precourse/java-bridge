package bridge;


import static bridge.BridgeStructure.SEPARATOR;
import static bridge.BridgeStructure.TRUE;
import static bridge.Expression.DOWN;
import static bridge.Expression.UP;
import static bridge.GameStatus.QUIT;
import static bridge.GameStatus.SELECT_RE_TRY;
import static bridge.UserInterface.FAIL;
import static bridge.UserInterface.RESULT;
import static bridge.UserInterface.SELECT_ROW;
import static bridge.UserInterface.SUCCESS;
import static bridge.UserInterface.SUCCESSFUL;
import static bridge.UserInterface.TRY_COUNT;

import java.util.List;

public class GameEntity extends BridgeGame implements GameRepository {

    String readMoving;
    List<String> bridgeEntity;
    private StringBuilder upRow;
    private StringBuilder downRow;


    public GameEntity() {

        this.upRow = new StringBuilder("[");
        this.downRow = new StringBuilder("[");
        this.bridgeEntity = new BridgeEntity().manageBridgeStatus();
        this.readMoving = new FrontController().readMoving();

    }



    @Override
    public List<String> manageGameStatus() {
        String result = RESULT.interact();
        String table = move() + "\n";
        String successful = SUCCESSFUL.interact() + predicateWin() + "\n";
        String tryResult = TRY_COUNT.interact() + String.format(" %d", countTry);

        List<String> gameStatus = List.of(result, table, successful, tryResult);

        return gameStatus;
    }

    public void play() {
        while ( predicateWin() != SUCCESS.interact()) {

            move();
        }
    }
    private String predicateWin() {
        String predicate = "";
        if ( (bridgeEntity.get(bridgeEntity.size())).equals(readMoving)) {
            predicate = SUCCESS.interact();
        }
        if ( (bridgeEntity.get(bridgeEntity.size())) != (readMoving)) {
            predicate = FAIL.interact();
        }

        return predicate;
    }

    // 이동 기능
    @Override
    public String move() {

        String table = "";
        for (String entity : bridgeEntity) {
            table +=  predicateRow(entity) + "\n";
            predicateRetry(entity);
        }

        return table;
    }

    private void predicateRetry(String entity) {
        if (readMoving != entity) { retry(new FrontController().readGameCommand()); }
    }

    private String predicateRow(String entity) {
        if (readMoving.equals(entity) && readMoving.equals(UP.expressThat())){
            addRow(upRow, downRow);
        }
        if (readMoving.equals(entity) && readMoving.equals(DOWN.expressThat())){
            addRow(downRow, upRow);
        }

        return mapToResult(upRow, downRow);
    }

    private void addRow(StringBuilder trueRow, StringBuilder falseRow) {

        falseRow.append(SEPARATOR.buildStructure());
        trueRow.append(TRUE.buildStructure());

    }

    private String mapToResult(StringBuilder upRow, StringBuilder downRow) {
        StringBuilder upRowResult = new StringBuilder(upRow);
        upRowResult.setCharAt(upRowResult.length()-1, ']');
        StringBuilder downRowResult = new StringBuilder(downRow);
        downRowResult.setCharAt(downRowResult.length()-1, ']');

        return upRowResult + "\n" + downRowResult;
    }

    @Override
    public int retry(String gameCommand) {

        if (gameCommand.equals(QUIT.tellCommand())) {
            return countTry;
        }
        if (gameCommand.equals(SELECT_RE_TRY.tellCommand())) {
            System.out.println(SELECT_ROW.interact());
            countTry++;
            move();
        }

        return countTry;
    }

}
