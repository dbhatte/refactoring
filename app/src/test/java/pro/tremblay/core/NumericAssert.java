package pro.tremblay.core;

import org.assertj.core.api.BigDecimalAssert;

import java.math.BigDecimal;

public class NumericAssert<T extends Numeric<T>> extends BigDecimalAssert {
    public NumericAssert(Numeric<T> actual) {
        super(actual.value);
    }

    public BigDecimalAssert isEqualTo(Numeric<T> expected) {
        return isEqualTo(expected.toBigDecimal());
    }
}
