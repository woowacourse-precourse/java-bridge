package bridge.view;// @ author ninaaano

public enum MapView {
    // [ O |   |   ]
    MAP_LEFT("[ "),
    MAP_RIGHT(" ]"),
    MAP_MIDDLE(" | "),
    MAP_O("O"),
    MAP_X("X");

    private final String mapView;

    MapView(String mapView) {
        this.mapView = mapView;
    }

    @Override
    public String toString() {
        return mapView;
    }
}
