package ru.pankova.task_7.number1;

public class Line {
    private Point start;
    private Point end;

    public Line(){
        this.start = null;
        this.end = null;
    }

    // Конструктор
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public String getLineString() {
        return "Линия от " + start.getPointString() + " до " + end.getPointString();
    }
}
