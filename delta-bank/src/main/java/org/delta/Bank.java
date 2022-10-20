package org.delta;

import org.delta.account.*;
import org.delta.account.serialization.AccountJsonSerializationFactory;
import org.delta.action.ActionProcessService;
import org.delta.card.CardCreatorService;
import org.delta.menu.Menu;
import org.delta.menu.MenuChoices;
import org.delta.person.PersonFactory;
import org.delta.storage.FileSystemStorage;
import org.delta.storage.JsonSerializationService;

import javax.inject.Inject;

public class Bank {

    @Inject
    private ActionProcessService actionProcessService;

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

            this.actionProcessService.processAction(choice);
        }
    }

    public void example() {

        //Scanner scanner = new Scanner(new InputStreamReader(System.in));
        //String input = scanner.next();
//
        //Person owner = this.personFactory.createPerson("Tomas", "Pesek", "22");
//
        //BaseAccount accountOne = this.accountService.createAccount(AccountType.BASE, owner, 1000);
        //BaseAccount accountTwo = this.accountService.createAccount(AccountType.STUDENT,owner, 5000);
        //BaseAccount accountThree = this.accountService.createAccount(AccountType.SAVING,owner, 10000);
//
        //this.accountInfoPrinterService.printAccountInfo(accountOne);
        //this.accountInfoPrinterService.printAccountInfo(accountTwo);
        //this.accountInfoPrinterService.printAccountInfo(accountThree);
        //System.out.println();
//
        //this.moneyTransferService.transferMoney(accountOne, accountTwo, 500);
//
        //this.accountInfoPrinterService.printAccountInfo(accountOne);
        //this.accountInfoPrinterService.printAccountInfo(accountTwo);
        //System.out.println();
//
        //interestRunnerService.run(this.accountService.getAccounts());
//
        //this.accountInfoPrinterService.printAccountInfo(accountOne);
        //this.accountInfoPrinterService.printAccountInfo(accountTwo);
        //this.accountInfoPrinterService.printAccountInfo(accountThree);
        //System.out.println();
//
        //this.cardCreatorService.createCardAndSetIntoAccount(accountOne);
        //this.accountInfoPrinterService.printAccountInfo(accountOne);
//
        //AccountJsonSerializationObject jsonAcc = accountJsonSerializationFactory.createFromBaseAccount(accountOne);
//
        //String json = jsonSerializationService.serialize(jsonAcc);
//
        //fileSystemStorage.save(json,"account.json");
        //String jsonFile = fileSystemStorage.read("account.json");
//
        //AccountJsonSerializationObject readAccount = jsonSerializationService.deserialize(jsonFile, AccountJsonSerializationObject.class);
        //BaseAccount account = accountFactory.createFactoryFromJsonSerializationObject(readAccount);
        //accountFactory.addAccount(account);
//
        //this.accountInfoPrinterService.printAccountInfo(account);
    }
}
