package comparus.service.exception;

public class FilterInvalidParametersException extends InvalidParametersException{
    public FilterInvalidParametersException(String value) {
        super("Filter \""+value+"\" is invalid!");
    }
}
