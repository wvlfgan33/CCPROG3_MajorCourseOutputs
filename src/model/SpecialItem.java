package model;

public class SpecialItem extends Item{

    private int type;
    /**
     * Creates an instance of an Item.
     *
     * @param name     The name of the item.
     * @param price    How much the item costs.
     * @param calories How much, if applicable, calories the item contains.
     */
    public SpecialItem(String name, double price, double calories, int type) {
        super(name, price, calories);
        this.type = type;
    }
    public int getType() {
        return this.type;
    }
}
