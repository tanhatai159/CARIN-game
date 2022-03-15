package MainClass;

import Human.*;

public class Display {
    static int mostAmountOfChar = 7;

    public static void render(Body body){
        String word = "";
        char type ;
        int hostHP = 0, leftSpace;
        System.out.println("Time Unit: " + MainGame.getTimeUnit());
        System.out.println("Player credits: " + Player.getCredits());
        System.out.println("Antibody: " + Antibody.getAmountOfAntibody());
        System.out.println("Virus: " + Virus.getAmountOfVirus());

        for(int i = 0;i < Organ.getM();i++){
            for(int j = 0;j < body.getAllOrgan().size();j++){
                for(int k = 0;k < Organ.getN();k++){
                    StringBuilder sb = new StringBuilder();
                    leftSpace = mostAmountOfChar;
                    System.out.print("[");
                    if(body.getAllOrgan().get(j).getPosition()[i][k] != null){
                        hostHP =  body.getAllOrgan().get(j).coordinate(k,i).getHp();
                        type = Character.toUpperCase(body.getAllOrgan().get(j).coordinate(k,i).getType().charAt(0));
                        if(body.getAllOrgan().get(j).getPosition()[i][k] instanceof Antibody){
                            sb.append("A");
                        }
                        else{
                            sb.append("V");
                        }
                        sb.append(type);
                        sb.append(":");
                        sb.append(hostHP);
                        leftSpace = mostAmountOfChar - sb.toString().length();
                    }
                    for(int l = 0;l < leftSpace;l++){
                        sb.append(' ');
                    }
                    word = sb.toString();
                    System.out.print(word);
                    System.out.print("]");
                }
                System.out.print("          ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) throws Exception {
        ReadConfig.readConfig("config.txt");
        Body body = new Body(2);
        body.getAllOrgan().get(0).getPosition()[0][0] = new Antibody(body.getAllOrgan().get(0),0,0,0);
        body.getAllOrgan().get(0).getPosition()[1][1] = new Antibody(body.getAllOrgan().get(0),0,1,1);
        body.getAllOrgan().get(0).getPosition()[2][2] = new Virus(body.getAllOrgan().get(0),0,2,2,"Genetic_Code/Genetic_Code.txt",false);
        body.getAllOrgan().get(1).getPosition()[2][4] = new Virus(body.getAllOrgan().get(0),0,4,2,"Genetic_Code/Genetic_Code.txt",false);
        render(body);
        for(Cell cell : Body.getCellQueue()){
           cell.readGenetic_Code();
        }
        body.getAllOrgan().get(0).getPosition()[0][0].move("right");
        render(body);
  }
}
