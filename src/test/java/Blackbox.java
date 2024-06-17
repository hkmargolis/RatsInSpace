import org.junit.Assert;
import org.junit.Test;

public class Blackbox {

    @Test
    public void simpleAddTest() {
        int num1 = 1;
        int num2 = 2;
        int response = Main.simpleAdd(num1,num2);
        Assert.assertEquals(3, response);
    }
}
