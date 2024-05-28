package baseClasses;

import java.util.ArrayList;

public class Person {
    private String name;
    private ArrayList<Borrow> borrow = new ArrayList<>();
    private int fines = 0;
    private StringBuilder borrowedSoftware = new StringBuilder();
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int calculateFines(int finePerDay) {
        for (Borrow b : borrow) {
            if (b.getDeliveredDate() != null) {
                fines += b.calculateFine(finePerDay);
            }else{
                borrowedSoftware.append(b.getDisc().getName()).append("\n");
            }
        }
        return fines;
    }

    public StringBuilder getBorrowedSoftware() {
        return borrowedSoftware;
    }

    public ArrayList<Borrow> getBorrow() {
        return borrow;
    }

    public void addBorrow(Borrow borrow) {
        this.borrow.add(borrow);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", borrow=" + borrow +
                ", fines=" + fines +
                '}';
    }
}
