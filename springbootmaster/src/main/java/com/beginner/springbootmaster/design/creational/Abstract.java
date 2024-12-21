package com.beginner.springbootmaster.design.creational;

//Abstract Factory là một mẫu thiết kế cấu trúc cho phép
// tạo ra các đối tượng thuộc cùng một loại (family of related objects)
// mà không cần phải chỉ định chính xác lớp đối tượng đó.
// Mẫu này thường được sử dụng khi hệ thống cần tạo ra
// các đối tượng thuộc các loại khác nhau, nhưng lại
// không muốn phụ thuộc vào các lớp cụ thể của chúng.

public class Abstract {
    // abstract product
    public interface Chair {
        void sitOn();
    }
    public interface Table {
        void use();
    }

    // concrete products
    public class ModernChair implements Chair {
        @Override
        public void sitOn() {
            System.out.println("Sitting on Modern Chair");
        }
    }
    public class VictorianChair implements Chair {
        @Override
        public void sitOn() {
            System.out.println("Sitting on Victorian Chair");
        }
    }
    public class ModernTable implements Table {
        @Override
        public void use() {
            System.out.println("Using Modern Table");
        }
    }
    public class VictorianTable implements Table {
        @Override
        public void use() {
            System.out.println("Using Victorian Table");
        }
    }
    // abstract factory
    public interface FurnitureFactory {
        Chair createChair();
        Table createTable();
    }

    // Concreate Factory
    public class ModernFurnitureFactory implements FurnitureFactory {
        @Override
        public Chair createChair() {
            return new ModernChair();
        }

        @Override
        public Table createTable() {
            return new ModernTable();
        }
    }

    public class VictorianFurnitureFactory implements FurnitureFactory {
        @Override
        public Chair createChair() {
            return new VictorianChair();
        }

        @Override
        public Table createTable() {
            return new VictorianTable();
        }
    }

    // client
    public class FurnitureClient {
        private Chair chair;
        private Table table;

        public FurnitureClient(FurnitureFactory factory) {
            chair = factory.createChair();
            table = factory.createTable();
        }

        public void sitOnChair() {
            chair.sitOn();
        }

        public void useTable() {
            table.use();
        }

        public void main(String[] args) {
            FurnitureFactory modernFactory = new ModernFurnitureFactory();
            FurnitureClient modernClient = new FurnitureClient(modernFactory);
            modernClient.sitOnChair();
            modernClient.useTable();

            FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
            FurnitureClient victorianClient = new FurnitureClient(victorianFactory);
            victorianClient.sitOnChair();
            victorianClient.useTable();

        }

    }


}
