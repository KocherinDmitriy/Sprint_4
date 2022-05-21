import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CreateCardTest {

    private final String name;
    private final boolean answer;


    public CreateCardTest(String name, boolean answer) {
        this.name = name;
        this.answer = answer;


    }

    @Parameterized.Parameters (name = "{index} => name={0}, answer={1}") // добавили аннотацию
    public static Object[][] getData() {
        return new Object[][]{
                {"Name Name",true}, //AllСonditionsSuccessful
                {"N 3",true}, //BoundaryValues BottomLine 3 Symbols
                {"QW 4",true},//BoundaryValues BottomLine 4 Symbols
                {"Q2",false},//BoundaryValues BottomLine 2 Symbols
                {"",false}, //Empty
                {"QWQWWQQQQQQQQQQQ18",true},//BoundaryValues UpperBound =18
                {"QWQWWQQQQQQQQQQQQ19",true},//BoundaryValues UpperBound =19
                {"WQWWQQQQQQQQQQQQQQ20",false},//BoundaryValues UpperBound =20
                {"WWQQ QQQQQQ QQQQ",false},//>2 SPACE
                {" QWQWWQQQQQ",false},//Start with SPACE
                {"QWQWWQQQQQ ",false},//END with SPACE

        };
    }

    @DisplayName("Tests to CardHolder") // имя теста
    @Description("Empty, <2,>18, >2 SPACE,Start with SPACE,END with SPACE") // описание теста
    @Test
    public void CreateCardNegativeTest() {
        Account account = new Account(name);
        Assert.assertEquals(account.checkNameToEmboss(),answer);
    }
}

