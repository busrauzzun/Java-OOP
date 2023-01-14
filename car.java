public class Main {
    public static void main(String[] args) {
        try {
            Car c1=new Car(2018);
            Car c2=new Car("Porsche",2015);
            Car c3=new Car("hyundai",150,2000);

            Car []cars={c1,c2,c3};
            Factory f1=new Factory(cars);
            f1.printAllCarsInfo();
        }

        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class Car {
    private String brand;
    private int maxSpeed;
    private int year;

    Car(int year){
        this("Audi",200,year);
    }
    Car(String brand,int year){
        this(brand,180,year);
    }
    Car(String brand,int maxSpeed,int year){
        setBrand(brand);
        setmaxSpeed(maxSpeed);
        setYear(year);

    }
    public void setYear(int year){
        if(this.year>2020)
            throw new Exception("year cannot be freater 2022 ");
        this.year=year;
    }
    public void setmaxSpeed(int maxSpeed){
        this.maxSpeed=maxSpeed;
    }
    public void setBrand(int brand){
        this.brand=brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getYear() {
        return year;
    }
    public String getBrand() {
        return brand;
    }
    public String printCarInfo(){
        return String.format("BRAND: %s YEAR: %d SPEED: %d",this.brand, this.year, this.maxSpeed);
    }
}

class Factory {
    Car [] cars;

    Factory(Car[] cars){
        this.cars=cars;
    }

    public void printAllCarsInfo(){
        for(Car c: cars){
            System.out.println(c.printCarInfo());
        }
    }
}

