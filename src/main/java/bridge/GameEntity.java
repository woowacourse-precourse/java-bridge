package bridge;

import static bridge.BridgeStructure.FALSE;
import static bridge.BridgeStructure.TRUE;
import static bridge.Expression.DOWN;
import static bridge.Expression.UP;

import java.util.List;

public class GameEntity extends BridgeGame implements GameRepository {
    private int tryCount;
    private UserInterface userInterface;
    private StringBuilder upRow;
    private StringBuilder downRow;

    public GameEntity() {
        this.upRow = new StringBuilder("[");
        this.downRow = new StringBuilder("[");

    }

    @Override
    public int manageGameStatus(String gameCommand) {
        gameCommand = new InputView().readGameCommand();
        tryCount +=  retry(gameCommand);

        return tryCount;
    }

    // 이동 기능
    @Override
    public String move() {
        String readMoving = new InputView().readMoving();
        List<String> bridgeEntity = new BridgeEntity().manageBridgeStatus();
        if ( readMoving.equals(UP.expressThat())) {
            upRow.append(TRUE.buildStructure());
        }

        if ( readMoving.equals(DOWN.expressThat())) {
            downRow.append(FALSE.buildStructure());
        }

        String resultTable = upRow + "\n" + downRow;

        return resultTable;
    }






}
