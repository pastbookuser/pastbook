package pastBookPo;

import Base.BasePO;
import Base.Log;
import Base.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginLogoutPo extends BasePO {
    private static LoginLogoutPo loginPo;
    private SingletonBrowser singleton = SingletonBrowser.getInstance();

    private LoginLogoutPo() {
        super();
    }

    public static final LoginLogoutPo getInstance() {
        if (loginPo == null) {
            loginPo = new LoginLogoutPo();
        }
        return loginPo;
    }

    public void clickSignInMainMenu() throws Exception {
        WebElement btn_mainMenu = singleton.getDriver().findElement(By.xpath("//header/ul[1]/li[1]/a[1]"));
        try {
            Log.info("##LoginPo | clickSignInMainMenu() ## " + this.getClass().getName());
            uiClick(btn_mainMenu);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : clickSignInMainMenu()" + e.getLocalizedMessage());
        }
    }

    public void clickSignIn() throws Exception {
        WebElement uiSignIn = singleton.getDriver().findElement(By.xpath("//a[contains(text(),'Sign in')]"));
        try {
            Log.info("## LoginPo | clickSignIn() ## " + this.getClass().getName());
            uiClick(uiSignIn);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : clickSignIn()" + e.getLocalizedMessage());
        }
    }

    public void clickUseEmail() throws Exception {
        WebElement uiSignIn = singleton.getDriver().findElement(By.xpath("//a[contains(text(),'or use email »')]"));
        try {
            Log.info("## LoginPo | clickUseEmail() ## " + this.getClass().getName());
            uiClick(uiSignIn);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : clickUseEmail()" + e.getLocalizedMessage());
        }
    }

    public void enterUserName(String username) throws Exception {
        WebElement uiUsername = singleton.getDriver().findElement(By.xpath("//input"));
        try {
            Log.info("## LoginPo | enterUserName() ## " + this.getClass().getName());
            if (username.trim().length() != 0) {
                uiSendKeys(uiUsername, username);
            }
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : enterUserName()" + e.getLocalizedMessage());
        }
    }

    public void clickNextButton() throws Exception {
        WebElement nextButton = singleton.getDriver().findElement(By.xpath("//body/div[6]/div[1]/div[1]/div[2]/form[1]/div[2]/span[1]/button[1]"));
        try {
            Log.info("## LoginPo | clickNextButton() ## " + this.getClass().getName());
            uiClick(nextButton);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : clickNextButton()" + e.getLocalizedMessage());
        }
    }

    public void enterPassword(String password) throws Exception {
        WebElement uiPassword = singleton.getDriver().findElement(By.xpath("//body/div[6]/div[1]/div[1]/div[2]/form[1]/div[2]/input[2]"));
        try {
            Log.info("## LoginPo | enterPassword() ## " + this.getClass().getName());
            if (password.trim().length() != 0) {
                uiSendKeys(uiPassword, password);
            }
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : enterPassword()" + e.getLocalizedMessage());
        }
    }

    public void clickSignOut() throws Exception {
        WebElement clickSignOut = singleton.getDriver().findElement(By.xpath("//a[contains(text(),'Sign out')]"));
        try {
            Log.info("## LogoutPo | clickSignOut() ## " + this.getClass().getName());
            uiClick(clickSignOut);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : clickSignOut()" + e.getLocalizedMessage());
        }
    }


}
