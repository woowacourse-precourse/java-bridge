package bridge.controller;

import bridge.domain.MapConverter;
import bridge.view.OutputView;

public class MapConverterController {

    private final MapConverter mapConverter;

    public MapConverterController() {
        this.mapConverter = new MapConverter();
    }

    public void initialize() {
        mapConverter.initialize();
    }

    public void drawMap(String nextMovement, boolean movementSuccess) {
        mapConverter.drawNext(nextMovement, movementSuccess);
        OutputView.printMap(mapConverter.getUpperMap(), mapConverter.getLowerMap());
    }

    public void drawLatestMap() {
        OutputView.printMap(mapConverter.getUpperMap(), mapConverter.getLowerMap());
    }
}
