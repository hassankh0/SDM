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
        float monthlyRate = (float) (this.totalAmount * this.rate * this.months / 1200.0);
        float monthlyPaymentWithoutInterest = this.totalAmount / (float)this.months;
        return monthlyPaymentWithoutInterest + monthlyPaymentWithoutInterest * monthlyRate;
    }
}
