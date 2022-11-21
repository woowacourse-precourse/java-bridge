package inMemoryDB;

import java.util.ArrayList;
import java.util.List;

public class GameData {

    private final List<String> movingFloorDataSet;
    private final List<String> passDataSet;

    public GameData() {
        this.movingFloorDataSet = new ArrayList<>();
        this.passDataSet = new ArrayList<>();
    }

    public List<String> getMovingFloorDataSet() {
        return movingFloorDataSet;
    }

    public List<String> getPassDataSet() {
        return passDataSet;
    }

    public void setGameData(String movingFloorData, String passData) {
        movingFloorDataSet.add(movingFloorData);
        passDataSet.add(passData);
    }
}
