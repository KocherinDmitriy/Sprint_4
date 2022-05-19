import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;


public class СreatСardPositiveTest {
    @DisplayName("Positive tests to CardHolder") // имя теста
    @Description("Correct CardHolder name") // описание теста
    @Test
    public void CreateCard() {
        Account account = new Account("Some Name");
        Assert.assertEquals(account.checkNameToEmboss(),true);
    }
}
