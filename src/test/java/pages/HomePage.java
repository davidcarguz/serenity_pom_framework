package pages;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageObject {

    @FindBy(how = How.CSS, using = "span[class='title']")
    WebElement lbl_products;

    @FindBy(how = How.CSS, using = "div[class = 'error-message-container error'] h3")
    WebElement lbl_error;

    public HomePage() {
        PageFactory.initElements(getDriver(),this);
    }


    public void validarHomePage() {
        Assert.assertEquals("products",lbl_products.getText().toLowerCase());
    }

    public void validarErrorMessage(String errorMessage) {
        Assert.assertEquals(errorMessage,lbl_error.getText());
    }
}
