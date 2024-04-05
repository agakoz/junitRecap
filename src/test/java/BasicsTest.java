import org.example.Basics;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class BasicsTest {

    @Test
    @DisplayName("First number is more than the second")
    public void compare1() {
        Basics basicTests = new Basics();
        int actualValue = basicTests.compare(2,1);
        Assertions.assertEquals(1, actualValue);
    }

    @Test
    @DisplayName("First number is less than the second")
    public void compare2() {
        Basics basicTests = new Basics();
        int actualValue = basicTests.compare(1,2);
        Assertions.assertEquals(-1, actualValue);
    }

    @Test
    @DisplayName("First number is equal to the second")
    public void compare3() {
        Basics basicTests = new Basics();
        int actualValue  = basicTests.compare(2,2);
        Assertions.assertEquals(0,actualValue);
    }

    @Test
    @DisplayName("Array sorted")
    public void sortArray() {
        Basics basicTests = new Basics();
        int[] array = {5, 8, 3, 9, 1, 6};
        basicTests.sortArray(array);
        Assertions.assertArrayEquals(new int[]{1, 3, 5, 6, 8, 9}, array);
    }
}
