package pro.tremblay.core;

import org.assertj.core.api.AbstractBigDecimalAssert;

public class Assertions extends org.assertj.core.api.Assertions{

    public static <T extends Numeric<T>> NumericAssert<T> assertThat(Numeric<T> actual) {
        return new NumericAssert<T>(actual);
    }
}
