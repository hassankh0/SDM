package Classes;

public class Interest {
    private int interestId;
    private float totalAmount;
    private int months;
    private float rate;

    public Interest(float totalAmount, int months, float rate) {
        this.interestId = (int)Math.floor(Math.random() * 900000.0 + 100000.0);
        this.totalAmount = totalAmount;
        this.months = months;
        this.rate = rate;
    }

    public float calculate(){
        float monthlyInterestRate = this.rate / 12;
        float power = (float) Math.pow(1 + monthlyInterestRate, this.months);
        float monthlyPayment = this.totalAmount * ((monthlyInterestRate * power) / (power - 1));
        return monthlyPayment;
    }
}
