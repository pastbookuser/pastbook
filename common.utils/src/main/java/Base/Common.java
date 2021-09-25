package Base;

public class Common {
    private String value = null;

    //Common method for get the properties from the property file as text
    public String getProperty(String text) {
        try {
            value = SingletonBrowser.getInstance().getProp().getProperty(text);
            System.out.println("Get Property As " + value);
        } catch (Exception e) {
            System.out.println("Unable to  get Text :" + e.toString());
        }
        return value;
    }


}
