package utils;

import ui.MapImage;

import java.util.ArrayList;
import java.util.List;

public class DrawMap {

    private StringBuilder upperSideOfMap;
    private StringBuilder downSideOfMap;
    private List<String> bridge;
    private List<String> playerInput;
    private List<String> upperLog = new ArrayList<>();
    private List<String> downLog = new ArrayList<>();

    public DrawMap(List<String> bridge, List<String> playerInput) {
        this.upperSideOfMap = new StringBuilder();
        this.downSideOfMap = new StringBuilder();
        this.bridge = bridge;
        this.playerInput = playerInput;
    }

}
