package ch04.ex07;

public enum Color {
    BLACK(0, 0, 0),
    RED(1, 0, 0),
    GREEN(0, 1, 0),
    BLUE(0, 0, 1),
    CYAN(0, 1, 1),
    MAGENTA(1, 0, 1),
    YELLOW(1, 1, 0),
    WHITE(1, 1, 1);

    private final float red, green, blue;

    Color(float red, float green, float blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public float getRed() {
        return red;
    }

    public float getGreen() {
        return green;
    }

    public float getBlue() {
        return blue;
    }
}
