package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("* * *  Вас приветствует Банк Данных!  * * *");
        boolean exit = false;
        while (!exit) {
            System.out.println("======= 1. Ввод данных пользователя ======");
            System.out.println("======= 2. Вывод данных пользователя ======");
            System.out.println("======= 3. Выход ==========================");
            System.out.println("Введите номер пункта меню (1/2/3) : ");
            Scanner scanner = new Scanner(System.in);
            if (!scanner.hasNextInt()){
                throw new MyNumberException();
            }
            int menuNum = scanner.nextInt();

            if (menuNum >= 1 && menuNum <= 3) {
                switch (menuNum) {
                    case 1:
                        System.out.println("Введите данные пользователя в формате:");
                        System.out.println("Фамилия Имя Отчество дата_рождения(ЧЧ.ММ.ГГГГ) номер_телефона(89991234567) пол(М/Ж),");
                        System.out.println("разделяя данные пробелом");
                        Scanner scan = new Scanner(System.in);
                        String next = scan.nextLine();
                        String[] userstring = next.split(" ");
                        if (userstring.length != 6) {
                            throw new MyArraySizeException();
                        }
                        String surName = userstring[0];
                        if (surName.length() < 2) {
                            throw new MyLengthException(surName);
                        }
                        String name = userstring[1];
                        String lastName = userstring[2];
                        String birthDay = userstring[3];
                        if (birthDay.length() < 10 || birthDay.length() > 10) {
                            throw new MyLengthException(birthDay);
                        } else if (!validDate(birthDay)) {
                            throw new NumberFormatException(String.format("Неправильно введена дата %s", birthDay));
                        }
                        String phNum = userstring[4];
                        if (phNum.length() < 11) {
                            throw new MyLengthException(phNum);
                        } else if (phNum.length() > 11) {
                            throw new MyArraySizeException(phNum);
                        }
                        Long phoneNumber = number(phNum);
                        String gender = userstring[5];
                        String m = "М";
                        String f = "Ж";
                        if (!gender.equals(m) && !gender.equals(f)) {
                            throw new InputMismatchException(String.format("Введен неверно пол %s", gender));
                        }
                        UserData userData = new UserData(surName, name, lastName, birthDay, phoneNumber, gender);
                        String path = surName + ".txt";
                        writerData(path, userData);
                        System.out.println(String.format("Данные внесены в базу %s", userData));
                        break;
                    case 2:
                        System.out.println("Введите фамилию :");
                        Scanner scanner2 = new Scanner(System.in);
                        String sur = scanner2.nextLine();
                        if (sur.length() < 2) {
                            throw new MyLengthException(sur);
                        }
                        try {
                            String findPath = sur + ".txt";
                            readerData(findPath);
                        } catch (ClassCastException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        System.out.println("******** До встречи! *********");
                        exit = true;
                        break;

                }

            } else {
                throw new MyArraySizeException(menuNum);
            }
        }



    }
    public static boolean isNotNumber(String str){
        try {
            Long.parseLong(str);
            return false;
        }catch (NumberFormatException e){
            return true;
        }
    }
    public static Long number(String str){
        Long number = 0L;
        for (int i = 0; i < str.length(); i++) {
            if(isNotNumber(String.valueOf(str.charAt(i)))){
                throw new MyNumberException();
            }else {
                int value = Integer.parseInt(String.valueOf(str.charAt(i)));
                number = (number + value) * 10;
            }
        }
        return number / 10;
    }
    public static boolean validDate(String brDate){
        String[] date = brDate.split("\\.");
        int day = Integer.parseInt(date[0]);
        int mon = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        try {
            if (day < 1 || day > 31) {
                return false;
            }
            if (mon < 1 || mon > 12){
                return false;
            }
            if(year < 1924 || year > 2024){
                return false;
            }
            return true;
        }catch (NumberFormatException e){
            return false;
        }

    }
    public static void writerData(String path, Object o){
        try (FileWriter fw = new FileWriter(path, true)) {
            fw.write(o.toString());
            fw.write("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void readerData(String path){
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new NullPointerException(String.format("Файла под этой фамилией не существует %s", path));
        }
    }

}
