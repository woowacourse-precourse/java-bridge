package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapMaker {
    private List<List<String>> Map;
    private final String Up = "U";
    private final String Down = "D";
    private HashMap<Boolean, String> OX;
    private final int UpIndex = 0;
    private final int DownIndex = 1;

    public MapMaker() {
        Map = new ArrayList<>();
        OX = new HashMap<>();

        Map.add(new ArrayList<>());
        Map.add(new ArrayList<>());
        OX.put(true, "O");
        OX.put(false, "X");
    }

    public List<List<String>> MakeMap(String Move, Boolean compare) {
        Map.get(UpIndex).add(MakeUp(Move, compare));
        Map.get(DownIndex).add(MakeDown(Move, compare));
        return Map;
    }

    private String MakeUp(String Move, Boolean compare) {
        if(CompareUp(Move)) return OX.get(compare);
        return " ";
    }

    private String MakeDown(String Move, Boolean compare) {
        if(CompareDown(Move)) return OX.get(compare);
        return " ";
    }

    private Boolean CompareUp(String Move) {
        return Move.equals(Up);
    }

    private Boolean CompareDown(String Move) {
        return Move.equals(Down);
    }
}
