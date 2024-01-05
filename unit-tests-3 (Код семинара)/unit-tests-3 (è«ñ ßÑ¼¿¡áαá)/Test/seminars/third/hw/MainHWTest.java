package seminars.third.hw;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MainHWTest {

    @Test
    void evenOddNumberReturnsTrueIfNumberIsEven() {
        assertThat(MainHW.evenOddNumber(8)).isTrue();
    }
    @Test
    void evenOddNumberReturnsFalseIfNumberIsOdd() {
        assertThat(MainHW.evenOddNumber(7)).isFalse();
    }

    @Test
    void numberInIntervalReturnsTrueIfNumberIsInInterval(){
        assertThat(MainHW.numberInInterval(50)).isTrue();
    }
    @Test
    void numberInIntervalReturnsFalseIfNumberIsOutside(){
        assertThat(MainHW.numberInInterval(0)).isFalse();
    }

}