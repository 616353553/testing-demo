package com.cheer.testingdemo;

public class Square implements Shape {
    private Integer width;

    public Square() {
        this.width = 0;
    }

    public Square(Integer width) {
        this.width = width;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public Integer area() {
        if (width == null) {
            return null;
        }
        return this.width * this.width;
    }

    @Override
    public Boolean equalSize(Shape shape) {
        if (shape == null) {
            return Boolean.FALSE;
        }
        return this.area().equals(shape.area());
    }

    @Override
    public Shape convertTo(Class<? extends Shape> shapeClass) throws Exception {
        if (shapeClass.equals(Square.class)) {
            return new Square(this.width);
        } else if (shapeClass.equals(Rectangle.class)) {
            return new Rectangle(this.width, this.width);
        } else {
            throw new Exception("Shape cannot be converted to Rectangle");
        }
    }
}
