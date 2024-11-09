package comparus.service.exception;

public class OrderInvalidParametersException extends InvalidParametersException{
    public OrderInvalidParametersException(String value) {
        super("Order \""+value+"\" is invalid!");
    }
}
