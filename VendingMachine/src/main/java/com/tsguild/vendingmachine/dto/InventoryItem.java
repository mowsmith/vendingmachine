
package com.tsguild.vendingmachine.dto;

import java.util.Objects;

/**
 *
 * @author Morgan Smith
 */
public class InventoryItem {

    private String name;
    private double cost;
    private int numberInInventory;
    private int id;
    
    public InventoryItem() {
    }

    public InventoryItem(String name, double cost, int numberInInventory) {
        this.name = name;
        this.cost = cost;
        this.numberInInventory = numberInInventory;
    }

    public InventoryItem(String name, double cost, int numberInInventory, int id) {
        this.name = name;
        this.cost = cost;
        this.numberInInventory = numberInInventory;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getNumberInInventory() {
        return numberInInventory;
    }

    public void setNumberInInventory(int numberInInventory) {
        this.numberInInventory = numberInInventory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.cost) ^ (Double.doubleToLongBits(this.cost) >>> 32));
        hash = 97 * hash + this.numberInInventory;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InventoryItem other = (InventoryItem) obj;
        if (Double.doubleToLongBits(this.cost) != Double.doubleToLongBits(other.cost)) {
            return false;
        }
        if (this.numberInInventory != other.numberInInventory) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
}
