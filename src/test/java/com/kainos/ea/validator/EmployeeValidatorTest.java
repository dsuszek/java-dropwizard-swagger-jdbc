package com.kainos.ea.validator;

import com.kainos.ea.exception.*;
import com.kainos.ea.model.EmployeeRequest;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeValidatorTest {

    EmployeeValidator employeeValidator = new EmployeeValidator();

    @Test
    public void isValidEmployee_shouldReturnTrue_whenValidEmployee() throws SalaryTooLowException, BankNumberLengthException, FirstNameLengthException, LastNameLengthException, NinLengthException {
        EmployeeRequest employeeRequest = new EmployeeRequest(
                30000,
                "Tim",
                "Bloggs",
                "tbloggs@email.com",
                "1 Main Street",
                "Main Road",
                "Belfast",
                "Antrim",
                "BT99BT",
                "Northern Ireland",
                "12345678901",
                "12345678",
                "AA1A11AA"
        );

        assertTrue(employeeValidator.isValidEmployee(employeeRequest));
    }

    @Test
    public void isValidEmployee_shouldThrowSalaryTooLowException_whenSalaryTooLow() {
        EmployeeRequest employeeRequest = new EmployeeRequest(
                10000,
                "Tim",
                "Bloggs",
                "tbloggs@email.com",
                "1 Main Street",
                "Main Road",
                "Belfast",
                "Antrim",
                "BT99BT",
                "Northern Ireland",
                "12345678901",
                "12345678",
                "AA1A11AA"
        );

        assertThrows(SalaryTooLowException.class,
                () -> employeeValidator.isValidEmployee(employeeRequest));
    }

    /*
    Unit Test Exercise 1

    Write a unit test for the isValidEmployee method

    When the bank number is less than 8 characters

    Expect BankNumberLengthException to be thrown

    This should pass without code changes
     */
    @Test
    public void isValidEmployee_shouldThrowBankNumberLengthException_whenBankNumberIsLessThan8Characters() throws BankNumberLengthException, SalaryTooLowException {
        EmployeeRequest employeeRequest = new EmployeeRequest(
                30000,
                "Tim",
                "Bloggs",
                "tbloggs@email.com",
                "1 Main Street",
                "Main Road",
                "Belfast",
                "Antrim",
                "BT99BT",
                "Northern Ireland",
                "12345678901",
                "12348",
                "AA1A11AA"
        );

        assertThrows(BankNumberLengthException.class,
                () -> employeeValidator.isValidEmployee(employeeRequest));
    }

    /*
    Unit Test Exercise 2

    Write a unit test for the isValidEmployee method

    When the bank number is more than 8 characters

    Expect BankNumberLengthException to be thrown

    This should pass without code changes
    */
    @Test
    public void isValidEmployee_shouldThrowBankNumberLengthException_whenBankNumberIsMoreThan8Characters() throws BankNumberLengthException, SalaryTooLowException {
        EmployeeRequest employeeRequest = new EmployeeRequest(
                30000,
                "Tim",
                "Bloggs",
                "tbloggs@email.com",
                "1 Main Street",
                "Main Road",
                "Belfast",
                "Antrim",
                "BT99BT",
                "Northern Ireland",
                "12345678901",
                "12345642434378",
                "AA1A11AA"
        );

        assertThrows(BankNumberLengthException.class,
                () -> employeeValidator.isValidEmployee(employeeRequest));
    }


    /*
    Unit Test Exercise 3

    Write a unit test for the isValidEmployee method

    When the first name more than 50 characters

    Expect false to be returned

    This should fail, make code changes to make this test pass
     */
    @Test
    public void isValidEmployee_shouldReturnFalse_whenFirstNameLengthIsMoreThan50Characters() throws FirstNameLengthException, BankNumberLengthException, SalaryTooLowException, LastNameLengthException, NinLengthException {
        EmployeeRequest employeeRequest = new EmployeeRequest(
                30000,
                "Timewgnwfnwejkfkwefkwegkegehgkehgkfefwefewfwefewfwfsdfsdffwfwefwfwfefwefwfawefwefwefwefwfherkgherhgnkvnkjlncojhfwuoefhwkebcwkcbsnkcwfwfscscwfewef",
                "Bloggs",
                "tbloggs@email.com",
                "1 Main Street",
                "Main Road",
                "Belfast",
                "Antrim",
                "BT99BT",
                "Northern Ireland",
                "12345678901",
                "12345678",
                "AA1A11AA"
        );

        boolean result = employeeValidator.isValidEmployee(employeeRequest);
        assertFalse(result);
    }

    /*
    Unit Test Exercise 4

    Write a unit test for the isValidEmployee method

    When the last name more than 50 characters

    Expect false to be returned

    This should fail, make code changes to make this test pass
     */

    @Test
    public void isValidEmployee_shouldReturnFalse_whenLastNameMoreThan50Characters() throws FirstNameLengthException, BankNumberLengthException, SalaryTooLowException, LastNameLengthException, NinLengthException {
        EmployeeRequest employeeRequest = new EmployeeRequest(
                30000,
                "Tim",
                "Bloggsewgnwfnwejkfkwefkwegkegehgkehgkfefwefewfwefewfwfsdfsdffwfwefwfwfefwefwfawefwefwefwefwfherkgherhgnkvnkjlncojhfwuoefhwkebcwkcbsnkcwfwfscscwfewef",
                "tbloggs@email.com",
                "1 Main Street",
                "Main Road",
                "Belfast",
                "Antrim",
                "BT99BT",
                "Northern Ireland",
                "12345678901",
                "12345678",
                "AA1A11AA"
        );

        boolean result = employeeValidator.isValidEmployee(employeeRequest);
        assertFalse(result);
    }

    /*
    Unit Test Exercise 5

    Write a unit test for the isValidEmployee method

    When the nin is more than 8 characters

    Expect NinLengthException to be thrown

    This should fail, make code changes to make this test pass
     */
    @Test
    public void isValidEmployee_shouldThrowNinLengthException_whenNinIsMoreThan8Characters() throws FirstNameLengthException, BankNumberLengthException, SalaryTooLowException, LastNameLengthException, NinLengthException {
        EmployeeRequest employeeRequest = new EmployeeRequest(
                30000,
                "Tim",
                "Bloggs",
                "tbloggs@email.com",
                "1 Main Street",
                "Main Road",
                "Belfast",
                "Antrim",
                "BT99BT",
                "Northern Ireland",
                "12345678901",
                "12345678",
                "AA1A11BBFABBB221ADAA"
        );

        assertThrows(NinLengthException.class,
                () -> employeeValidator.isValidEmployee(employeeRequest));
    }

    /*
    Unit Test Exercise 6

    Write a unit test for the isValidEmployee method

    When the nin is less than 8 characters

    Expect NinLengthException to be thrown

    This should fail, make code changes to make this test pass
     */

    @Test
    public void isValidEmployee_shouldThrowNinLengthException_whenNinIsLessThan8Characters() throws FirstNameLengthException, BankNumberLengthException, SalaryTooLowException, LastNameLengthException, NinLengthException {
        EmployeeRequest employeeRequest = new EmployeeRequest(
                30000,
                "Tim",
                "Bloggs",
                "tbloggs@email.com",
                "1 Main Street",
                "Main Road",
                "Belfast",
                "Antrim",
                "BT99BT",
                "Northern Ireland",
                "12345678901",
                "12345678",
                "A1AA"
        );

        assertThrows(NinLengthException.class,
                () -> employeeValidator.isValidEmployee(employeeRequest));
    }
}