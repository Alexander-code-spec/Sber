import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class City{
        private String name;
        private String region;
        private String district;
        private Integer population;
        private String foundation;

        public City(String name, String region, String district, Integer population, String foundation) {
            this.name = name;
            this.region = region;
            this.district = district;
            this.population = population;
            this.foundation = foundation;
        }

        @Override
        public String toString() {
            return "City{" +
                    "name='" + name + '\'' +
                    ", region='" + region + '\'' +
                    ", district='" + district + '\'' +
                    ", population=" + population +
                    ", foundation='" + foundation + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        try {
            Scanner scanner = new Scanner(new File(Paths.get("Задача ВС Java Сбер.csv").toUri()));
            List<City> cityList = new ArrayList<>();

            while (scanner.hasNext()){
                String[] line = scanner.nextLine().split(";");
                if (line.length != 6){
                    System.out.println("Невнерная запись в строке" + Integer.parseInt(line[0]));
                } else {
                    cityList.add(new City(line[1], line[2], line[3],
                            Integer.parseInt(line[4]), line[5]));
                }
            }

            for (City city: cityList) {
                System.out.println(city);
            }
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден!");
        }
    }
}
