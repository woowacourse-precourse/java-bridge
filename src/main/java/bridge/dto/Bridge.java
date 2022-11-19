package bridge.dto;

import java.util.List;

public class Bridge {
    private List<String> locations;

    public Bridge(List<String> locations) {
        this.locations = locations;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }
}