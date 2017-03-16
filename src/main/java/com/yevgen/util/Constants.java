package com.yevgen.util;

public class Constants {
    public static final int MIN_PASSWORD_LENGTH = 5;
    public static final int MIN_LOGIN_LENGTH = 3;
    public static final int MIN_FULL_NAME_LENGTH = 5;
    public static final int MIN_FIRST_NAME_LENGTH = 4;
    public static final int MIN_LAST_NAME_LENGTH = 4;
    public static final int MIN_PATRONYMIC_LENGTH = 4;
    public static final String PASSWORD_CONFIRMATION_ERROR = "Wrong password confirmation. Please try again!";
    public static final String FULL_NAME_ERROR = "Your Full Name field has not enough symbols! Please input at least " +
            Constants.MIN_FULL_NAME_LENGTH + " symbols!";
    public static final String PASSWORD_ERROR = "Your password has not enough symbols! Please input at least " +
            Constants.MIN_PASSWORD_LENGTH + " symbols!";
    public static final String LOGIN_CONSISTENCE_ERROR = "Your login must contains only English symbols";
    public static final String LOGIN_LENGTH_ERROR = "Your login must consist of three or more English symbols!";
    public static final String EMPTY_FIELD_ERROR = "Please, don't be lazy and fill in all the fields marked \"*\"!";
    public static final String LOGIN_ALREADY_USED_ERROR = "This login is already used! Please input another.";
    public static final String FIRST_NAME_LENGTH_ERROR = "Your First Name field has not enough symbols! Please input " +
            "at least " + Constants.MIN_FIRST_NAME_LENGTH + " symbols!";
    public static final String LAST_NAME_LENGTH_ERROR = "Your Last Name field has not enough symbols! Please input " +
            "at least " + Constants.MIN_LAST_NAME_LENGTH + " symbols!";
    public static final String PATRONYMIC_LENGTH_ERROR = "Your Patronymic field has not enough symbols! Please input " +
            "at least " + Constants.MIN_PATRONYMIC_LENGTH + " symbols!";
    public static final String PHONE_NUMBER_FORMAT_ERROR = "Wrong phone number format! Please check the correctness of " +
            "input data!";
    public static final String PHONE_NUMBER_REGEX_FOR_VALIDATION = "\\+\\d{3}\\(\\d{2}\\)\\d{7}|[0-9]{0}";
    public static final String LOGIN_REGEX_FOR_VALIDATION = "[a-zA-Z]{1,255}$";
}
