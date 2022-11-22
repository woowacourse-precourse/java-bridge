package bridge;

import static bridge.BridgeStructure.FALSE;
import static bridge.BridgeStructure.TRUE;
import static bridge.Expression.DOWN;
import static bridge.Expression.UP;
import static bridge.GameStatus.SELECT_RE_TRY;
import static bridge.UserInterface.RESULT;
import static bridge.UserInterface.SELECT_ROW;
import static bridge.UserInterface.SUCCESSFUL;
import static bridge.UserInterface.TRY_COUNT;

import java.util.List;

public class GameEntity extends BridgeGame implements GameRepository {

    private StringBuilder upRow;
    private StringBuilder downRow;

    public GameEntity() {
        this.upRow = new StringBuilder("[");
        this.downRow = new StringBuilder("[");

    }

    @Override
    public List<String> manageGameStatus(String gameCommand) {
        String result = RESULT.interact();
        String table = move();
        String successful= SUCCESSFUL.interact();
        String tryResult = TRY_COUNT.interact() + String.format(" %d", countTry) ;

        List<String> gameStatus = List.of(result, table, successful, tryResult);

        return gameStatus;
    }

    // 이동 기능
    // bridge.size() = 5+(n-1)*4, 5 9 13..
    @Override
    public String move() {
        String readMoving = new InputView().readMoving();
        List<String> bridgeEntity = new BridgeEntity().manageBridgeStatus();
        for (String index : bridgeEntity) {
            appendRow(readMoving, bridgeEntity, index);
        }
        String resultTable = upRow + "\n" + downRow;

        return resultTable;
    }

    private void appendRow(String readMoving, List<String> bridgeEntity, String index) {
        if ( readMoving.equals(index) && index.equals(UP.expressThat())) {
            for (int i = 0; i < bridgeEntity.size()-1; i++){
                upRow.append(TRUE.buildStructure());
                upRow.append("]");
            }

        }

        if ( readMoving.equals(index) && index.equals(DOWN.expressThat())) {
            for (int i = 0; i < bridgeEntity.size()-1; i++){
                downRow.append(TRUE.buildStructure());
                downRow.append("]");
            }
        }
    }

    @Override
    public int retry(String gameCommand) {
        if (gameCommand.equals(SELECT_RE_TRY.tellCommand())) {
            System.out.println(SELECT_ROW.interact());
            countTry ++;
            move();
        }

        return countTry;
    }




}
