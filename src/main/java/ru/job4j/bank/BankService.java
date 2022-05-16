package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса.
 * Хранение данных пользователя на основе коллекции типа Map.
 * @author DMITRY PERVUSHIN
 * @version 1.0
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод проверяет, что такого пользователя нет в системе, и добавляет его.
     * Новому пользователю присваивается пустой список банковских счетов.
     *@param user добавляемый пользователь.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод находит пользователя по номеру паспорта.
     * и добавляет ему банковский счет, если такого счета ещё нет.
     * @param passport номер паспорта пользователя.
     * @param account добавляемый банковский счет.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод позволяет получить пользователя - {@code user}
     * с номером паспорта - {@code passport}.
     * @param passport номер паспорта, по которому производится поиск пользователя.
     * @return возвращаемый пользователь.
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод позволяет получить банковский счет - {@code account}
     * по реквизитам счета - {@code requisite}
     * и номеру паспорта пользователя - {@code passport}.
     * @param passport номер паспорта, по которому производится поиск пользователя.
     * @param requisite реквизиты, по которым производится поиск банковского счета.
     * @return возвращаемый банковский счет.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(account -> requisite.equals(account.getRequisite()))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод предназначен для перевода денег с одного счета на другой.
     * @param srcPassport номер паспорта пользователя, отправляющего перевод.
     * @param srcRequisite реквизиты, с которых производится перевод.
     * @param destPassport номер паспорта пользователя, получающего перевод.
     * @param destRequisite реквизиты, на которые производится перевод.
     * @param amount сумма преводимых денег.
     * @return возвращает {@code true}, если перевод завершен успешно.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null
                && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            return true;
        }
        return false;
    }
}