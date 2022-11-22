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
        this.readMoving = new FrontController().readMoving();
        this.bridgeEntity = new BridgeEntity().manageBridgeStatus();
        this.upRow = new StringBuilder("[");
        this.downRow = new StringBuilder("[");
    }

    @Override
    public List<String> manageGameStatus() {
        String result = RESULT.interact();
        String table = move();
        String successful = SUCCESSFUL.interact() + predicateWin();
        String tryResult = TRY_COUNT.interact() + String.format(" %d", countTry);

        List<String> gameStatus = List.of(result, table, successful, tryResult);

        return gameStatus;
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
            table = predicateRow(entity);
        }

        return table;
    }

    private String predicateRow(String entity) {
        if (readMoving.equals(entity) && readMoving.equals(UP.expressThat())) {
            upRow.append(TRUE.buildStructure());
            upRow.append(SEPARATOR.buildStructure());
            upRow.setCharAt(upRow.length()-1, ']');

        }
        if (readMoving.equals(entity) && readMoving.equals(DOWN.expressThat())) {
            downRow.append(TRUE.buildStructure());
            downRow.append(SEPARATOR.buildStructure());
            downRow.setCharAt(downRow.length()-1, ']');
        }
        return upRow + "\n" + downRow;
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
