package ru.job4j.early;

public class PasswordValidator {

    private static final String[] WRONG_SUBSTRINGS = {
            "qwerty",
            "12345",
            "password",
            "admin",
            "user"
    };

    public static String validate(String password) {
        boolean containUppercase = false;
        boolean containLowercase = false;
        boolean containFigure = false;
        boolean containSpecial = false;
        boolean containWrong = false;

        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }

        char[] symbols = password.toCharArray();
        for (char symbol : symbols) {
            if (Character.isUpperCase(symbol)) {
                containUppercase = true;
            }
            if (Character.isLowerCase(symbol)) {
                containLowercase = true;
            }
            if (Character.isDigit(symbol)) {
                containFigure = true;
            }
            if (!Character.isLetterOrDigit(symbol)) {
                containSpecial = true;
            }
            if (containUppercase && containLowercase && containFigure && containSpecial) {
                break;
            }
        }
        for (String subString : WRONG_SUBSTRINGS) {
            if (password.toLowerCase().contains(subString)) {
                containWrong = true;
                break;
            }
        }

        if (!containUppercase) {
            throw new IllegalArgumentException("Password "
                    + "should contain at least one uppercase letter");
        }
        if (!containLowercase) {
            throw new IllegalArgumentException("Password "
                    + "should contain at least one lowercase letter");
        }
        if (!containFigure) {
            throw new IllegalArgumentException("Password "
                    + "should contain at least one figure");
        }
        if (!containSpecial) {
            throw new IllegalArgumentException("Password "
                    + "should contain at least one special symbol");
        }
        if (containWrong) {
            throw new IllegalArgumentException("Password "
                    + "shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }
}