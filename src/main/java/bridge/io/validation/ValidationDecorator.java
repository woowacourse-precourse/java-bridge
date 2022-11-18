package bridge.io.validation;

abstract public class ValidationDecorator implements Validation{

  private Validation validation;

  public ValidationDecorator(Validation validation) {
    this.validation = validation;
  }

  @Override
  public void validate(String input) {
    validation.validate(input);
  }
}
