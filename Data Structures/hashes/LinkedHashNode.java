public class LinkedHashNode {
    private String  value;
    private String key;
    private LinkedHashNode next;

    LinkedHashNode(String key, String value){
        this.key = key;
        this.value = value;
        this.next = null;

    }

    public String getValue(){
        return value;
    }
    public void setValue(String value){
        this.value = value;
    }
    public String getKey(){
        return key;
    }
    public void setKey(String key){
        this.key = key;
    }
    public LinkedHashNode getNext(){
        return next;
    }
    public void setNext(LinkedHashNode next){
        this.next = next;
    }

}
