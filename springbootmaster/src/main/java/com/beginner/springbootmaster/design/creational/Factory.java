package com.beginner.springbootmaster.design.creational;

//Cung cấp một giao diện để tạo đối tượng, nhưng cho phép
// các lớp con quyết định loại đối tượng nào sẽ được khởi tạo.

// define product interface
interface Shape {
    void draw();
}

// create concrete products
class Rectangle implements Shape {
    public void draw() {
        System.out.println("Rectangle");
    }
}

class Triangle implements Shape {
    public void draw() {
        System.out.println("Triangle");
    }
}

// define creator
abstract class ShapeFactory {
    // factory method
    public abstract Shape createShape();
}

// Implement concrete creators
class RectangleFactory extends ShapeFactory {
    public Shape createShape() {
        return new Rectangle();
    }
}

class TriangleFactory extends ShapeFactory {
    public Shape createShape() {
        return new Triangle();
    }
}

public class Factory {
    public static void main(String[] args) {
        ShapeFactory factory = new RectangleFactory();
        Shape shape = factory.createShape();
        shape.draw();

        factory = new TriangleFactory();
        shape = factory.createShape();
        shape.draw();
    }
}
