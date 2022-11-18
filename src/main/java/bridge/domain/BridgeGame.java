package bridge.domain;

import bridge.model.Answer;
import bridge.model.Direction;
import bridge.model.ErrorMessage;
import bridge.model.Restart;
import java.util.List;
import java.util.stream.Collectors;

public class BridgeGame {
    private final List<Direction> answer;
    private int step;

    public BridgeGame(List<String> bridge){
        this.answer = bridge.stream()
                .map(Direction::getDirectionByInput)
                .collect(Collectors.toUnmodifiableList());
        step = 0;
    }

    public Answer move(String input) {
        System.out.println(answer);
        isValidDirection(input);
        String nextAnswer = answer.get(step).getInput();
        if(input.equals(nextAnswer)){
            step++;
            return Answer.CORRECT;
        }
        return Answer.INCORRECT;
    }

    public Restart retry(String input) {
        isValidRetry(input);
        Restart result = Restart.getRestartByString(input);
        if(result == Restart.TRUE){
            step = 0;
        }
        return result;
    }





    private void isValidDirection(String input){
        if(input.equals(Direction.DOWN.getInput())
                || input.equals(Direction.UP.getInput())){
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_DIRECTION_VALUE.getOutput());
    }

    private void isValidRetry(String input){
        if(input.equals(Restart.TRUE.getInput())
        || input.equals(Restart.FALSE.getInput())){
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_RESTART_VALUE.getOutput());
    }

    public List<Direction> getAnswer() {
        return answer;
    }

    public int getStep() {
        return step;
    }
}
