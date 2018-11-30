import java.io.*;

public class Container {
    BufferedReader br = new BufferedReader(new FileReader("ds_homework\\data\\network1.txt"));
    BufferedWriter writer = new BufferedWriter(new FileWriter("inputfile2.dot"));
    int[][] matrix;
    int count = 0;
    dijkstras d = new dijkstras();
    int numRouters, sourceRouter;
    Container() throws IOException {

    }

    void readFile() throws IOException {

        String temp;
        String[] tempArray;
        temp = br.readLine();
        tempArray = temp.split(" ");
        int[] connections;

        numRouters = Integer.parseInt(tempArray[0]);
        sourceRouter = Integer.parseInt(tempArray[1]);
        matrix = new int[numRouters][numRouters];
        while ((temp = br.readLine()) != null) {
            String[] strArr = temp.split(" +");
            connections = new int[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                connections[i] = Integer.parseInt(strArr[i]);
                matrix[count][i] = connections[i];
                //System.out.println(connections[i]);
            }
//            for(int n : connections){
//                System.out.print(n + ", ");
//            }
//            System.out.println("\n");

            //dijkstra(matrix, sourceRouter);
            count++;
        }
        for(int i = 0; i < matrix[0].length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + ", ");

            }
            System.out.println("\n");
        }
    }
    void runDijkstra(){

        d.dijkstra(matrix, sourceRouter);
    }

    void generateOutputFile() throws IOException {
        writer.write("graph solution {\n" +
                "  node [shape=\"circle\", fontsize=\"6\", width=\"0.6\", fixedsize=\"true\"];\n");
        for(int i = 0; i < matrix[0].length; i++){
            if(i == sourceRouter){
                writer.write("R" + i + "[label=\"R0\\n0 ms\", shape=\"doublecircle\"]; \n");
            }
            else{
                writer.write("R" + i + "[label=\"R"+i+"\\n"+d.shortDistances[i]+" ms\"]; \n");
            }
        }
        for(Edge e : d.edgeSet){
            writer.write("R"+e.start+"--R"+e.stop+" [style=\""+e.connectionType+"\"];\n");
        }
        writer.write("}");
        writer.close();

    }
}
