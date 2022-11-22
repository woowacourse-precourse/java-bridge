package bridge.view;// @ author ninaaano

public enum MapView {
    MAP_MIDDLE(" | "),
    MAP_BLANK(" "),
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
