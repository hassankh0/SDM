package Classes;

public class Debit {
    private float amount;
    private float limit;

    public Debit(float limit) {
        this.limit=limit;
        this.amount = 0.0F;
    }

    public float Deposit(float amount) {
        if (this.amount > 0.0) {
            if (this.amount >= amount) {
                this.amount -= amount;
                amount = 0.0F;
            } else {
                amount -= this.amount;
                this.amount = 0.0F;
            }
        }

        return amount;
    }

    public boolean Withdraw(double amount) {
        if (this.limit - this.amount >= amount) {
            this.amount += amount;
            return true;
        } else {
            return false;
        }
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getLimit() {
        return limit;
    }

    public void changeLimit(float limit) {
        this.limit = limit;
    }
}
