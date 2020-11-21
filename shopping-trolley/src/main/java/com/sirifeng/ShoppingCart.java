package com.sirifeng;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ShoppingCart {

    HashMap<Integer,GoodItem> items = null;

    public ShoppingCart() {
        items = new HashMap<Integer, GoodItem>();
    }
    public void add(GoodItem goodItem){

        int productid = goodItem.getProduct().getId();

        if (items.containsKey(productid)){
            GoodItem scitem = (GoodItem) items.get(productid);
            scitem.setQuantity(scitem.getQuantity()+goodItem.getQuantity());
        }else {
            items.put(productid,goodItem);
        }
    }
    public void remove(Integer productid){
        if (items.containsKey(productid)){
            GoodItem scitem = (GoodItem) items.get(productid);
            scitem.setQuantity(scitem.getQuantity()-1);
            if (scitem.getQuantity() <= 0){
                items.remove(productid);
            }
        }
    }
    public Collection<GoodItem> getItems(){
        return items.values();
    }
    public double getTotal(){
        double amout = 0;
        for (Iterator<GoodItem> i = getItems().iterator(); i.hasNext();){
            GoodItem item = (GoodItem)i.next();
            Product product = (Product) item.getProduct();
            amout += item.getQuantity() * product.getPrice();
        }
        return roundOff(amout);
    }
    private double roundOff(double amout){
        long val = Math.round(amout*100);
        return val/100.0;
    }
    public void clear(){
        items.clear();
    }
}
