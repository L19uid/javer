package org.delta.menu;

public enum MenuChoices {
    HELP, CREATE_PERSON, DETAIL, ACCOUNTS, CREDIT, SAVE, LOAD, EXIT, INVALID_CHOICE;

    public static MenuChoices convertFromMenuInput(int menuInput) {
        return switch (menuInput) {
            case 1 -> HELP;
            case 2 -> CREATE_PERSON;
            case 3 -> DETAIL;
            case 4 -> ACCOUNTS;
            case 5 -> CREDIT;
            case 8 -> LOAD;
            case 9 -> SAVE;
            case 0 -> EXIT;
            default -> INVALID_CHOICE;
        };
    }

    public static void help() {
        System.out.println("MENU:");

        System.out.println(":: HELP: 1");
        System.out.println(":: CREATE PERSON: 2");
        System.out.println(":: DETAIL: 3");
        System.out.println(":: ACCOUNTS: 4");
        System.out.println(":: CREDIT: 5");
        System.out.println(":: LOAD : 8");
        System.out.println(":: SAVE : 9");
        System.out.println(":: EXIT : 0");
    }
}
