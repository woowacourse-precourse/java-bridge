package bridge.UI.output;

public class MapDrawer {
    private StringBuilder upSide;
    private StringBuilder downSide;

    public MapDrawer() {
        this.upSide = new StringBuilder();
        this.downSide = new StringBuilder();
    }

    public void initializeMap() {
        upSide = new StringBuilder();
        downSide = new StringBuilder();
    }

}

