import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color.*;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class WeatherApp extends Application {
    
    //Instance Variables
    private final String API_KEY = "577e43e5886c0a4988562b64568df4a9"; //generated OpenWeatherMap API key
    private TextField locationInput;
    private Label temperatureLabel, humidityLabel, windSpeedLabel, forecastLabel;
    private ImageView weatherIcon;
    private ListView<String> historyList;
    private List<String> searchHistory = new ArrayList<>();
    private ToggleGroup unitToggle;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        //GUI Initialization
        locationInput = new TextField();
        locationInput.setPromptText("Type your location");
        Button searchButton = new Button("Get Weather");

        temperatureLabel = new Label("Temperature: ");
        humidityLabel = new Label("Humidity: ");
        windSpeedLabel = new Label("Wind Speed: ");
        forecastLabel = new Label("Forecast: ");
        weatherIcon = new ImageView();
        historyList = new ListView<>();
        historyList.setPrefHeight(100);

        unitToggle = new ToggleGroup();
        RadioButton celsiusButton = new RadioButton("Celsius");
        RadioButton fahrenheitButton = new RadioButton("Fahrenheit");
        celsiusButton.setToggleGroup(unitToggle);
        fahrenheitButton.setToggleGroup(unitToggle);
        celsiusButton.setSelected(true);

        searchButton.setOnAction(e -> {
            if (!locationInput.getText().trim().isEmpty()) {
                searchButton.setDisable(true);
                fetchWeatherData();
                searchButton.setDisable(false);
            } else {
                showError("You must enter a location; it cannot be empty.");
            }
        });

        // Grouping location input and search button in an HBox
        HBox searchBox = new HBox(10, locationInput, searchButton);
        searchBox.setPadding(new Insets(10));

        // Grouping weather information in a VBox
        VBox weatherInfoBox = new VBox(10, temperatureLabel, humidityLabel, windSpeedLabel, weatherIcon, forecastLabel);
        weatherInfoBox.setPadding(new Insets(10));

        // Unit toggle and wind speed options in a separate VBox
        VBox unitBox = new VBox(10, new Label("Select Unit:"), celsiusButton, fahrenheitButton);
        unitBox.setPadding(new Insets(10));

        // Set up the root layout using BorderPane
        BorderPane root = new BorderPane();
        root.setTop(searchBox);
        root.setCenter(weatherInfoBox);
        root.setRight(unitBox);
        root.setBottom(historyList);
        BorderPane.setMargin(historyList, new Insets(10));

        Scene scene = new Scene(root, 400, 600);
        applyDynamicBackground(scene);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Weather Information App");
        primaryStage.show();
    }

    private void fetchWeatherData() {
        String location = locationInput.getText();
        boolean isCelsius = unitToggle.getSelectedToggle().equals(unitToggle.getToggles().get(0));
        String unit = isCelsius ? "metric" : "imperial";
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + location + "&units=" + unit + "&appid=" + API_KEY;

        HttpURLConnection connection = null;
        BufferedReader in = null;
     
        try {
            URI uri = new URI(urlString);
            connection = (HttpURLConnection) uri.toURL().openConnection(); // Convert URI to URL
            connection.setRequestMethod("GET");

            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            parseWeatherData(response.toString());

            searchHistory.add(location + " - " + new java.util.Date());
            historyList.getItems().setAll(searchHistory);

        } catch (URISyntaxException e) {
            showError("Error in URL syntax: " + e.getMessage());
        } catch (Exception e) {
            showError("Error fetching weather data: " + e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (connection != null) {
                    connection.disconnect();
                }
            } catch (Exception ex) {
                showError("Error closing resources: " + ex.getMessage());
            }
        }
    }


    private void parseWeatherData(String response) {
        JSONObject json = new JSONObject(response);

        double temp = json.getJSONObject("main").getDouble("temp");
        int humidity = json.getJSONObject("main").getInt("humidity");
        double windSpeed = json.getJSONObject("wind").getDouble("speed");
        String iconCode = json.getJSONArray("weather").getJSONObject(0).getString("icon");

        temperatureLabel.setText("Temperature: " + temp + (unitToggle.getSelectedToggle().equals(unitToggle.getToggles().get(0)) ? " °C" : " °F"));
        humidityLabel.setText("Humidity: " + humidity + "%");
        windSpeedLabel.setText("Wind Speed: " + windSpeed + (unitToggle.getSelectedToggle().equals(unitToggle.getToggles().get(0)) ? " m/s" : " mph"));

        // Set weather icon
        String iconUrl = "http://openweathermap.org/img/wn/" + iconCode + "@2x.png";
        weatherIcon.setImage(new Image(iconUrl));

        // Placeholder for forecast (not covered in this example)
        forecastLabel.setText("Forecast: Coming soon...");
    }

    private void applyDynamicBackground(Scene scene) {
        String timeOfDay = getTimeOfDay(); // morning, afternoon, evening

        switch (timeOfDay) {
            case "morning":
                scene.setFill(javafx.scene.paint.Color.LIGHTYELLOW);
                break;
            case "afternoon":
                scene.setFill(javafx.scene.paint.Color.LIGHTBLUE);
                break;
            case "evening":
                scene.setFill(javafx.scene.paint.Color.LIGHTGRAY);
                break;
            default:
                scene.setFill(javafx.scene.paint.Color.WHITE); // Default background
        }
    }


    private String getTimeOfDay() {
       int hour = java.time.LocalTime.now().getHour();
       if (hour >= 6 && hour < 12) {
           return "morning";
       } else if (hour >= 12 && hour < 18) {
           return "afternoon";
       } else {
           return "evening";
       }
   }


    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
