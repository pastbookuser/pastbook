package pastBookPo;

import Base.BasePO;
import Base.Log;
import Base.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class AlbumPo extends BasePO {

    private static AlbumPo albumPo;
    private SingletonBrowser singleton = SingletonBrowser.getInstance();

    private AlbumPo() {
        super();
    }

    public static final AlbumPo getInstance() {
        if (albumPo == null) {
            albumPo = new AlbumPo();
        }
        return albumPo;
    }

    public void enterAlbumName(String albumName) throws Exception {
        WebElement enterAlbumName = singleton.getDriver().findElement(By.xpath("//body/div[6]/div[6]/div[1]/div[2]/div[1]/form[1]/section[1]/div[1]/div[1]/input[1]"));
        try {
            Log.info("## AlbumPo | enterAlbumName() ## " + this.getClass().getName());
            if (albumName.trim().length() != 0) {
                uiSendKeys(enterAlbumName, albumName);
            }
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : enterAlbumName()" + e.getLocalizedMessage());
        }
    }

    public void clickCreatePastBook() throws Exception {
        WebElement createPastBook = singleton.getDriver().findElement(By.xpath("//button[@id='create-button']"));
        try {
            Log.info("## AlbumPo | clickCreatePastBook() ## " + this.getClass().getName());
            uiClick(createPastBook);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : clickCreatePastBook()" + e.getLocalizedMessage());
        }
    }

    public void clickUploadYourPic() throws Exception {
        WebElement uploadYourPic = singleton.getDriver().findElement(By.xpath("//a[contains(text(),'Upload your pictures')]"));
        try {
            Log.info("## AlbumPo | clickUploadYourPic() ## " + this.getClass().getName());
            uiClick(uploadYourPic);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : clickUploadYourPic()" + e.getLocalizedMessage());
        }
    }

    public void clickSelectFileUpload() throws Exception {
        WebElement selectFileUpload = singleton.getDriver().findElement(By.xpath(" //input[@id='fsp-fileUpload']"));
        try {
            Log.info("## AlbumPo | clickSelectFileUpload() ## " + this.getClass().getName());
            selectFileUpload.sendKeys("C:\\Users\\Vijini\\Pictures\\image.jpg");
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : clickSelectFileUpload()" + e.getLocalizedMessage());
        }
    }

    public void clickUpload() throws Exception {
        WebElement clickUpload = singleton.getDriver().findElement(By.xpath("//body/div[@id='__filestack-picker']/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/span[3]/div[1]/span[2]"));
        try {
            Log.info("## AlbumPo | clickUpload() ## " + this.getClass().getName());
            uiClick(clickUpload);
            Thread.sleep(1000);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : clickUpload()" + e.getLocalizedMessage());
        }
    }

    public void clickContinue() throws Exception {
        WebElement clickContinue = singleton.getDriver().findElement(By.xpath("//body/div[10]/div[1]/div[1]/div[3]/button[2]/b[1]"));
        try {
            Log.info("## AlbumPo | clickContinue() ## " + this.getClass().getName());
            uiClick(clickContinue);
            Thread.sleep(1000);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : clickContinue()" + e.getLocalizedMessage());
        }
    }
}
