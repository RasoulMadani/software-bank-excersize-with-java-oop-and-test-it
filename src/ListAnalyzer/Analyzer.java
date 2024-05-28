package ListAnalyzer;

import baseClasses.*;

import java.util.ArrayList;

public class Analyzer {
    private String line;
    private Bank bank;

    public Analyzer(Bank bank) {
        this.bank = bank;
    }

    public void analyze(String line) {
        String[] s = line.split(" ");
        int day = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int year = Integer.parseInt(s[2]);
        String namePerson = s[3];
        String nameDisc = s[4];
        Date date = new Date(year, month, day);
        ArrayList<Person> personList = bank.getPersonList();

        boolean flagBorrowExist = false;
        boolean flagPersonExist = false;

        for (Person p : personList) {
            if (p.getName().equals(namePerson)) {
                flagPersonExist = true;
                ArrayList<Borrow> borrow = p.getBorrow();
                for (Borrow b : borrow) {
                    Disc disc = b.getDisc();
                    if (disc.getName().equals(nameDisc) && b.getDeliveredDate() == null) {
                        b.setDeliveredDate(date);
                        flagBorrowExist = true;
                        break;
                    }
                }
                if (!flagBorrowExist) {
                    Disc disc1 = new Disc(nameDisc);
                    Borrow borrow1 = new Borrow(disc1, date);
                    p.addBorrow(borrow1);
                    break;
                }
            }
        }
        if (!flagPersonExist) {
            if (!borrowedDisc(nameDisc, personList)) {
                Disc disc1 = new Disc(nameDisc);
                Borrow borrow1 = new Borrow(disc1, date);
                Person person = new Person(namePerson);
                person.addBorrow(borrow1);
                bank.addPerson(person);
            }

        }
    }

    public boolean borrowedDisc(String nameDisc, ArrayList<Person> personList) {
        for (Person p : personList) {
            ArrayList<Borrow> borrow = p.getBorrow();
            for (Borrow b : borrow) {
                Disc disc = b.getDisc();
                if (disc.getName().equals(nameDisc) && b.getDeliveredDate() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void calculateFines(int finePerDay){
        bank.calculateFines(finePerDay);
    }
}
