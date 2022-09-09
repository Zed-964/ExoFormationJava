package net.Zed964;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Bank {
    // Attributes
    private final String name;
    private int numberAccount;
    private List<Person> customers;
    private Map<String, Double> accounts;

    Bank(String name, int numberAccount, List<Person> customers, Map<String, Double> accounts) {
        this.name = name;
        this.customers = customers;
        this.accounts = accounts;
        this.numberAccount = numberAccount;
    }

    public static void loop(Person person, Bank bank) {
        int choix =0;
        boolean arret =  true;
        double value;
        String again;

        Scanner scanner = new Scanner(System.in);

        while (arret) {
            while (choix < 1 || choix > 4) {
                System.out.println("Bienvenue !");
                System.out.println("Quel actions voulezs vous faire ?");

                System.out.println("1 - Regarder le solde de votre compte");
                System.out.println("2 - Ajouter de l'argent sur votre compte");
                System.out.println("3 - Retirer de l'argent sur votre compte");
                System.out.println("4 - Supprimer votre compte !");

                System.out.println("Entrez le numéro de laction que vous voulez effectuer");
                choix = scanner.nextInt();
            }

            if (bank.verifyAccount(person)) {
                switch (choix) {
                    case 1:
                        System.out.println("Votre compte contient : ");
                        value = bank.checkAccount(person);
                        System.out.println(value);
                        break;
                    case 2:
                        System.out.println("Indiquer le montant à ajouter : ");
                        value = scanner.nextDouble();
                        bank.addValueToAccount(person, value);
                        System.out.println("Votre compte contient maintenant : ");
                        value = bank.checkAccount(person);
                        System.out.println(value);
                        break;
                    case 3:
                        System.out.println("Indiquer le montant à retirer : ");
                        value = scanner.nextDouble();
                        bank.removeValueToAccount(person, value);
                        System.out.println("Votre compte contient maintenant : ");
                        value = bank.checkAccount(person);
                        System.out.println(value);
                        break;
                    case 4:
                        bank.removeAccount(person);
                        bank.removeCustomers(person);
                        System.out.println("Votre compte n'existe plus !");
                        break;
                }
                choix = 0;
                scanner.nextLine();
                System.out.println("Voulez vous continuer ? ");
                System.out.println("(yes or not)");
                again = scanner.nextLine();
                if (!again.equals("yes")) {
                    arret = false;
                }
            } else {
                bank.addCustomers(person);
                bank.addAccount(person);
                System.out.println("Compte creer !");
            }
        }
        System.out.println("Bye !");

    }

    public void addCustomers(Person person) {
        this.customers.add(person);
    }

    public void removeCustomers(Person person) {
        this.customers.remove(person);
    }

    public boolean verifyAccount(Person person) {
        return this.customers.contains(person);
    }

    public void addAccount(Person person) {
        String nameNewAccount = person.getName();
        this.accounts.put(nameNewAccount, 0.0);
        this.numberAccount ++;
    }

    public void removeAccount(Person person) {
        this.accounts.remove(person.getName());
        this.numberAccount --;
    }

    public double checkAccount(Person person) {
        return accounts.get(person.getName());
    }

    public void addValueToAccount(Person person, double valueToAdd) {
        String nameAddAccount;
        nameAddAccount = person.getName();
        double newValueToAdd = accounts.get(person.getName()) + valueToAdd;
        this.accounts.put(nameAddAccount, newValueToAdd);
    }

    public void removeValueToAccount(Person person, double valueToRemove) {
        String nameRemoveAccount;
        nameRemoveAccount = person.getName();
        double newValueToAdd = accounts.get(person.getName()) - valueToRemove;
        this.accounts.put(nameRemoveAccount, newValueToAdd);
    }

    public static int setupNumberAccount(List<Person> customers) {
        int numberAccount;
        numberAccount = customers.size();
        return  numberAccount;
    }

    public static void setupAccount(Map<String, Double> accounts, List<Person> customers) {
        String accountName;

        for (Person customer : customers) {
            accountName = customer.getName();
            accounts.put(accountName, 0.0);
        }
    }
}
