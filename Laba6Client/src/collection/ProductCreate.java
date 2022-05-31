package collection;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ProductCreate implements Serializable {
    private static final long serialVersionUID = 10L;

    private final Scanner scanner = new Scanner(System.in);

    public Product create() {
        Product product = new Product();



        this.setName(product);
        Coordinates coordinates = new Coordinates();
        this.setCoordinateX(coordinates);
        this.setCoordinateY(coordinates);
        product.setCoordinates(coordinates);
        this.setPrice(product);
        this.setManufactureCost(product);
        this.setUnitOfMeasure(product);
        Organization organization = new Organization();
        this.setName(organization);
        this.setEmployeesCount(organization);
        this.setOrganizationType(organization);
        product.setManufacturer(organization);

        return product;
    }

    public void setName(Product product) {
        try {
            System.out.println("Введите навзвание продукта");
            String name = scanner.nextLine();

            if (name.equals(" ") || name.isEmpty()) {
                System.out.println("{значение поля не должно быть null}");
                this.setName(product);
            } else
                product.setName(name);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("{значение поля не должно быть null}");
            this.setName(product);
        }
    }
    public void setName(Organization organization) {
        try {
            System.out.println("Введите навзвание организации");
            String name = scanner.nextLine();

            if (name.equals(" ") || name.isEmpty()) {
                System.out.println("{значение поля не должно быть null}");
                this.setName(organization);
            } else
                organization.setName(name);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("{значение поля не должно быть null}");
            this.setName(organization);
        }
    }
    public void setCoordinateY(Coordinates coords) {
        try {
            System.out.println("Введите координату Y: ");
            String y = scanner.nextLine();

            if (y.equals("") || y.equals(null)) {
                this.setCoordinateY(coords);
                System.out.println( "{значение поля не должно быть null}");
            } else {
                float coordY = Float.parseFloat(y);
                coords.setY(coordY);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("{значение поля должно быть типа – float}");
            this.setCoordinateY(coords);
        }
    }
    public void setCoordinateX(Coordinates coords) {
        try {
            System.out.println("Введите координату X: ");
            String x = scanner.nextLine();

            if (x.equals("") || x.equals(null)) {
                this.setCoordinateX(coords);
                System.out.println("{значение поля не должно быть null}");
            } else {
                Long coordX = Long.valueOf(x);
                if (coordX > 0) {
                    coords.setX(coordX);
                } else {
                    System.out.println("{значение поля не должно быть  неотрицательным}");
                    this.setCoordinateX(coords);
                }
                coords.setX(coordX);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("{ERROR}: ЗНАЧЕНИЕ ПОЛЯ ДОЛЖНО БЫТЬ ТИПА \"Long\"");
            this.setCoordinateX(coords);
        }
    }
    public void setPrice(Product product) {
        try {
            System.out.println("Введите цену продукта: ");
            String c = scanner.nextLine();
            double price = Double.parseDouble(c);

            if (price <= 0) {
                System.out.println( "{значение поля должно быть неотрицательным}");
                this.setPrice(product);
            } else product.setPrice(price);

        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("{значение поля должно быть типа – double}");
            this.setPrice(product);
        }
    }
    public void setManufactureCost(Product product) {
        try {
            System.out.println("Введите цену от организации: ");
            String Cost = scanner.nextLine();
            Integer manufactureCost = Integer.parseInt(Cost);

            if (manufactureCost <= 0) {
                System.out.println("{значение поля должно быть неотрицательным}");
                this.setManufactureCost(product);
            } else product.setManufactureCost(manufactureCost);

        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("{значение поля должно быть типа – long}");
            this.setManufactureCost(product);
        }
    }
    public void setUnitOfMeasure(Product product) {
        System.out.println("Введите тип измерения {GRAMS,MILLILITERS,SQUARE_METERS}: ");
        String type = scanner.nextLine();
        Pattern.compile("");

        try {
            if (type.isEmpty()) {
                product.setUnitOfMeasure(null);
            }
            else
                product.setUnitOfMeasure(UnitOfMeasure.valueOf(type.toUpperCase()));
        } catch (Exception e) {
            System.out.println( "{значение указано некорректно}");
            this.setUnitOfMeasure(product);
        }
    }
    public void setEmployeesCount(Organization organization) {
        try {
            System.out.println("Введите количество рабочих: ");
            String c = scanner.nextLine();
            Integer count = Integer.parseInt(c);

            if (count <= 0) {
                System.out.println( "{значение поля должно быть неотрицательным}");
                this.setEmployeesCount(organization);
            } else organization.setEmployeesCount(count);

        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("{значение поля должно быть типа – double}");
            this.setEmployeesCount(organization);
        }
    }
    public void setOrganizationType(Organization organization) {
        System.out.println("Введите тип организации {COMMERCIAL,GOVERNMENT,TRUST,PRIVATE_LIMITED_COMPANY,OPEN_JOINT_STOCK_COMPANY}: ");
        String fuel = scanner.nextLine();
        System.out.println();

        try {
            if (fuel.isEmpty()) {
                organization.setType(null);
            } else {
                organization.setType(OrganizationType.valueOf(fuel.toUpperCase()));
            }
        } catch (Exception e) {
            System.out.println("{значение указано некорректно}");
            this.setOrganizationType(organization);
        }
    }
}
