package fairyShop.models;

import static fairyShop.common.ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO;

public class InstrumentImpl implements Instrument{

        private int power;

    public InstrumentImpl(int power) {
        setPower(power);
    }


    @Override
    public void use() {
        setPower(getPower()-10);
        if (getPower()<0){
            setPower(0);
        }
    }

    @Override
    public boolean isBroken() {
        return getPower()==0;
    }

    public void setPower(int power) {
        if (getPower()<0){
            throw new IllegalArgumentException(INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }
    public int getPower() {
        return power;
    }


}
