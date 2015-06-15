package pee.hellolistview.ui;

/**
 * Created by pvu_asus on 15/06/2015.
 */
public class WeatherData {
    protected String id;
    protected String city;
    protected String tempc;
    protected String tempf;
    protected String condition;
    protected String windSpeed;
    protected String icon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTempc() {
        return tempc;
    }

    public void setTempc(String tempc) {
        this.tempc = tempc;
    }

    public String getTempf() {
        return tempf;
    }

    public void setTempf(String tempf) {
        this.tempf = tempf;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", tempc='" + tempc + '\'' +
                ", tempf='" + tempf + '\'' +
                ", condition='" + condition + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
