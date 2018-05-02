package com.mycompany.start;

public class Heros {
    private String nomHero;
    private String raceHero;
    private String roleHero;
    private int vieHero = 100;
    private int forceHero = 10;
    private int agiliteHero = 20;
    private int intelligenceHero = 20;
    
    public Heros(String nom, String race, String role){
        this.nomHero = nom;
        this.raceHero = race;
        this.roleHero = role;
    }

    public String getNomHero(){
        return this.nomHero;
    }
    public String getRaceHero(){
        return this.raceHero;
    }
    
    public int getAttaque(){
        int attaque = this.forceHero;
        
        if(this.raceHero.equalsIgnoreCase("Humain")){
            attaque += 5;
        }
        else if(this.raceHero.equalsIgnoreCase("Elfe")){
            attaque += -2;
        }
        
        if(this.roleHero.equalsIgnoreCase("Guerrier")){
            attaque += 7;
        }
        else if(this.roleHero.equalsIgnoreCase("Assassin")){
            attaque += -3;
        }
        
        return attaque;
    }
    
    public boolean getEsquive(){
        int agilite = this.agiliteHero;
        
        if(this.raceHero.equalsIgnoreCase("Elfe")){
            agilite += 7;
        }
        else if(this.raceHero.equalsIgnoreCase("Nain")){
            agilite += -10;
        }
        
        if(this.roleHero.equalsIgnoreCase("Mage")){
            agilite += -5;
        }
        else if(this.roleHero.equalsIgnoreCase("Assassin")){
            agilite += 9;
        }
        
        int random = (int)(100 * Math.random()); // valeur decimale entre 0 et 1
        boolean esquive = agilite >= random;
        return esquive;
    }
    
    public boolean getCritique(){
        int intelligence = this.intelligenceHero;
        
        if(this.raceHero.equalsIgnoreCase("Humain")){
            intelligence += -5;
        }
        else if(this.raceHero.equalsIgnoreCase("Nain")){
            intelligence += 5;
        }
        
        if(this.roleHero.equalsIgnoreCase("Guerrier")){
            intelligence += -10;
        }
        else if(this.roleHero.equalsIgnoreCase("Mage")){
            intelligence += 7;
        }
        
        int random = (int)(100 * Math.random()); // valeur decimale entre 0 et 1
        boolean critique = intelligence >= random;
        return critique;
    }
    
    public int blesser(int degats){
        this.vieHero -= degats;
        if(this.vieHero < 0){
            this.vieHero = 0;
        }
        if(this.vieHero > 100){
            this.vieHero = 100;
        }
        return degats;
    }
    
    public int vie(){
        return this.vieHero;
    }
    
    public boolean isAlive(){
        boolean alive = this.vieHero > 0;
        return alive;
    }
}