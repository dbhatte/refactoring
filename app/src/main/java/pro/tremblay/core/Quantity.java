package pro.tremblay.core;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.math.BigDecimal;
import java.util.Objects;

@ThreadSafe
public class Quantity extends Numeric<Quantity> {

    private static final Quantity ZERO = new Quantity(BigDecimal.ZERO);
    private static final Quantity TEN = qty(10);

    public static Quantity zero() {
        return ZERO;
    }

    public static Quantity ten() {
        return TEN;
    }

    public static Quantity qty(long value) {
        return new Quantity(BigDecimal.valueOf(value));
    }

    public static Quantity qty(@Nonnull BigDecimal value) {
        return new Quantity(Objects.requireNonNull(value));
    }

    private Quantity(@Nonnull BigDecimal value) {
        super(value);
    }

    @Override
    protected Quantity fromValue(@Nonnull BigDecimal newValue) {
        return new Quantity(newValue);
    }
}
