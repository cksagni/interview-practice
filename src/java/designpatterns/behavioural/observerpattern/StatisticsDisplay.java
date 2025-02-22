package designpatterns.behavioural.observerpattern;


public class StatisticsDisplay implements Observer, DisplayElement {
	private WeatherData weatherData;
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;

	public StatisticsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		this.weatherData.addObserver(this);
	}

	public void update() {
		float temp = this.weatherData.getTemperature();
		tempSum += temp;
		numReadings++;

		if (temp > maxTemp) {
			maxTemp = temp;
		}

		if (temp < minTemp) {
			minTemp = temp;
		}

		display();
	}

	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
			+ "/" + maxTemp + "/" + minTemp);
	}
}
