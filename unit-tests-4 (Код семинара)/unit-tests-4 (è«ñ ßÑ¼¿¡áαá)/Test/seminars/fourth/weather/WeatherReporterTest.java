package seminars.fourth.weather;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.assertThat;

class WeatherReporterTest {
    @Test
    void generateReportTest(){
        WeatherService mockWeatherService = mock(WeatherService.class);
        //WeatherService mockWeatherService = new WeatherService();
        when(mockWeatherService.getCurrentTemperature()).thenReturn(25);
        WeatherReporter weatherReporter = new WeatherReporter(mockWeatherService);

        String reply = weatherReporter.generateReport();

        assertThat(reply).isEqualTo("Текущая температура: " + 25 + " градусов.");
    }
}