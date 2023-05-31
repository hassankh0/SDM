package State;


public class PremiumAccount implements AccountState {
    private static final String PREMIUM_TYPE = "Premium";
    private static final float PREMIUM_INTEREST_RATE = 0.05f;

    @Override
    public String getType() {
        return PREMIUM_TYPE;
    }

    @Override
    public float getInterestRate() {
        return PREMIUM_INTEREST_RATE;
    }
}
