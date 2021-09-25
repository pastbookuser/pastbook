package web.test.login;

import Base.Common;
import Base.SingletonBrowser;
import pastBookPo.AlbumPo;
import pastBookPo.LoginLogoutPo;
import lombok.extern.java.Log;
import org.testng.annotations.Test;

@Log
public class pastBookSignIn extends Common{

    public void SignIn()throws Exception{
            try {
                SingletonBrowser.getInstance().getDriver().get(getProperty("url"));
                LoginLogoutPo.getInstance().clickSignInMainMenu();
                LoginLogoutPo.getInstance().clickSignIn();
                String winHandleBefore = SingletonBrowser.getInstance().getDriver().getWindowHandle();
                for (String winHandle : SingletonBrowser.getInstance().getDriver().getWindowHandles()) {
                    SingletonBrowser.getInstance().getDriver().switchTo().window(winHandle);
                }
                LoginLogoutPo.getInstance().clickUseEmail();
                LoginLogoutPo.getInstance().enterUserName(getProperty("username"));
                LoginLogoutPo.getInstance().clickNextButton();
                Thread.sleep(5000);
                LoginLogoutPo.getInstance().enterPassword(getProperty("password"));
                Thread.sleep(3000);
                LoginLogoutPo.getInstance().clickNextButton();
                Thread.sleep(5000);
                SingletonBrowser.getInstance().getDriver().switchTo().window(winHandleBefore);
                Thread.sleep(5000);
            } catch (Exception e) {
                log.info("Failed : VerifyValidLogin ");
                throw e;
            }
        }

    @Test(testName = "verifyValidSignIn")
    public void verifyValidSignIn() throws Exception {
        try {
            SignIn();
            AlbumPo.getInstance().enterAlbumName("TestAlbum123");
            AlbumPo.getInstance().clickCreatePastBook();
            AlbumPo.getInstance().clickUploadYourPic();
            Thread.sleep(10000);
            AlbumPo.getInstance().clickSelectFileUpload();
            //TODO: wait till the image is uploaded without setting pre-defined timeout
            Thread.sleep(10000);
            AlbumPo.getInstance().clickUpload();
            Thread.sleep(20000);
            AlbumPo.getInstance().clickContinue();
            Thread.sleep(10000);
            userLogout();
            SignIn();
        } catch (Exception e) {
            log.info("Failed : VerifyValidLogin ");
            throw e;
        }
    }

    public void userLogout() throws Exception {
        try {
            LoginLogoutPo.getInstance().clickSignInMainMenu();
            LoginLogoutPo.getInstance().clickSignOut();
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            log.info("Failed : userLogout ");
            throw e;
        }
    }
}
