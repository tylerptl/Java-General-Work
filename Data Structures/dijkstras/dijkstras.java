import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class dijkstras {
    private static final int NO_PARENT = -1;

    public Map<Integer, ArrayList<Integer>> getMultiMap() {
        return multiMap;
    }

    public static Map<Integer, ArrayList<Integer>> multiMap;
    ArrayList<Integer> temp ;
    ArrayList<Edge> edges;
    HashSet<Edge> edgeSet;
    int[][] matrix;
    int[] shortDistances;


    dijkstras(){

    }

    void dijkstra(int[][] matrix, int start) {
        this.matrix = matrix;
        int nVertices = matrix[0].length;
        multiMap = new HashMap<>();
        temp = new ArrayList<>();
        edges = new ArrayList();
        edgeSet = new HashSet<>();


        // shortestDistances[i] will be
        // shortest distance from src to i
        int[] shortestDistances = new int[nVertices];

        // added[i] will betrue if vertex i is
        // included or shortest distance from src to
        // i is finalized
        boolean[] added = new boolean[nVertices];

        //All distances = 0, added[] = false initially
        for (int vertexIndex = 0; vertexIndex < nVertices;
             vertexIndex++) {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        shortestDistances[start] = 0;

        //Store shortest paths
        int[] parents = new int[nVertices];

        //no parent for start node
        parents[start] = NO_PARENT;

        // Find shortest path
        for (int i = 1; i < nVertices; i++) {


            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++) {
                if (!added[vertexIndex] &&
                        shortestDistances[vertexIndex] <
                                shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }


            added[nearestVertex] = true;


            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++) {
                int edgeDistance = matrix[nearestVertex][vertexIndex];

                if (edgeDistance > 0
                        && ((shortestDistance + edgeDistance) <
                        shortestDistances[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance +
                            edgeDistance;
                }
            }
        }

        printSolution(start, shortestDistances, parents);
    }
    private void printSolution(int start, int[] distances, int[] parents) {
        shortDistances = distances;
        int nVertices = distances.length;
        System.out.print("Vertex\t Distance\tPath");

        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {


            if (vertexIndex != start) {
                System.out.print("\n" + start + " -> ");
                System.out.print(vertexIndex + " \t\t ");
                System.out.print(distances[vertexIndex] +"  " + "\t\t");

                printPath(vertexIndex, parents);
                fillEdges(vertexIndex, parents);
            }

            for(int i = 1; i < temp.size(); i++){
               fillEdgeArray(temp.get(i-1), temp.get(i));

               //System.out.println("creating edge: " + temp.get(i-1) + "-> " + temp.get(i));

           }
            temp.clear();
        }
        createDottedConnections();
    }
    private static void printPath(int currentVertex, int[] parents) {

        // Base case : Source node already processed
        if (currentVertex == NO_PARENT) {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }
    private void fillEdges(int index, int[] path){
        if(index == NO_PARENT){
            return;
        }
        fillEdges(path[index], path);
        temp.add(index);


    }
    void fillEdgeArray(int start, int stop){
        if(edges.isEmpty()){
            Edge temp = new Edge(start, stop);
            temp.isBold = true;
            temp.setConnectionType();
            edges.add(temp);
        }
        else{
            Edge temp = new Edge(start, stop);
            if(!edges.contains(temp)){
                temp.isBold = true;
                temp.setConnectionType();
                edges.add(temp);
            }else{
            }
        }
    }
    void printEdgeArray(){
        edgeSet = new HashSet(edges);
        for(Edge e : edgeSet){
            System.out.println(e.toString());
        }

    }
    public void createDottedConnections(){
        ArrayList<Edge> edgesTemp = new ArrayList<>(); // This will hold temp Edges that are created below to prevent duplicates
        for(int i = 0; i < matrix[0].length; i++){
            for(int j = 0 ; j < matrix[0].length; j++){
                if(matrix[i][j] != 0){
                    Edge temp = new Edge(i, j);
                    Edge reverseTemp = new Edge(j, i);

                   if(!edges.contains(temp) && !edges.contains(reverseTemp)){
                       if(!edgesTemp.contains(temp) && !edgesTemp.contains(reverseTemp)){
                          // System.out.println("Edge not found with : " + temp.start + " : " + temp.stop);
                           temp.isBold = false;
                           temp.setConnectionType();
                           edges.add(temp);
                           edgesTemp.add(temp);
                           edgesTemp.add(reverseTemp);

                       }
                   }
                }

            }
        }
    }
}
