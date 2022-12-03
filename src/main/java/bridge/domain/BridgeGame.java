package bridge.domain;

import bridge.model.Answer;
import bridge.model.Direction;
import bridge.model.ErrorMessage;
import bridge.model.Restart;
import java.util.LinkedList;
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
        isValidDirection(input);
        String nextAnswer = answer.get(step).getInput();
        if(input.equals(nextAnswer)){
            step++;
            return checkClearCondition();
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

    public List<List<Answer>> getCurrentBridge(Answer answer){
        List<List<Answer>> result = new LinkedList<>();
        if(answer == Answer.CORRECT || answer == Answer.END){
            addCorrectBridge(result);
            return result;
        }
        addFailedBridge(result);
        return result;
    }

    private void addCorrectBridge(List<List<Answer>> result){
        result.add(getCorrectBridge(Direction.UP));
        result.add(getCorrectBridge(Direction.DOWN));
    }

    private void addFailedBridge(List<List<Answer>> result){
        result.add(getFailedBridge(Direction.UP));
        result.add(getFailedBridge(Direction.DOWN));
    }

    private List<Answer> getCorrectBridge(Direction direction){
        return answer.stream().map( dir -> {
                            if(dir == direction){
                                return Answer.CORRECT;
                            }
                            return Answer.NONE;
                        })
                .limit(step)
                .collect(Collectors.toList());
    }

    private List<Answer> getFailedBridge(Direction direction){
        List<Answer> result = getCorrectBridge(direction);
        if(direction == answer.get(step)){
            result.add(Answer.NONE);
            return result;
        }
        result.add(Answer.INCORRECT);
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

    private Answer checkClearCondition(){
        if(step == answer.size()){
            return Answer.END;
        }
        return Answer.CORRECT;
    }
}
