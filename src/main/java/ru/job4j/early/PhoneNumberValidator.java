package ru.job4j.early;

import java.util.Set;

import static java.lang.Character.isDigit;

public class PhoneNumberValidator {

    private static final Set<Character> ALLOWED_CHARACTERS = Set.of('(', ')', '-');

    public static class ValidationResult {

        public enum Status {
            VALID, INVALID
        }

        private Status status;

        private String message;

        public ValidationResult(Status status, String message) {
            this.status = status;
            this.message = message;
        }

    }

    public static ValidationResult validPhoneNumber4(String phoneNumber) {
        String[] totalParts = phoneNumber.split(" ");
        if (totalParts.length != 2) {
            return new ValidationResult(ValidationResult.Status.INVALID,
                    "String is not consisted from two parts, delimited by space");
        }

        String number = totalParts[1];
        String[] numberParts = number.split("-");
        if (numberParts.length != 2) {
            return new ValidationResult(ValidationResult.Status.INVALID,
                    "Number is not consisted from two parts, delimited by -");
        }

        if (!isNumeric(totalParts[0]) || !isNumeric(number)) {
            return new ValidationResult(ValidationResult.Status.INVALID,
                    "String contains denied charaters");
        }

        return new ValidationResult(ValidationResult.Status.VALID, "Valid");
    }

    private static boolean isNumeric(String string) {
        for (var i = 0; i < string.length(); i++) {
            var symbol = string.charAt(i);
            if (!ALLOWED_CHARACTERS.contains(symbol) && !isDigit(symbol)) {
                return false;
            }
        }
        return true;
    }

}
