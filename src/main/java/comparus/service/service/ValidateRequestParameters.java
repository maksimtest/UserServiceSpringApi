package comparus.service.service;

import comparus.service.domain.User;
import comparus.service.exception.FilterInvalidParametersException;
import comparus.service.exception.OrderInvalidParametersException;
import comparus.service.exception.PropagationInvalidParametersException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Service
public class ValidateRequestParameters {
    public void checkFilterField(String filter) {
        if (filter != null && !filter.isEmpty()) {
            for (String fName : getFieldsName()) {
                String begin = fName + "-";
                if (filter.startsWith(begin) && filter.length() > begin.length()) {
                    return;
                }
            }
            throw new FilterInvalidParametersException(filter);
        }
    }

    public void checkPropagationField(String propagation) {
        if (propagation != null && !propagation.isEmpty()) {
            int separatorIndex = propagation.indexOf('-');
            if (separatorIndex > 0 && separatorIndex < propagation.length() - 1) {
                String num1 = propagation.substring(0, separatorIndex);
                String num2 = propagation.substring(separatorIndex + 1);
                if (isIntegerMoreZero(num1) && isIntegerMoreZero(num2)) {
                    return;
                }
            }
            throw new PropagationInvalidParametersException(propagation);
        }
    }

    private boolean isIntegerMoreZero(String value) {
        try {
            if (Integer.parseInt(value) >= 0) {
                return true;
            }
        } catch (Exception e) {
            // todo nothing
        }
        return false;
    }

    public void checkOrderField(String order) {
        if (order != null && !order.isEmpty()) {
            for (String fname : getFieldsName()) {
                if (order.equals(fname) || order.equals("-" + fname)) {
                    return;
                }
            }
            throw new OrderInvalidParametersException(order);
        }
    }

    protected List<String> getFieldsName() {
        return Arrays.stream(User.class.getDeclaredFields())
                .map(Field::getName)
                .toList();
    }
}
