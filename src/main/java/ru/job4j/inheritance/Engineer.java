package ru.job4j.inheritance;

public class Engineer extends Profession {

    private int experience;

    public Engineer() {
    }

    public Engineer(String name,
                    String surname,
                    String education,
                    String birthday,
                    int experience) {
        super(name, surname, education, birthday);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void working(int experience) {
        if (experience > 5) {
            System.out.println("Сидеть, ничего не делая");
        } else {
            System.out.println("Набираться опыта");
        }

    }
}
