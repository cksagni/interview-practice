package designpatterns.behavioural.observerpattern;
	
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private WeatherData weatherData;
	private float temperature;
	private float humidity;
	
	public CurrentConditionsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		this.weatherData.addObserver(this);
	}
	
	public void update() {
		this.temperature = weatherData.getTemperature();
		this.humidity = weatherData.getHumidity();
		display();
	}
	
	public void display() {
		System.out.println("Current conditions: " + temperature 
			+ "F degrees and " + humidity + "% humidity");
	}
}
