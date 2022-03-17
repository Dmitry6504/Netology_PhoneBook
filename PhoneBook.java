package com.company;

import java.util.*;

public class PhoneBook {
    private Map<String, List<Contact>> groupMap = new HashMap<>();
    private List<Contact> contactList = new ArrayList<>();

    public void addGroup(String inputName) {
        if (!groupMap.containsKey(inputName)) {
            groupMap.put(inputName, new ArrayList<>());
        } else {
            System.out.println("Повторяется имя группы, введите заново");
        }
    }

    public void addContact(Contact contact, String group) {
        if (groupMap.containsKey(group)) {
            if (!groupMap.containsKey(group)) {
                if (contactList.add(contact)) {
                    System.out.println(contact + "успешно добавлен в " + group + " группу ");
                }
            } else {
                contactList.addAll(groupMap.get(group));
                if (contactList.add(contact)) {
                    System.out.println(contact + "успешно добавлен в " + group + " группу");
                }
            }
            groupMap.put(group, contactList);
        } else {
            System.out.println("Не возможно добавить " + contact + " в тел книгу");
            System.out.println("группа с именем " + group + " отсутствует");
        }
    }

    public void showContact() {
        for (Contact contact : contactList) {
            String s = contact.getName() + " " + contact.getNumber();
            System.out.println(s);
        }
    }

    public String getGroupMap() {
        String s = null;
        for (String group : groupMap.keySet()) {
            s = group;
        }
        return s;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public Contact getPhoneNumber(String phone) {
        Contact searchContact = null;
        Collection<List<Contact>> groups = groupMap.values();
        for (List<Contact> group : groups) {
            for (Contact contact : group) {
                if (contact.getNumber().equals(phone)) {
                    searchContact = contact;
                }
            }
        }
        return searchContact;
    }

    public void showContactAndGroups() {
        for (List<Contact> contactList : groupMap.values()) {
            for (Contact contact : contactList) {

                System.out.println(groupMap);


            }
        }
    }
}
