package fairyShop.models;

public class ShopImpl implements Shop{


    @Override
    public void craft(Present present, Helper helper) {

        while (!present.isDone() && helper.canWork()) {
            Instrument instrumentToUse = null;

            for (Instrument instrument : helper.getInstruments()) {
                if (!instrument.isBroken()) {
                    instrumentToUse = instrument;
                    break;
                }
            }

            if (instrumentToUse != null) {
                present.getCrafted();
                instrumentToUse.use();
                helper.work();
            } else {
                break; // No usable instruments left, stop crafting
            }
        }
    }
}
