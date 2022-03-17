package com.company;


import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Программа справочник");
        PhoneBook phoneContacts = new PhoneBook();
        while (true) {

            System.out.println("Введите необходимую операцию: ");
            System.out.println("1 - Создать группу\n" +
                    "2 - Добавить контакт в группу\n" +
                    "3 - Поиск контакта по номеру\n" +
                    "4 - Вывод групп с контактами\n" +
                    "0 - Выход из программы");
            int input = Integer.parseInt(scanner.next());

            switch (input) {

                case 1:
                    while (true) {
                        System.out.println("Введите название группы: ");
                        String group = scanner.next();
                        if (group.equals("no")) {
                            break;
                        } else {
                            phoneContacts.addGroup(group);
                            System.out.println(" Создать еще одну группу? (введите название или no)");
                        }
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.println("Введите имя и номер телефона через Enter");
                        String nameOfContact = scanner.next();
                        String numberOfContact = scanner.next();
                        System.out.println(nameOfContact + " " + numberOfContact);
                        System.out.println("Введите наименование группы");
                        String nameOfGroup = scanner.next();
                        phoneContacts.addContact(Contact.createContact(nameOfContact, numberOfContact), nameOfGroup);
                        System.out.println("Хотите добавить еще контакт? введите yes или no");
                        String answer = scanner.next();
                        if (answer.equals("no")) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Введите номер телефона, имя которого нужно найти ");
                    String number = scanner.next();
                    System.out.println(phoneContacts.getPhoneNumber(number));
                    break;

                case 4:
                    System.out.println("Созданные группы и их контакты: ");
                    phoneContacts.showContactAndGroups();
                    break;

                case 0:
                    break;
            }
            if(input == 0)
                break;

        }
    }
}