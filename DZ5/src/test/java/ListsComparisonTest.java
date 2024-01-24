import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ListsComparisonTest {
    @Test
    void averageThrowsNPEGivenNull() {
        assertThatThrownBy(() -> ListsComparison.average(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void averageReturnsZeroGivenAnEmptyList() {
        assertThat(ListsComparison.average(new ArrayList<Double>())).isEqualTo(0.0);
    }

    @Test
    void averageRegularCase() {
        List<Number> sampleList = List.of(1, 2.0, 3.5f);

        double expectedAverage = sampleList.stream()
                .mapToDouble(Number::doubleValue)
                .average()
                .getAsDouble();
        double resAverage = ListsComparison.average(sampleList);

        assertThat(resAverage).isEqualTo(expectedAverage, Offset.offset(0.000001));
    }

    @Test
    void compareAverageEqualAveragesTest() {
        List<Integer> intList = List.of(1, 2, 3, 4);
        List<Double> doubleList = List.of(4.0, 3.0, 2.0, 1.0);

        String comparisonResult = ListsComparison.compareAverages(intList, doubleList);

        assertThat(comparisonResult).
                isEqualTo("Средние значения равны (с точностью до 0.000001)");
    }

    @Test
    void compareAveragesSecondAverageIsGreaterTest() {
        List<Integer> intList = List.of(1, 2, 3);
        List<Float> floatList = List.of(4.1f, 5.2f);

        String comparisonResult = ListsComparison.compareAverages(intList, floatList);

        assertThat(comparisonResult).
                isEqualTo("Второй список имеет большее среднее значение");
    }

    @Test
    void compareAveragesFirstAverageIsGreaterTest() {
        List<Integer> intList = List.of(4, 5, 6);
        List<Float> floatList = List.of(1.1f, 2.2f);

        String comparisonResult = ListsComparison.compareAverages(intList, floatList);

        assertThat(comparisonResult).
                isEqualTo("Первый список имеет большее среднее значение");
    }
}