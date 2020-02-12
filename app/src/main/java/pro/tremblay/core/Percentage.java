package pro.tremblay.core;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.math.BigDecimal;
import java.util.Objects;

@ThreadSafe
public final class Percentage extends Numeric<Percentage> {

    public static Percentage pct(@Nonnull BigDecimal value) {
        return new Percentage(Objects.requireNonNull(value));
    }

    private Percentage(@Nonnull BigDecimal value) {
        super(value);
    }

    @Override
    protected Percentage fromValue(@Nonnull BigDecimal newValue) {
        return new Percentage(newValue);
    }

    @Override
    public String toString() {
        return super.toString() + "%";
    }
}
