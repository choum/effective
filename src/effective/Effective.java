/*
    Remmember to check for these errors.
 */
package effective;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Heather Tran
public class Effective {
    public static void main(String[] args) {

        //Create an array with all types
        String[] types = {"fire", "water", "normal", "poison", "psychic", "grass", "ground", "ice", "rock", "dragon", "dark", "fighting", "ghost", "steel", "flying", "fairy", "bug", "electric", "steel"};
        ArrayList<String> type = new ArrayList<>();
        type.addAll(Arrays.asList(types));
        getInput(type);
       
    }
    public static void getInput (ArrayList<String> type) {
        //Get input
        boolean x = true;
        while (x) {
            System.out.println("Insert types below. Example: fire -> ice");
            Scanner keyboard = new Scanner(System.in);
            String input = keyboard.nextLine();   
            
            if (input.isEmpty()) {
                System.out.println("Please enter something into the console.");
            } 
            else if (!input.contains(" -> ")) {
                System.out.println("Please use the proper syntax.");
            }
            else {
                ArrayList<String> parts = Delimiter(input);
                if (type.contains(parts.get(0)) && type.contains(parts.get(1))) {
                    System.out.println("You chose " + parts.get(0) + " versus " + parts.get(1) + ".");
                    String answer = Effect(parts);
                    System.out.println(answer);
                    System.out.println("Would you like to continue? (Y/N)");
                    String quit = keyboard.nextLine();
                    if (quit.equalsIgnoreCase("Y")) {
                    } else if (quit.equalsIgnoreCase("N")) {
                        x = false;
                    } else {
                        System.out.println("Please type a valid answer");
                        System.out.println("Would you like to continue? (Y/N)");
                        quit = keyboard.nextLine();
                    }
                } 
                else {
                    System.out.println("Please enter the proper types.");
                }
            }
        }
    }
    public static ArrayList<String> Delimiter(String x) {
        //This method will take the string taken in the main method and split it into an arraylist
        ArrayList<String> parts = new ArrayList<>(Arrays.asList(x.split(" -> ")));
        return parts;
    }
    public static String Effect(ArrayList<String> y) {
        //This method will take a look at both outpus in a 
        String a = "The multiplier is 0.5x.";
        String b = "The multiplier is 1x";
        String c = "The multiplier is 2x";
        String d = "The multiplier is 0";
        String e = "This is an error message";        
        
        if (y.get(0).equalsIgnoreCase("fire")) {
            if (y.get(1).equalsIgnoreCase("bug") || y.get(1).equalsIgnoreCase("grass") || y.get(1).equalsIgnoreCase("ice") || y.get(1).equalsIgnoreCase("steel"))  { 
                return c;
            } else if (y.get(1).equalsIgnoreCase("dragon") || y.get(1).equalsIgnoreCase("fire") || y.get(1).equalsIgnoreCase("rock") || y.get(1).equalsIgnoreCase("water") ) {
                return a;
            } else {
                return b;
            }
        } else if (y.get(0).equalsIgnoreCase("bug")) {
            if (y.get(1).equalsIgnoreCase("grass") || y.get(1).equalsIgnoreCase("dark") || y.get(1).equalsIgnoreCase("psychic")) {
                return c;
            } else if (y.get(1).equalsIgnoreCase("fighting") || y.get(1).equalsIgnoreCase("fire") || y.get(1).equalsIgnoreCase("ghost") || y.get(1).equalsIgnoreCase("flying") || y.get(1).equalsIgnoreCase("poison") || y.get(1).equalsIgnoreCase("steel") || y.get(1).equalsIgnoreCase("fairy")) {
                return a;
            } else {
                return b;
            }
        } else if (y.get(0).equalsIgnoreCase("dark")) {
            if (y.get(1).equalsIgnoreCase("ghost") || y.get(1).equalsIgnoreCase("psychic")) {
                return c;
            } else if (y.get(1).equalsIgnoreCase("dark") || y.get(1).equalsIgnoreCase("fighting") || y.get(1).equalsIgnoreCase("fairy") ) {
                return a;
            } else {
                return b;
            }
        } else if (y.get(0).equalsIgnoreCase("dragon")) {
            if (y.get(1).equalsIgnoreCase("fairy")) {
                return d;
            } else if (y.get(1).equalsIgnoreCase("steel")) {
                return a;
            } else if (y.get(1).equalsIgnoreCase("dragon")) {
               return c;
            }
        } else if (y.get(0).equalsIgnoreCase("electric")) {
            if (y.get(1).equalsIgnoreCase("flying") || y.get(1).equalsIgnoreCase("water")) {
                return c;
            } else if (y.get(1).equalsIgnoreCase("dragon") || y.get(1).equalsIgnoreCase("electric") || y.get(1).equalsIgnoreCase("grass")) {
                return a;
            } else if (y.get(1).equalsIgnoreCase("ground")) {
                return d;
            } else { 
                return b;
            }
        } else if (y.get(0).equalsIgnoreCase("fairy")) {
            if (y.get(1).equalsIgnoreCase("dragon") || y.get(1).equalsIgnoreCase("dark") || y.get(1).equalsIgnoreCase("fighting")) {
                return c;
            } else if (y.get(1).equalsIgnoreCase("fire") || y.get(1).equalsIgnoreCase("poison") || y.get(1).equalsIgnoreCase("steel")) {
                return a;
            } else {
                return b;
            }
        }   else if (y.get(0).equalsIgnoreCase("fighting")) {
                if (y.get(1).equalsIgnoreCase("dark") || y.get(1).equalsIgnoreCase("ice") || y.get(1).equalsIgnoreCase("normal") || y.get(1).equalsIgnoreCase("rock") || y.get(1).equalsIgnoreCase("steel")) {
                    return c;
                } else if (y.get(1).equalsIgnoreCase("bug") || y.get(1).equalsIgnoreCase("fairy") || y.get(1).equalsIgnoreCase("flying") || y.get(1).equalsIgnoreCase("poison") || y.get(1).equalsIgnoreCase("psychic")) {
                    return a;
                } else if (y.get(1).equalsIgnoreCase("ghost")) {
                    return d;
                } else {
                    return b;
                }
        }   else if (y.get(0).equalsIgnoreCase("flying")) {
                if (y.get(1).equalsIgnoreCase("bug") || y.get(1).equalsIgnoreCase("grass") || y.get(1).equalsIgnoreCase("fighting")) { 
                    return c;
            }   else if (y.get(1).equalsIgnoreCase("electric") || y.get(1).equalsIgnoreCase("rock") || y.get(1).equalsIgnoreCase("steel")) {
                    return a;
            }   else if (y.get(1).equalsIgnoreCase("ground")) {
                    return d;
            }   else {
                    return b;
            }
        }   else if (y.get(0).equalsIgnoreCase("ghost")){
                
        }
        return e;
    }
}
