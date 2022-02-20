package MainClass;

import Human.*;

public class Display {

    public static void render(Body body){
        System.out.println("Time Unit: " + MainGame.getTimeUnit());
        System.out.println("Player credits: " + Player.getCredits());
        System.out.println("Antibody: " + Antibody.getAmountOfAntibody());
        System.out.println("Virus: " + Virus.getAmountOfVirus());

        for(int i = 0;i < Organ.getM();i++){
            for(int j = 0;j < body.getAllOrgan().size();j++){
                for(int k = 0;k < Organ.getN();k++){
                    System.out.print("[ ");
                    if(body.getAllOrgan().get(j).getPosition()[i][k] != null){
                        if(body.getAllOrgan().get(j).getPosition()[i][k] instanceof Antibody){
                            System.out.print("A");
                        }
                        else{
                            System.out.print("V");
                        }
                    }
                    else {
                        System.out.print(" ");
                    }
                    System.out.print(" ]");
                }
                System.out.print("     ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) throws Exception {
        ReadConfig.readConfig("config.txt");
        Body body = new Body(2);
        body.getAllOrgan().get(0).getPosition()[0][0] = new Antibody(body.getAllOrgan().get(0),0,0,0);
        body.getAllOrgan().get(0).getPosition()[1][1] = new Antibody(body.getAllOrgan().get(0),0,1,1);
        body.getAllOrgan().get(0).getPosition()[2][2] = new Virus(body.getAllOrgan().get(0),0,2,2,"Genetic_Code/Genetic_Code.txt");
        body.getAllOrgan().get(1).getPosition()[2][4] = new Virus(body.getAllOrgan().get(0),0,4,2,"Genetic_Code/Genetic_Code.txt");
        render(body);
        for(Cell cell : Body.getCellQueue()){
            cell.readGenetic_Code();
        }
//        body.getAllOrgan().get(0).getPosition()[0][0].move("right");
        render(body);
    }
}
