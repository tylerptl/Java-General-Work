import java.io.IOException;

public class Driver {
    public static void main(String ... args) throws IOException {
       Container container = new Container();
       container.readFile();
       container.runDijkstra();
       container.d.printEdgeArray();
       container.generateOutputFile();

    }


}
