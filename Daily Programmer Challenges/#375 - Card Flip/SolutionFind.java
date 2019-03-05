public class SolutionFind {
    private String[] getArr() {
        return arr;
    }

    private void setArr(String[] arr) {
        this.arr = arr;
    }

    private String[] arr;
    private int length;

    SolutionFind(String[] arr){
        setArr(arr);

    }



    protected void findSolutions(){
        for(String s: getArr()){
            var sb = new StringBuilder(s);
            length = sb.length();
            for(int i = 0; i < length; i++){
                sb = checkCard(sb);
                System.out.println(sb.toString());
            }
        }
    }

    private StringBuilder checkCard(StringBuilder s){
        int left, right;
        StringBuilder input = new StringBuilder(s);
        for(int i = 0; i < input.length(); i++){
            left = i - 1;
            right = i + 1;
            if(input.charAt(i) == '1'){
                input.setCharAt(i, '.'); // Remove card
                if(i != 0){
                    input.setCharAt(left, flipNeighbor(input.charAt(left)));    //Flip left neighbor
                }if(i != input.length()-1){
                    input.setCharAt(right, flipNeighbor(input.charAt(right)));   //Flip right neighbor
                }
                break;
            }
        }
        return input;
    }
    private char flipNeighbor(char c){
        if(c == '1'){
            c = '0';
        }else if(c == '0'){
            c = '1';
        }
        return c;
    }
}
