import java.util.ArrayList;
import java.util.stream.LongStream;

public class Calendar {
    int tracker;
    //private long[] leapYears;
    private final long ARRAYSIZE;
    long start, end;
    ArrayList<Long> validYears;

    Calendar(long start, long end){
        tracker = 0;
        setStart(start);
        setEnd(end);
        this.end = end;
        ARRAYSIZE = (end - start)/4;    //Maximum possible leaps
        //leapYears = new long[ARRAYSIZE];
        validYears = new ArrayList<>();
    }

    void iterateYears(){
        LongStream.range(start/4, end/4).map(i -> i*4).forEach(this::checkYear);

    }

    void checkYear(long year){
        if(year % 100 == 0){
            if(year % 900 == 200 || year % 900 == 600){
                validYears.add(year);
                //leapYears[tracker] = year;
                tracker++;
            }
        }else{
            validYears.add(year);
            //leapYears[tracker] = year;
            tracker++;
        }

    }

    /**
     * This method will find the first year in the range divisible by 4. W/O doing so the stream
     * in iterateYears() can skip the last potential leap year.
     * @param n
     */
    public void setStart(long n){
        for(long i = n; i < n+4; i++){
            if(i % 4 == 0){
                start = i;
                System.out.println("First divisible year found :  " + i);
                }

            }
        }

    /**
     * This method will find the last year in the range divisible by 4. W/O doing so the stream
     * in iterateYears() can skip the last potential leap year.
      * @param n
     */
    public void setEnd(long n){
        for(long i = n; i > n-4; i--){
            if(i % 4 == 0){
                end = i;
                System.out.println("Last divisible year found :  " + i);
            }

        }

    }

    public void displayStats(){
        System.out.println("Number of leap years: " + validYears.size());
    }

    }






