package bridge;

import bridge.domain.Command;
import bridge.MoveResponseDto;
import bridge.RetryResponseDto;
import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.domain.Result;

import java.util.Arrays;
import java.util.Optional;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final Player player;

    public BridgeGame(Bridge bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResponseDto move(String commandKey) {
        Command command = mapByStringToCommand(commandKey);
        int currentLevel = player.checkCurrentLevel();
        player.enterCommand(command);
        Result result = bridge.compare(command, currentLevel);
        return makeMoveResponseDto(command.toString(), result);
    }

    private MoveResponseDto makeMoveResponseDto(String command, Result result) {
        MoveResponseDto response = new MoveResponseDto(command, result, player.getAttemptCount());
        if (checkIfAllCorrect(result)) {
            response.setAllCorrect(Boolean.TRUE);
        }
        return response;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public RetryResponseDto retry(Command command) {
        if (command.equals(Command.RETRY)) {
            player.retry();
            return new RetryResponseDto(Boolean.TRUE, player.getAttemptCount());
        }
        return new RetryResponseDto(Boolean.FALSE, player.getAttemptCount());
    }

    //move
    //checkIfMaxCount - getter improve
    private boolean checkIfAllCorrect(Result result) {
        if (player.checkIfMaxCount(bridge)) {
            if (result.equals(Result.SUCCESS)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private Command mapByStringToCommand(String commandKey) {
        Optional<Command> optionalCommand = Arrays.stream(Command.values()).filter(
                command -> command.getKey().equals(commandKey)).findFirst();
        if (optionalCommand.isPresent()) {
            return optionalCommand.get();
        }
        throw new NullPointerException();
    }
}
