package ru.pankova.task_1;

public class CachedFraction extends Fraction {
    private Double value;

    public CachedFraction(int chis) {
        super(chis);
    }

    public CachedFraction(int chis, int znam) {
        super(chis, znam);
    }

    public double getValue() {
        if (value == null) {
            value = DoubleValue();
        }
        return value;
    }

    @Override
    public int setChis(int chis) {
        value = null;
        return super.setChis(chis);
    }

    @Override
    public int setZnam(int znam) {
        value = null;
        return super.setZnam(znam);
    }
}

