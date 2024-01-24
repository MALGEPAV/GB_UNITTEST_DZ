import java.util.List;

public class ListsComparison {

    private ListsComparison(){

    }
    public static <T extends Number, V extends Number> String compareAverages(List<T> numberList1, List<V> numberList2) {

        double average1 = average(numberList1);
        double average2 = average(numberList2);

        if (Math.abs(average1 - average2) < 0.000001) {
            return "Средние значения равны (с точностью до 0.000001)";
        }
        if (average1 > average2) {
            return "Первый список имеет большее среднее значение";
        }
        return "Второй список имеет большее среднее значение";
    }

    public static <T extends Number> double average(List<T> numberList) {
        double sum = 0.0;
        if (!numberList.isEmpty()) {
            for (Number number : numberList) {
                sum += number.doubleValue();
            }
            sum /= numberList.size();
        }
        return sum;
    }
}
