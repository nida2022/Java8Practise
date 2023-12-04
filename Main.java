import java.net.ProtocolException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Employees e1 = new Employees("John",50000,"E1");
        Employees e2  = new Employees("Jack",40000,"E2");
        Employees e3 = new Employees("Alex",345345,"E1");


        List<Employees> list = List.of(e1,e2,e3);
        Map<String,List<Employees>> emp = list.stream().collect(Collectors.groupingBy(Employees::getBand));

        Map<String,List<String>> emp1 = list.stream().collect(Collectors.groupingBy(Employees::getBand,Collectors.mapping(Employees::getName,Collectors.toList())));

        emp1.forEach((band,name)->{
            System.out.println("Band: " + band);
            name.stream().forEach(System.out::println);
        });


        emp.forEach((band, employeeList) -> {
            System.out.println("Department: " + band);
            employeeList.stream().map(Employees::getName).forEach(System.out::println);
            System.out.println("---------------------");
        });

        Map<String,Integer> emp2 = list.stream().collect(Collectors.groupingBy(Employees::getBand,Collectors.summingInt(Employees::getSalary)));

        emp2.forEach((band,salary)->System.out.println(band+ " "+ salary));
    }

}
