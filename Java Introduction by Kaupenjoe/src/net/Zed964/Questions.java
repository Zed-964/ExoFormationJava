package net.Zed964;

import java.util.List;

public class Questions {
    private final String name;

    Questions(String name) {
        this.name = name;
    }

    public static void writeOneQuestion(List<Questions> questions, int indexOfQuestions) {
        System.out.println(questions.get(indexOfQuestions).getName());
    }

    public String getName() {
        return name;
    }
}
