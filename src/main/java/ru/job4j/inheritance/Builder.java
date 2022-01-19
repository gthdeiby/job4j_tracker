package ru.job4j.inheritance;

public class Builder extends Engineer {

    private int rank;

    public Builder() {
    }

    public Builder(String name,
                   String surname,
                   String education,
                   String birthday,
                   int experience,
                   int rank) {
        super(name, surname, education, birthday, experience);
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public boolean buildHouse(int rank, int experience) {
        return (rank > 3 && experience > 4);
    }
}
