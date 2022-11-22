package bridge.model;

import java.util.List;
import java.util.Map;

public class Record {
    private final List<String> board;
    private final Map<String, Integer> resultBoard;

    public Record(List<String> board, Map<String, Integer> resultBoard) {
        this.board = board;
        this.resultBoard = resultBoard;
    }

    public int getBoardSize() {
        return board.size();
    }

    public void addInBoard(String direction) {
        board.add(direction);
    }

    public void putInResultBoard(String key, Integer content) {
        resultBoard.put(key, content);
    }

    public boolean equalsToBoard(int index, String comparison) {
        return board.get(index)
                .equals(comparison);
    }

    public boolean equalsToResultBoard(String key, Integer content) {
        return resultBoard.get(key)
                .equals(content);
    }

    public void clearRecord() {
        board.clear();
        resultBoard.clear();
    }

    public Integer getValueByKey(String key) {
        return resultBoard.get(key);
    }
}
