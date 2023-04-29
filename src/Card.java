import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class Card {
    private long cardNumber;
    private Date expireDate;
    private int cvc;

    public Card() {
        this.cardNumber = (long) (Math.random() * 9000000000000000L) + 1000000000000000L;
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, new Random().nextInt(6) + 1); // Expiry year between current year and next 6 years
        calendar.set(Calendar.MONTH, new Random().nextInt(12)); // Expiry month between 0 and 11 (January to December)
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); // Last day of the month
        this.expireDate = calendar.getTime();

        this.cvc = new Random().nextInt(999 - 100 + 1) + 100;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }
}
