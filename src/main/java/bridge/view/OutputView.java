package bridge.view;


import bridge.domain.StageResult;
import bridge.validator.Unit;

import java.util.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private Map<Unit, Deque<String>> userInputMap = Map.of(
            Unit.UP, new LinkedList<>(),
            Unit.DOWN, new LinkedList<>());

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {

    }

    public void makeMap(String userInput, StageResult stageResult) {
        String result = decideOX(stageResult);
        Unit key = decideUpDown(userInput);

        saveUserInput(key, result);
        saveOppositeSide(key);
    }

    public String decideOX(StageResult stageResult) {
        if(stageResult == StageResult.PASS || stageResult == StageResult.SUCCESS) {
            return "O";
        }
        return "X";
    }

    public Unit decideUpDown(String userInput) {
        if(userInput.equals(Unit.UP.getCommand())) {
            return Unit.UP;
        }
        return Unit.DOWN;
    }


    public void saveUserInput(Unit key, String result) {
        save(key, result);
    }

    public void saveOppositeSide(Unit key) {
        Unit oppositeKey = findOppositeKey(key);

        save(oppositeKey, " ");
    }

    public void save(Unit key, String result) {
        checkBrackets(key);
        userInputMap.get(key).addLast(result);
        addCloseBrackets(key);

    }

    public Unit findOppositeKey(Unit key) {
        if(key == (Unit.UP)) {
            return Unit.DOWN;
        }

        return Unit.UP;
    }

    public void checkBrackets(Unit key) {
        checkStackIsEmpty(key);

        Deque<String> inputRecord = userInputMap.get(key);
        if(inputRecord.peekLast().equals("]")) {
            inputRecord.pollLast();
            inputRecord.addLast("|");
        }
    }

    public void addCloseBrackets(Unit key) {
        userInputMap.get(key).addLast("]");
    }

    public void checkStackIsEmpty(Unit key) {
        Deque<String> inputRecord = userInputMap.get(key);

        if(inputRecord.isEmpty()) {
            inputRecord.addLast("[");
        }
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printMessage(Messages message) {
        System.out.println(message.getMessage());
    }
}
