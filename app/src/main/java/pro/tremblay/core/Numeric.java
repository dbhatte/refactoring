package pro.tremblay.core;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.math.BigDecimal;
import java.util.Objects;

@ThreadSafe
public abstract class Numeric<T extends Numeric<T>> {
    protected final BigDecimal value;

    protected Numeric(@Nonnull BigDecimal value) {
        this.value = value;
    }

    protected abstract T fromValue(@Nonnull BigDecimal newValue);

    public T add(@Nonnull T numeric) {
        return fromValue(value.add(numeric.value));
    }

    public T substract(@Nonnull T numeric) {
        return fromValue(value.subtract(numeric.value));
    }

    public BigDecimal toBigDecimal() {
        return value;
    }

    public boolean isZero() {
        return value.signum() == 0;
    }

    public T negate() {
        return fromValue(value.negate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Numeric<?> numeric = (Numeric<?>) o;
        return value.equals(numeric.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return toBigDecimal().toPlainString();
    }
}
