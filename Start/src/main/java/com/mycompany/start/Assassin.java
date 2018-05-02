package com.mycompany.start;

public class Assassin extends Heros implements InterfaceCombat{
    
    private int luck;
    
    public Assassin(String nom, String race){
        super(nom, race, "Assassin");
    }
    
    public boolean acheverAssassin(int vie){
        this.luck = 10;
        if(vie <= 25){
            this.luck = this.luck * 4;
        }
        else if(vie <= 50){
            this.luck = this.luck * 3;
        }
        else if(vie <= 75){
            this.luck = this.luck * 2;
        }
        boolean achever = this.luck >= (int)(Math.random() * 100);
        return achever;
    }
}
