public class Cell {
    int Atk;
    int m,n;
    Cell[][] position = new Cell[100][100];
    public Cell coor(int x, int y){
        return position[x][y];
    }
}
