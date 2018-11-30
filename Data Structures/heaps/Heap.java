public class Heap {
    private double[] data;
    private int capacity;
    private int n = 0;
    int x;


    Heap(int capacity){
        data = new double[capacity];
    }
    void insert(double val){
        data[n] = val;
        x = n;
        n++;
        while(x>0 && data[x] > data[parent(x)]){
            swap(data[x], data[parent(x)]);
            x = parent(x);
        }
    }
    void swap(double x, double y){

    }
    void heapify(int x){
        if(data[left(x)] > data[x]){
            swap(data[x], data[left(x)]);
            heapify(left(x));
        }else if(data[(right(x))] != 0 && (data[right(x)] > data[x])){
            swap(data[x],data[right(x)]);
            heapify(right(x));
        }

    }

    void delete(){

    }
    int parent(int x){
        return (x-1)/2;
    }

    int left(int x){
        return (2*x+1);
    }
    int right(int x){
        return (2*x+2);
    }

}
