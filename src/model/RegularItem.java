package model;

public class RegularItem extends Item{

    /**
     * Creates an instance of an Item.
     *
     * @param name     The name of the item.
     * @param price    How much the item costs.
     * @param calories How much, if applicable, calories the item contains.
     */
    public RegularItem(String name, double price, double calories) {
        super(name, price, calories);
    }
}
