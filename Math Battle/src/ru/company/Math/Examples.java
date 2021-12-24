package ru.company.Math;

public class Examples {
    private int difficultyLevel;

    public Examples(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    private int creatureEasyExamples() {
        int a;
        int b;
        int c;
        int example;

        a = (int)(Math.random() * 10);
        b = (int)(Math.random() * 10);
        c = (int)(Math.random() * 10);
        example = a + b + c;
        System.out.print(a + " + " + b + " + " + c + " = ");
        return example;
    }

    private int creatureMediumExamples() {
        int a;
        int b;
        int c;
        int example;

        a = (int)(Math.random() * 10);
        b = (int)(Math.random() * 10);
        c = (int)(Math.random() * 10);
        example = a - b * c;
        System.out.print(a + " - " + b + " * " + c + " = ");
        return example;
    }

    private int creatureHardExamples() {
        int a;
        int b;
        int c;
        int d;
        int example;

        a = (int)(Math.random() * 10);
        b = (int)(Math.random() * 10);
        c = (int)(Math.random() * 10);
        d = (int)(Math.random() * 10);
        example = a + b * c - d;
        System.out.print(a + " + " + b + " * " + c + " - " + d + " = ");
        return example;
    }

    public int exampleGenerator() {
        switch (difficultyLevel) {
            case 1:
                return creatureEasyExamples();
            case 2:
                return creatureMediumExamples();
            case 3:
                return creatureHardExamples();
            default:
                return -1;
        }
    }

}
