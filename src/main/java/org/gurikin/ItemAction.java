package org.gurikin;

import java.math.BigDecimal;
import java.util.concurrent.Exchanger;

public class ItemAction {
    private static Exchanger<Item> exchanger = new Exchanger<>();
    
    public void doActionPrice(Item item, BigDecimal discount) {
        try {
            item.setPrice(item.getPrice().multiply(discount));
            item = exchanger.exchange(item);
            item.setPrice(item.getPrice().multiply(discount));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doActionDescription(Item item, String addDescription) {
        try {
            item.setDescription(item.getDescription() + addDescription);
            item = exchanger.exchange(item);
            item.setDescription(item.getDescription() + addDescription);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
