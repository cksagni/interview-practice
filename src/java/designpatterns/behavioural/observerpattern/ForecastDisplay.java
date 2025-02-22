package designpatterns.behavioural.observerpattern;



public class ForecastDisplay implements Observer, DisplayElement {
	private WeatherData weatherData;
	private float currentPressure = 29.92f;  
	private float lastPressure;

	public ForecastDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		this.weatherData.addObserver(this);
	}

	public void update() {
		lastPressure = currentPressure;
		currentPressure = weatherData.getPressure();
		display();
	}

	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
	}
}
