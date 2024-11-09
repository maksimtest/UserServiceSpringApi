package comparus.service.exception;

public class PropagationInvalidParametersException extends InvalidParametersException{
    public PropagationInvalidParametersException(String value) {
        super("Propagation \""+value+"\" is invalid!");
    }
}
