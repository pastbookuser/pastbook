package Base;

import org.openqa.selenium.*;

public class BasePO {
    public static uiRunnable Sleep = new uiRunnable() {
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    //This method can use to click event
    public void uiClick(WebElement uiElement) {
        String[] element;
        element = uiElement.toString().split("->");
        try {
            if (uiIsDisplayed(uiElement) == true) {
                System.out.println(element[1]+"success");
                uiElement.click();
            }
            else
                System.out.println(element[1]+"fail");
        } catch (Exception e) {
            System.out.println("unable to click ---------- "+e);
        }

    }

    //This method use to enter text on field
    public void uiSendKeys(WebElement uiElement, String value) throws uiDriverException {
        try{
            uiElement.clear();
            uiElement.sendKeys(value);
        }
        catch(Exception e){
            System.out.println("Unable to send keys"+e);
        }

    }

    //This method use to verify UI element display or not
    public Boolean uiIsDisplayed(WebElement uiElement){
        int i = 0;
        SingletonBrowser.getInstance();
        while (i < 8) {
            if (uiElement.isDisplayed() == true) {
                return true;
            } else {
                Sleep.run();
            }
            i++;
        }
        if (i == 5) {
            Log.error("not display,timed out" + uiElement);
        }
        return false;
    }

    public class uiDriverException extends Exception
    {
        private String message = null;
        public String getMessage() {
            return message;
        }
      }

    public interface uiRunnable extends Runnable {
    }

}
