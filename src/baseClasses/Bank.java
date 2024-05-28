package baseClasses;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Person> personList = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }
    public void calculateFines(int finePerDay){
        StringBuilder borrowedSoftware = new StringBuilder();
        System.out.println("Fines : ");
        for (Person p : personList){
           int fines = p.calculateFines(finePerDay);
           if(p.getBorrowedSoftware() != null) {
               borrowedSoftware.append(p.getBorrowedSoftware());
           }

            System.out.println(p.getName() + " : " + fines);
        }
        System.out.println("Borrowed Discs :");
        System.out.println(borrowedSoftware);
    }
    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void addPerson(Person person){
        personList.add(person);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", personList=" + personList +
                '}';
    }
}
