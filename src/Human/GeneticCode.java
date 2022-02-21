package Human;

public class GeneticCode {
    static String[] allGeneticPath = {"Genetic_Code/Genetic_Code.txt","Genetic_Code/Genetic_Code2.txt", "Genetic_Code/Genetic_Code5.txt","Genetic_Code/Genetic_Code6.txt","Genetic_Code/Genetic_Code7.txt"};
    static int amountOfGeneticPath;
    public static int getAmountOfGeneticPath(){
        return amountOfGeneticPath = allGeneticPath.length;
    }
}
