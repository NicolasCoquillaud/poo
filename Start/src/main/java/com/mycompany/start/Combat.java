package com.mycompany.start;

public class Combat {
    public static void combattre(Heros hero1, Heros hero2){
        int degat = 0;
        int soin = 0;
        boolean finir;
        int tour = 0;
        
        if (Math.random() >= 0.5){ //Qui commence ?
            tour = 1;
        }
        while((hero1.isAlive() == true) && (hero2.isAlive() == true)){ //Combattre jusqu'à la mort
            switch(tour){
                case 0: //Joueur 1
                    System.out.println("\n"+hero1.getNomHero()+" tente une attaque...");
                    if(hero2.getEsquive() == true){ //Test si J2 esquive
                        degat = 0;
                        System.out.println(hero2.getNomHero()+" esquive !");
                    }
                    else {
                        if(hero1.getCritique() == true){ //Test si J1 fait un critique
                            degat = hero1.getAttaque() * 2;
                            System.out.print("Il réussi un coup critique et inflige ");
                        }
                        else{
                            degat = hero1.getAttaque();
                            System.out.print("Il réussi et inflige ");
                        }
                        if(hero2 instanceof Guerrier){ //Test si J1 est un Guerrier
                            degat = ((Guerrier)hero2).blesserGuerrier(degat);
                        }
                        else{    
                            degat = hero2.blesser(degat);
                        }
                        System.out.println(degat+" dégats à "+hero2.getNomHero()+" !");
                        if(hero1 instanceof Assassin){ //Test si J1 est un Assassin
                            finir = ((Assassin)hero1).acheverAssassin(hero2.vie());
                            if(finir == true){
                                hero2.blesser(3);
                                System.out.println(hero1.getNomHero()+" attaque une deuxième fois et inflige 3 dégats à "+hero2.getNomHero()+" !");
                            }
                        }
                    }
                    System.out.println(hero2.getNomHero()+" a maintenant "+hero2.vie()+" points de vie !");
                    if(hero1 instanceof Mage){ //Test si J1 est un Mage
                        soin = ((Mage)hero1).soignerMage();
                        if(soin < 0){
                            System.out.println(hero1.getNomHero()+" se soigne "+(-soin)+" points de vie !");
                            System.out.println(hero1.getNomHero()+" a maintenant "+hero1.vie()+" points de vie !");
                        }
                    }
                    tour = 1;
                    break;
                case 1: //Joueur 2
                    System.out.println("\n"+hero2.getNomHero()+" tente une attaque...");
                    if(hero1.getEsquive() == true){
                        degat = 0;
                        System.out.println(hero1.getNomHero()+" esquive !");
                    }
                    else {
                        if(hero2.getCritique() == true){
                            degat = hero2.getAttaque() * 2;
                            System.out.print("Il réussi un coup critique et inflige ");
                        }
                        else{
                            degat = hero2.getAttaque();
                            System.out.print("Il réussi et inflige ");
                        }
                        if(hero1 instanceof Guerrier){
                            degat = ((Guerrier)hero1).blesserGuerrier(degat);
                        }
                        else{
                            degat = hero1.blesser(degat);
                        }
                        System.out.println(degat+" dégats à "+hero1.getNomHero()+" !");
                        if(hero2 instanceof Assassin){
                            finir = ((Assassin)hero2).acheverAssassin(hero1.vie());
                            if(finir == true){
                                hero1.blesser(3);
                                System.out.println(hero2.getNomHero()+" attaque une deuxième fois et inflige 3 dégats à "+hero1.getNomHero()+" !");
                            }
                        }
                    }
                    System.out.println(hero1.getNomHero()+" a maintenant "+hero1.vie()+" points de vie !");
                    if(hero2 instanceof Mage){
                        soin = ((Mage)hero2).soignerMage();
                        if(soin < 0){
                            System.out.println(hero2.getNomHero()+" se soigne "+(-soin)+" points de vie !");
                            System.out.println(hero2.getNomHero()+" a maintenant "+hero2.vie()+" points de vie !");
                        }
                    }
                    tour = 0;
                    break;
            }
        }
    }
}
