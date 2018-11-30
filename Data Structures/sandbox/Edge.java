import java.util.Objects;

public class Edge {
    int start;
    int stop;
    String connectionType;
    boolean isBold;
    int distance;

    Edge(int start, int stop){
        isBold = false;
        this.start = start;
        this.stop = stop;
    }

    public void setConnectionType() {
        if(this.isBold){
            connectionType = "bold";
        }
        else{
            connectionType = "dotted";
        }
    }

    public String toString(){
        return ("Start: " +start + ", End: " + stop + ", Connection: " + connectionType + ", Distance: " + distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return start == edge.start &&
                stop == edge.stop;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, stop);
    }
    public void setDistance(int distance){
        this.distance = distance;
    }
}
