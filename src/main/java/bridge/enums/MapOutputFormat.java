package bridge.enums;

public enum MapOutputFormat {
  START_SQUARE_BRACKET("["),
  END_SQUARE_BRACKET("]"),
  RIGHT_WAY(" O "),
  WRONG_WAY(" X "),
  SEPARATOR("|"),
  EMPTY_SPACE("   ");

  private String format;

  MapOutputFormat(String format) {
    this.format = format;
  }

  public String getFormat() {
    return format;
  }
}
