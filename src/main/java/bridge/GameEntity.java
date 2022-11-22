package bridge;

import static bridge.BridgeStructure.FALSE;
import static bridge.BridgeStructure.TRUE;
import static bridge.Expression.DOWN;
import static bridge.Expression.UP;
import static bridge.GameStatus.SELECT_RE_TRY;
import static bridge.UserInterface.SELECT_ROW;

import java.util.List;

public class GameEntity extends BridgeGame implements GameRepository {

    private StringBuilder upRow;
    private StringBuilder downRow;

    public GameEntity() {
        this.upRow = new StringBuilder("[");
        this.downRow = new StringBuilder("[");

    }

    @Override
    public int manageGameStatus(String gameCommand) {
        gameCommand = new InputView().readGameCommand();
        countTry +=  retry(gameCommand);

        return countTry;
    }

    // 이동 기능
    @Override
    public String move() {
        String readMoving = new InputView().readMoving();
        List<String> bridgeEntity = new BridgeEntity().manageBridgeStatus();
        if ( readMoving.equals(bridgeEntity.get(0))) {
            upRow.append(TRUE.buildStructure());
            upRow.append("]");
        }

        if ( readMoving.equals(DOWN.expressThat())) {
            downRow.append(FALSE.buildStructure());
            downRow.append("]");
        }

        String resultTable = upRow + "\n" + downRow;

        return resultTable;
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
