/* Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. 
Критерии фильтрации можно хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объём ЖД
3 - Операционная система
4 - Цвет …

Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям. */

package java_homework_6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class task_1 {
    
    static Map<Integer, String> readData(Map<Integer, String> hashmap){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Выберите необходимое критерии поиска:\n" + 
        "Диагональ экрана от-до (15-21): ");
        hashmap.put(0, scanner.nextLine());
        System.out.print("Объем ОЗУ от-до (4-64): ");
        hashmap.put(1, scanner.nextLine());
        System.out.print("Объем диска от-до (256-2000): ");
        hashmap.put(2, scanner.nextLine());
        System.out.print("Объем диска 1 - Windows/2 - Linux/3 - без ОС: ");
        hashmap.put(3, scanner.nextLine());        

        scanner.close();
        return hashmap;
    } 

    static void request(Map<Integer, String> hashmap, Set<laptop> laptopSet){

        int counter = 0;
        int check = 0;        
        
        for (laptop item: laptopSet){
            
            String[] diagonal = hashmap.get(0).split("-");                
            if (Integer.parseInt(diagonal[0]) <= item.getDiagonal() && Integer.parseInt(diagonal[1]) >= item.getDiagonal()){
                counter++;                   
            }            

            String[] ram = hashmap.get(1).split("-");
            if (Integer.parseInt(ram[0]) <= item.getRam() && Integer.parseInt(ram[1]) >= item.getRam()){
                counter++;
            }
           
            String[] hd = hashmap.get(2).split("-");
            if (Integer.parseInt(hd[0]) <= item.getHd() && Integer.parseInt(hd[1]) >= item.getHd()){
                counter++;
            }
            
            String flag = hashmap.get(3);
            switch(flag){
                case "1":
                    if (item.getOs().equals("Windows")){
                        counter++;
                    }                
                    break;

                case "2":
                    if (item.getOs().equals("Linux")){
                         counter++;
                    }                
                    break;

                case "3":
                    if (item.getOs().equals("без ОС")){
                        counter++;
                    }                
                    break;

                }            
           
            if (counter == 4){
                System.out.println(item);
                check++;
            }

            counter = 0;
            
        }
       
        if (check == 0){
            System.out.println("Ноутбуков удовлетворяющих критериям поиска не найдено");
        }

    }
    public static void main(String[] args){

        Map<Integer, String> hashmap = new HashMap<>();

        laptop id_1 = new laptop("ASUS", "D543MA-DM1368", 15, "Intel Celeron N4020", 4, 1000, "без ОС");
        laptop id_2 = new laptop("Lenovo", "V15 ADA", 15, "AMD 3020e", 4, 256, "без ОС");
        laptop id_3 = new laptop("HUAWEI", "MateBook D16 RLEF-X", 16, "Intel Core i7-12700H", 16, 512, "Windows");
        laptop id_4 = new laptop("MSI", "Katana GF76", 17, "Intel Core i7-12650H", 16, 512, "Linux");
        laptop id_5 = new laptop("ARDOR ", "GAMING NEO G17-I5ND203", 17, "Intel Core i5-12500H", 16, 512, "Linux");
        laptop id_6 = new laptop("MSI ", "Titan GT77", 21, "Intel Core i9 12900HX", 64, 2000, "Windows");

        Set<laptop> laptopSet = new HashSet<>();
        laptopSet.add(id_1);
        laptopSet.add(id_2);
        laptopSet.add(id_3);
        laptopSet.add(id_4);
        laptopSet.add(id_5);
        laptopSet.add(id_6);

        readData(hashmap);
        request(hashmap, laptopSet); 

    }    

}
