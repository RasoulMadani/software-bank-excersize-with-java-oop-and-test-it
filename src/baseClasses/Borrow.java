package baseClasses;

public class Borrow {
    private Disc disc;
    private Date date;
    private Date deliveredDate = null;
    public Borrow(Disc disc, Date date) {
        this.disc = disc;
        this.date = date;
    }
    public boolean isLate(Date deliverDate){
        return false;
    }
    public int calculateFine(int finePerDay){
       return  (getLateDays() - 7 ) > 0 ? (getLateDays() - 7 ) * finePerDay : 0;
    }
    public int getLateDays(){
        return Math.abs(date.days()- deliveredDate.days());
    }
    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate){
        this.deliveredDate = deliveredDate;
    }
    public Disc getDisc() {
        return disc;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "disc=" + disc +
                ", date=" + date +
                ", deliveredDate=" + deliveredDate +
                '}';
    }
}
