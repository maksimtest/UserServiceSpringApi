package comparus.service.service;

import comparus.service.exception.FilterInvalidParametersException;
import comparus.service.exception.InvalidParametersException;
import comparus.service.exception.OrderInvalidParametersException;
import comparus.service.exception.PropagationInvalidParametersException;
import org.springframework.stereotype.Service;

@Service
public class ValidateRequestParameters {
    public void checkFilterField(String filter) {
        if(filter.contains("0")){
            throw new FilterInvalidParametersException(filter);
        }
    }
    public void checkPropagationField(String propagation) {
        if(propagation.contains("0")){
            throw new PropagationInvalidParametersException(propagation);
        }
    }
    public void checkOrderField(String order){
        if(order.contains("0")){
            throw new OrderInvalidParametersException(order);
        }
    }
}
