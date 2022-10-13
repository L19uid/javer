package org.delta;

import com.google.gson.Gson;
import org.delta.account.*;
import org.delta.account.serialization.AccountJsonSerializationFactory;
import org.delta.account.serialization.AccountJsonSerializationObject;
import org.delta.action.ActionListener;
import org.delta.action.HelpAction;
import org.delta.card.CardCreatorService;
import org.delta.menu.Menu;
import org.delta.menu.MenuChoices;
import org.delta.person.Person;
import org.delta.person.PersonFactory;
import org.delta.account.AccountType;
import org.delta.storage.FileSystemStorage;
import org.delta.storage.JsonSerializationService;

import javax.inject.Inject;
import java.io.IOException;

public class Bank {

    @Inject
    private ActionListener actionListener;

    @Inject
    private AccountInfoPrinterService accountInfoPrinterService;

    @Inject
    private MoneyTransferService moneyTransferService;

    @Inject
    private InterestRunnerService interestRunnerService;

    @Inject
    private PersonFactory personFactory;

    @Inject
    private AccountFactory accountFactory;

    @Inject
    private CardCreatorService cardCreatorService;

    @Inject
    private AccountService accountService;

    @Inject
    private AccountJsonSerializationFactory accountJsonSerializationFactory;

    @Inject
    private FileSystemStorage fileSystemStorage;

    @Inject
    private JsonSerializationService jsonSerializationService;



    public void registerActions() {
        this.actionListener.registerAction(MenuChoices.HELP, new HelpAction());
        this.actionListener.registerAction(MenuChoices.DETAIL, new HelpAction());
        this.actionListener.registerAction(MenuChoices.ACCOUNTS, new HelpAction());
        this.actionListener.registerAction(MenuChoices.CREDIT, new HelpAction());
        this.actionListener.registerAction(MenuChoices.SAVING, new HelpAction());
        this.actionListener.registerAction(MenuChoices.INVALID_CHOICE, new HelpAction());
    }

    public void startTerminal() {
        System.out.println("Hello from bank application!");

        Menu menu = new Menu();
        menu.printMenu();

        while (true) {
            MenuChoices choice = menu.read();

            if (choice == MenuChoices.EXIT) {
                break;
            }

            this.actionListener.processAction(choice);
        }
    }

    public void StartTerminal()
    {
        System.out.println("Hello from bank application!");

        Menu menu = new Menu();
        menu.printMenu();

        while (true) {
            MenuChoices choice = menu.read();

            System.out.println("choice : " + choice);

            if (choice == MenuChoices.EXIT) {
                break;
            }

            this.actionListener.processAction(choice);
        }
    }

    public void example() {

        Person owner = this.personFactory.createPerson("Tomas", "Pesek", "22");

        BaseAccount accountOne = this.accountService.createAccount(AccountType.BASE, owner, 1000);
        BaseAccount accountTwo = this.accountService.createAccount(AccountType.STUDENT,owner, 5000);
        BaseAccount accountThree = this.accountService.createAccount(AccountType.SAVING,owner, 10000);

        this.accountInfoPrinterService.printAccountInfo(accountOne);
        this.accountInfoPrinterService.printAccountInfo(accountTwo);
        this.accountInfoPrinterService.printAccountInfo(accountThree);
        System.out.println();

        this.moneyTransferService.transferMoney(accountOne, accountTwo, 500);

        this.accountInfoPrinterService.printAccountInfo(accountOne);
        this.accountInfoPrinterService.printAccountInfo(accountTwo);
        System.out.println();

        interestRunnerService.run(this.accountService.getAccounts());

        this.accountInfoPrinterService.printAccountInfo(accountOne);
        this.accountInfoPrinterService.printAccountInfo(accountTwo);
        this.accountInfoPrinterService.printAccountInfo(accountThree);
        System.out.println();

        this.cardCreatorService.createCardAndSetIntoAccount(accountOne);
        this.accountInfoPrinterService.printAccountInfo(accountOne);

        AccountJsonSerializationObject jsonAcc = accountJsonSerializationFactory.createFromBaseAccount(accountOne);

        String json = jsonSerializationService.serialize(jsonAcc);

        fileSystemStorage.save(json,"account.json");
        String jsonFile = fileSystemStorage.read("account.json");

        AccountJsonSerializationObject readAccount = jsonSerializationService.deserialize(jsonFile, AccountJsonSerializationObject.class);
        BaseAccount account = accountFactory.createFactoryFromJsonSerializationObject(readAccount);
        accountFactory.addAccount(account);

        this.accountInfoPrinterService.printAccountInfo(account);
    }
}
