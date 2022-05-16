import java.util.*;
public class HashmapTester {
    public static HashMap <String, Integer> boardCoord = new HashMap<>();

    public void fill()
    {
        /*
        int i = 8;
        while(i > 0)
        {
            boardCoord.put("a",i);
            i--;
        }

         */
        boardCoord.put("a",1);
    }

    public static void main(String[] args) {
        HashmapTester h = new HashmapTester();
        h.fill();
        for (String i : boardCoord.keySet()) {
            System.out.println(i);
        }
        System.out.println();
        for (int i : boardCoord.values()) {
            System.out.println(i);
        }
    }
}
