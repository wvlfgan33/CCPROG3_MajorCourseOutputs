package model;

public class Sale {
    private Item item;
    private int amountSold;

    public Sale(Item item, int amountSold){
        this.item = item;
        this.amountSold = amountSold;
    }

    public Item getItem(){ return item; }

    public int getAmountSold(){ return amountSold; }
}
