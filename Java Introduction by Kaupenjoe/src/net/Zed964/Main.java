package net.Zed964;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        chooseExercice();
    }

    public static void exercice1() {
        List<Questions> questions = new ArrayList<>();
        List<Answers> answers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Questions questions1 = new Questions("Est ce que le personnage avec une tenue verte dans Zelda s'appelle Zelda ?");
        Answers answers1 = new Answers("NON ! C'est Link evidement !!!");

        Questions questions2 = new Questions("Est ce que le Hellfest c'est cool ?");
        Answers answers2 = new Answers("non... C'EST INCROYABLE");

        Questions questions3 = new Questions("Est ce que Papatte est insupportable ?");
        Answers answers3 = new Answers("OUI elle est inarétable !");

        Questions questions4 = new Questions("Est ce que la télé de Antoine fonctionne ?");
        Answers answers4 = new Answers("Certainement pas");

        Questions questions5 = new Questions("Est ce que j'ai encore de l'inspiration pour les questions ?");
        Answers answers5 = new Answers("Clairement pas");

        int compteur = 0;
        int nbrQuestionPlay = 0;
        String userAnswer;
        String again;
        boolean loop = true;

        questions.add(questions1);
        questions.add(questions2);
        questions.add(questions3);
        questions.add(questions4);
        questions.add(questions5);

        answers.add(answers1);
        answers.add(answers2);
        answers.add(answers3);
        answers.add(answers4);
        answers.add(answers5);

        while (loop) {
            for (int i = 0; i < questions.size(); i++) {
                System.out.println();
                Questions.writeOneQuestion(questions, i);
                userAnswer = scanner.nextLine();
                if (!answers.get(i).getName().equals(userAnswer)) {
                    System.out.println("Incorrect !");
                    System.out.print("Voici la réponse : ");
                    Answers.writeOneAnswer(answers, i);
                    nbrQuestionPlay ++;
                } else {
                    compteur ++;
                    nbrQuestionPlay ++;
                    System.out.println("Bravo !");
                    System.out.println("Vous avez " + compteur + " point sur " + nbrQuestionPlay);
                }
            }
            System.out.println("Continue ? (yes for continue)");
            again = scanner.nextLine();
            if (!again.equals("yes")) {
                loop = false;
            }
            scanner.nextLine();
        }
        System.out.println("Vous avez " + compteur + " points sur " + nbrQuestionPlay);
        System.out.println("The End !");
    }

    public static void exercice2() {
        List<Person> people = new ArrayList<>();
        Map<String, Double> accounts = new HashMap<>();

        int numberAccounts;

        Person Shaka = new Person("Shaka", 42, 12345678);
        Person Ponk = new Person("Ponk", 69, 23456789);
        Person Nirvana = new Person("Nivana", 666, 34567890);

        people.add(Shaka);
        people.add(Ponk);
        people.add(Nirvana);

        numberAccounts = Bank.setupNumberAccount(people);
        Bank.setupAccount(accounts, people);

        Bank SoGen = new Bank("Société Générale", numberAccounts, people, accounts);

        Person moi = new Person("Zed", 21, 42424242);

        Bank.loop(moi, SoGen);
    }

    public static void chooseExercice() {
        int choix;
        String again = "yes";

        Scanner scanner = new Scanner(System.in);

        while (again.equals("yes")) {
            System.out.println(" 1 - Pour exo 1");
            System.out.println(" 2 - Pour exo 2");
            choix = scanner.nextInt();

            if (choix == 1 || choix == 2) {
                switch (choix) {
                    case 1:
                        exercice1();
                        break;
                    case 2:
                        exercice2();
                        break;
                }
                System.out.println("Continuer ? (yes for continue)");
                again = scanner.nextLine();
            }
        }
    }
}