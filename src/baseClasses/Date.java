package baseClasses;

public class Date {
    private int year,month,day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public  int[] days_of_month = {31,31,31,31,31,31,30,30,30,30,30,29};
    public  int days(){
        int d1 = 0;
        d1 += this.year * 365;
        for (int i = 0; i < this.month-1; i++) {
            d1+= this.days_of_month[i];
        }
        d1+=this.day;
        return d1;
    }

    public int getYear() {
        return year;
    }

    public Date setYear(int year) {
        this.year = year;
        return this;
    }

    public int getMonth() {
        return month;
    }

    public Date setMonth(int month) {
        this.month = month;
        return this;
    }

    public int getDay() {
        return day;
    }

    public Date setDay(int day) {
        this.day = day;
        return this;
    }

    @Override
    public String toString() {
        return "Date{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
