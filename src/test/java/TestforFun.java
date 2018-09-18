import org.junit.Test;

/**
 * Created by 011291 on 2018/9/17.
 */
public class TestforFun {

    @Test
    public void testforfun(){
        String target = "12";
        String[] array = target.split(" ");
        for(String entry : array){
            System.out.printf("[%s]-[%d]\n", entry, entry.length());
        }

    }
}
