package org.delta.account;

public enum AccountType {
    BASE,STUDENT,SAVING;

    public static AccountType GetType(BaseAccount baseAccount) {
        switch (baseAccount.getClass().getSimpleName()) {
            case "BaseAccount":
                return BASE;
            case "StudentAccount":
                return STUDENT;
            case "SavingAccount":
                return SAVING;
            default:
                return null;
        }
    }
}

