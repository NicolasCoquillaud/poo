package com.mycompany.start;
import java.util.Scanner;

public class Start {
    public static void main (String [] args){
        Scanner keyboard = new Scanner(System.in);
        
        Heros[] playerList = new Heros[2];
        
        String getUserName = "";
        String getUserRace = "";
        int whileTest;
        
        System.out.println("\n\n\n\n\n\t\t\t>>> Class-Fight <<<");        
        for (int i=0; i<2; i++){
            int j = i+1;
            System.out.print("\nNom du joueur "+j+" : ");
            getUserName = keyboard.nextLine();
            whileTest = 0;
            while (whileTest == 0){
                System.out.println("\n\t1. Humain     2. Elfe     3. Nain");
                System.out.print("Race du joueur "+j+" : ");
                whileTest = keyboard.nextInt();
                switch(whileTest){
                    case 1:
                        getUserRace = "Humain"; 
                        break;
                    case 2:
                        getUserRace = "Elfe";
                        break;
                    case 3:
                        getUserRace = "Nain";
                        break;
                    default:
                        whileTest = 0;
                        break;
                }
            }
            whileTest = 0;
            Heros heroTemporaire = null; // objet vide
            while (whileTest == 0){
                System.out.println("\t1. Guerrier     2. Mage     3. Assassin");
                System.out.print("Role du joueur "+j+" : ");
                whileTest = keyboard.nextInt();
                switch(whileTest){
                    case 1:
                        heroTemporaire = new Guerrier(getUserName,getUserRace,2);
                        break;
                    case 2:
                        heroTemporaire = new Mage(getUserName,getUserRace);
                        break;
                    case 3:
                        heroTemporaire = new Assassin(getUserName,getUserRace);
                        break;
                    default:
                        whileTest = 0;
                        break;
                }
            }
            keyboard.nextLine();
                
            playerList[i] = heroTemporaire;
        }
        
        Combat.combattre(playerList[0], playerList[1]); //Go to "Combat" et "combattre"
    }
}