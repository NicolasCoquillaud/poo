package com.mycompany.start;

public class Mage extends Heros implements InterfaceCombat{
    
    private int magic;
    
    public Mage(String nom, String race){
        super(nom, race, "Mage");
    }
    
    public int soignerMage(){
        this.magic = (int)(Math.random() * 10) - 5;
        if(this.magic<0){
            this.magic = 0;
        }
        return blesser(-magic);
    }
}