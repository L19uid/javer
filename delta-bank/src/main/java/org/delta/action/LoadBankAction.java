package org.delta.action;

public class LoadBankAction {
    private String bankName;
    private String bankPath;

    public LoadBankAction(String bankName, String bankPath) {
        this.bankName = bankName;
        this.bankPath = bankPath;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankPath() {
        return bankPath;
    }
}
