package net.Zed964;

import java.util.List;

public class Answers {
    private final String name;

    Answers(String name) {
        this.name = name;
    }

    public static void writeOneAnswer(List<Answers> answers, int indexOfQuestions) {
        System.out.println(answers.get(indexOfQuestions).getName());
    }

    public String getName() {
        return name;
    }
}
