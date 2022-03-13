package Human;

public class GeneticCode {
    static String[] allGeneticPath = {"Genetic_Code/Genetic_Code.txt","Genetic_Code/Genetic_Code2.txt", "Genetic_Code/Genetic_Code5.txt","Genetic_Code/Genetic_Code6.txt","Genetic_Code/Genetic_Code7.txt"};
    static String[] antibodyGeneticPath = {"Genetic_Code/forAntibody/Genetic_Code_antibody.txt"};
    static String[] virusGeneticPath = {"Genetic_Code/forVirus/Genetic_Code_virus.txt"};
    static int amountOfGeneticPath, amountOfAntibodyGeneticPath = antibodyGeneticPath.length, amountOfVirusGeneticPath = virusGeneticPath.length;
    public static int getAmountOfGeneticPath(){
        return amountOfGeneticPath = allGeneticPath.length;
    }

    public static int getAmountOfAntibodyGeneticPath(){
        return antibodyGeneticPath.length;
    }

    public static int getAmountOfVirusGeneticPath(){
        return virusGeneticPath.length;
    }

    public static String getAntibodyGeneticPath(int index){
        return antibodyGeneticPath[index];
    }

    public static String getVirusGeneticPath(int index){
        return virusGeneticPath[index];
    }

    public static String[] getAllGeneticPath(){
        return allGeneticPath;
    }
}
