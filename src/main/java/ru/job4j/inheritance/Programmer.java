package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private boolean completeJob4j;

    public Programmer(String name,
                      String surname,
                      String education,
                      String birthday,
                      int experience,
                      boolean completeJob4j) {
        super(name, surname, education, birthday, experience);
        this.completeJob4j = completeJob4j;
    }

    public boolean isCompleteJob4j() {
        return completeJob4j;
    }

    public void setCompleteJob4j(boolean completeJob4j) {
        this.completeJob4j = completeJob4j;
    }

    public void employment(boolean completeJob4j) {
        if (completeJob4j) {
            System.out.println("Ура! Получил оффер");
        } else {
            System.out.println("Учиться-не лениться дальше");
        }
    }
}
