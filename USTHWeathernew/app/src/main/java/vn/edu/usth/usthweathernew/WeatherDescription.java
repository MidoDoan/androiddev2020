package vn.edu.usth.usthweathernew;

public class WeatherDescription {
    private Integer[] imageArray = {
            R.drawable.bitcloudy,
            R.drawable.bitsnow,
            R.drawable.cloudy,
            R.drawable.cloudysunny,
            R.drawable.drizzle,
            R.drawable.heavyrain,
            R.drawable.partialsnow,
            R.drawable.rainy,
            R.drawable.snowy,
            R.drawable.storm,
            R.drawable.suncloud,
            R.drawable.sunny,
            R.drawable.thunder};

    private String weather[] = {
            "A bit cloudy",
            "A bit snow",
            "Cloudy",
            "Sunny and cloudy",
            "Drizzle",
            "Heavy rain",
            "Partial snow",
            "Rainy",
            "Shower snow",
            "Storm",
            "Sunny and a bit cloudy",
            "Sunny",
            "Thunder and lightning"
    };

    public Integer[] getImageArray() {
        return imageArray;
    }

    public String[] getWeather() {
        return weather;
    }

//    Random r = new Random();
//    int rInt = r.nextInt();

    public Integer getImageId(int rInt){
        return imageArray[rInt];
    }
    public String getWeather(int rInt){
        return weather[rInt];
    }

    public String getTemperatureRange (int rInt){
        String temp=(10 + rInt) + "\u00B0C" + " - " + (20 + rInt) + "\u00B0C";
        if (weather[rInt].contains("snow"))
            temp= "5\u00B0C - 7\u00B0C";
        return temp;
    }

    public String getTemperature(int rInt){
        String temp=(10 + rInt) + "\u00B0C";
        if (weather[rInt].contains("snow"))
            temp= "5\u00B0C";
        return temp;
    }
}
