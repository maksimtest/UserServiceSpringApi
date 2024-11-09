package comparus.service.service;

import comparus.service.exception.FilterInvalidParametersException;
import comparus.service.exception.OrderInvalidParametersException;
import comparus.service.exception.PropagationInvalidParametersException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ValidateRequestParametersTest {
    private static List<String> fieldNames = new ArrayList<>();
    private static List<String> validFilters = new ArrayList<>();
    private static List<String> invalidFilters = new ArrayList<>();
    private static List<String> validOrders = new ArrayList<>();
    private static List<String> invalidOrders = new ArrayList<>();
    private static List<String> validPropagation = new ArrayList<>();
    private static List<String> invalidPropagation = new ArrayList<>();

    private ValidateRequestParameters validator = new ValidateRequestParameters();

    @BeforeAll
    public static void setUpBeforeClass() {
        validFilters.add("");
        validFilters.add(null);
        validFilters.add("username-a");
        validFilters.add("username-1");
        validFilters.add("username-2");
        validFilters.add("name-a");
        validFilters.add("name-1");
        validFilters.add("name-2");
        validFilters.add("surname-a");
        validFilters.add("surname-1");
        validFilters.add("surname-2");

        invalidFilters.add("0");
        invalidFilters.add("username-");
        invalidFilters.add("-");
        invalidFilters.add("name-");
        invalidFilters.add("-");
        invalidFilters.add("surname-");
        invalidFilters.add("-0");
        invalidFilters.add("-");

        validOrders.add("");
        validOrders.add(null);
        validOrders.add("id");
        validOrders.add("username");
        validOrders.add("name");
        validOrders.add("surname");
        validOrders.add("-id");
        validOrders.add("-username");
        validOrders.add("-name");
        validOrders.add("-surname");

        invalidOrders.add("--username");
        invalidOrders.add("--name");
        invalidOrders.add("--surname");
        invalidOrders.add("username-");
        invalidOrders.add("name-");
        invalidOrders.add("surname-");
        invalidOrders.add("username1");
        invalidOrders.add("name1");
        invalidOrders.add("surname1");

        validPropagation.add("");
        validPropagation.add(null);
        validPropagation.add("0-5");
        validPropagation.add("0-6");
        validPropagation.add("0-10");
        validPropagation.add("1-10");
        validPropagation.add("2-10");
        validPropagation.add("2-8");

        invalidPropagation.add("0");
        invalidPropagation.add("1");
        invalidPropagation.add("2");
        invalidPropagation.add("-0");
        invalidPropagation.add("-10");
        invalidPropagation.add("0-");
        invalidPropagation.add("1-");
        invalidPropagation.add("2-");
        invalidPropagation.add("-1");
    }

    @Test
    void checkInvalidFilterField() {
        for (String value : invalidFilters) {
            assertThrows(FilterInvalidParametersException.class, () -> {
                validator.checkFilterField(value);
            }, "Invalid filter \"" + value + "\" should throw FilterInvalidParametersException.");
        }
    }

    @Test
    void checkValidFilterField() {
        for (String value : validFilters) {
            assertDoesNotThrow(() -> {
                validator.checkFilterField(value);
            }, "Check filter \"" + value + "\" calls exception. It shouldn`t throw any exception!");
        }
    }

    @Test
    void checkInvalidPropagationField() {
        for (String value : invalidPropagation) {
            assertThrows(PropagationInvalidParametersException.class, () -> {
                validator.checkPropagationField(value);
            }, "Invalid propagation \"" + value + "\" should throw PropagationInvalidParametersException.");
        }
    }

    @Test
    void checkValidPropagationField() {
        for (String value : validPropagation) {
            assertDoesNotThrow(() -> {
                validator.checkPropagationField(value);
            }, "Check propagation \"" + value + "\" calls exception. It shouldn`t throw any exception!");
        }
    }
    @Test
    void checkInvalidOrderField() {
        for (String value : invalidOrders) {
            assertThrows(OrderInvalidParametersException.class, () -> {
                validator.checkOrderField(value);
            }, "Invalid order \"" + value + "\" should throw OrderInvalidParametersException.");
        }
    }

    @Test
    void checkValidOrderField() {
        for (String value : validOrders) {
            assertDoesNotThrow(() -> {
                validator.checkOrderField(value);
            }, "Check order \"" + value + "\" calls exception. It shouldn`t throw any exception!");
        }
    }
}