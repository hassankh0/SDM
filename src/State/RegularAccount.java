package State;

public class RegularAccount implements AccountState {
    private static final String REGULAR_TYPE = "Regular";
    private static final float REGULAR_INTEREST_RATE = 0.1f;

    @Override
    public String getType() {
        return REGULAR_TYPE;
    }

    @Override
    public float getInterestRate() {
        return REGULAR_INTEREST_RATE;
    }

}


