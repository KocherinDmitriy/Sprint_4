import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CreateCardNegativeTest {

    private final String name;
    private final boolean answer;

    public CreateCardNegativeTest(String name, boolean answer) {
        this.name = name;
        this.answer = answer;
    }

    @Parameterized.Parameters (name = "{index} => name={0}, answer={1}") // добавили аннотацию
    public static Object[][] getData() {
        return new Object[][]{
                {"",false}, //Empty
                {"QW",false},//<2
                {"QWQWWQQQQQQQQQQQQQQ",false},//>18
                {"WWQQ QQQQQQ QQQQ",false},//>2 SPACE
                {" QWQWWQQQQQ",false},//Start with SPACE
                {"QWQWWQQQQQ ",false},//END with SPACE

        };
    }

    @DisplayName("Negative tests to CardHolder") // имя теста
    @Description("Empty, <2,>18, >2 SPACE,Start with SPACE,END with SPACE") // описание теста
    @Test
    public void CreateCardNegativeTest() {
        Account account = new Account(name);
        Assert.assertEquals(account.checkNameToEmboss(),answer);
    }
}

