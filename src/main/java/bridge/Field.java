package bridge;

public class Field {
    private String location;
    private boolean correction;

    public Field() {
    }

    public Field(String location, boolean correction) {
        this.location = location;
        this.correction = correction;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isCorrection() {
        return correction;
    }

    public void setCorrection(boolean correction) {
        this.correction = correction;
    }
}
