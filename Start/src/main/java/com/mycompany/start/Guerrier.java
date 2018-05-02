package com.mycompany.start;

public class Guerrier extends Heros implements InterfaceCombat{
    
    private int armor;
    
    public Guerrier(String nom, String race, int armure){
        super(nom, race, "Guerrier");
        armor = armure;
    }
    
    public int blesserGuerrier(int degat){ // on diminue les degats du guerrier grace a l'armure
        degat = degat - this.armor;
        if(degat < 0){
            degat = 0;
        }
        return blesser(degat);
    }
}
