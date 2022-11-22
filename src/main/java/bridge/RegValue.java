package bridge;

public enum RegValue {
  ONLY_NUMBER("^[0-9]+$");

  private final String REG;
  RegValue(String REG) {
    this.REG = REG;
  }

  public String getReg() {
    return REG;
  }

}
