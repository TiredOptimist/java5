package ru.pankova.task_2;

public class Cat implements Meowable {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    String setName() {
        this.name = name;
        return this.name;
    }

    String getName() {
        return this.name;
    }

    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
    }

    public String toString() {
        return "кот: " + name;
    }
}
