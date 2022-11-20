package bridge;

import enumCollections.GameResult;
import enumCollections.Position;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<String> ups = new ArrayList<>();
    private List<String> downs = new ArrayList<>();

    public void addUpper(String result) {
        ups.add(result);
        downs.add(GameResult.getUi(GameResult.EMPTY));
    }

    public void addBelow(String result) {
        downs.add(result);
        downs.add(GameResult.getUi(GameResult.EMPTY));
    }

    public List<List<String>> getMaps() {
        List<List<String>> result = new ArrayList<>();
        result.add(ups);
        result.add(downs);
        return result;
    }
}
