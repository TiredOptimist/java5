package ru.pankova.task_1;

import java.util.Objects;

public class Fraction implements DoubleFraction{
    private int chis;
    private int znam;

    public int getChis(){
        return this.chis;
    }

    public int getZnam(){
        return this.znam;
    }

    @Override
    public int setChis(int chis) {
        this.chis = chis;
        return this.chis;
    }

    @Override
    public int setZnam(int znam) {
        if (znam == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю!");
        }
        if (znam < 0) {
            this.chis = -this.chis;
            znam = -znam;
        }
        this.znam = znam;
        return this.znam;
    }

    // для целого числа
    public Fraction(int chis){
        this(chis, 1);
    }

    public Fraction(int chis, int znam){
        if (znam == 0) { // знаменатель не может равняться 0
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю!");
        }

        if (znam < 0) { // знаменатель не может быть отрицательным
            chis = -chis;
            znam = -znam;
        }
        int nod = nod(chis, znam); // сокращаем дробь
        this.chis = chis / nod;
        this.znam = znam / nod;
    }

    public String toString() {
        return this.chis + "/" + this.znam;
    }

    @Override
    public double DoubleValue() {
        return (double) chis / znam;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Fraction fraction = (Fraction) obj;
        return chis == fraction.chis && znam == fraction.znam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chis, znam);
    }

    // нахождение наибольшего общего делителя
    private int nod(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    // сложения дробей (с другом дробью или с целым числом)
    public Fraction summa(Fraction fraction) {
        int newChis = this.chis * fraction.znam + fraction.chis * this.znam;
        int newZnam = this.znam * fraction.znam;
        return new Fraction(newChis, newZnam);
    }

    // вычитание дробей (с другой дробью или с целым числом)
    public Fraction razn(Fraction fraction) {
        int newChis = this.chis * fraction.znam - fraction.chis * this.znam;
        int newZnam = this.znam * fraction.znam;
        return new Fraction(newChis, newZnam);
    }

    // умножение дробей (с другой дробью или целым числом)
    public Fraction umn(Fraction fraction) {
        int newChis = this.chis * fraction.chis;
        int newZnam = this.znam * fraction.znam;
        return new Fraction(newChis, newZnam);
    }

    // деление дробей (с другой дробью или целым числом)
    public Fraction del(Fraction fraction) {
        if (fraction.chis == 0) {
            throw new ArithmeticException("На ноль делить нельзя!");
        }
        int newChis = this.chis * fraction.znam;
        int newZnam = this.znam * fraction.chis;
        return new Fraction(newChis, newZnam);
    }
}
