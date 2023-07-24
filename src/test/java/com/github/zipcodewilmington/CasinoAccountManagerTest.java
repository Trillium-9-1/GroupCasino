package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CasinoAccountManagerTest {

    CasinoAccount account = new CasinoAccount("Angela", "password", 1000);
    CasinoAccount account1 = new CasinoAccount("Bob", "pw", 2000);
    CasinoAccount account2 = new CasinoAccount("Linda", "pw", 500);

    @Test
    public void testGetAccount() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        cam.registerAccount(account);
        CasinoAccount actual = cam.getAccount("Angela", "password");

        Assert.assertEquals(actual, account);
    }

    @Test
    public void testGetAccount2() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        cam.registerAccount(account1);
        CasinoAccount actual = cam.getAccount("Bob", "pw");

        Assert.assertEquals(actual, account1);
    }

    @Test
    public void testGetAccount3() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        cam.registerAccount(account2);
        CasinoAccount actual = cam.getAccount("Linda", "pw");

        Assert.assertEquals(actual, account2);
    }

    @Test
    public void testCreateAccount() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount expected = cam.createAccount("Bob", "pw", 2000);
        CasinoAccount actual = cam.getAccount("Bob", "pw");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateAccount2() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount expected = cam.createAccount("Angela", "password", 1000);
        CasinoAccount actual = cam.getAccount("Angela", "password");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateAccount3() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount expected = cam.createAccount("Linda", "pw", 500);
        CasinoAccount actual = cam.getAccount("Linda", "pw");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBalance() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Linda", "pw", 500);
        Integer expected = 500;
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBalance2() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 1000);
        Integer expected = 1000;
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBalance3() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 2000);
        Integer expected = 2000;
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetBalance() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 2000);
        Integer expected = 2000;
        account.setBalance(expected);
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetBalance2() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 800);
        Integer expected = 800;
        account.setBalance(expected);
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetBalance3() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 300);
        Integer expected = 300;
        account.setBalance(expected);
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddBalance() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 1500);
        Integer expected = 2000;
        account.addBalance(500);
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddBalance2() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 500);
        Integer expected = 2000;
        account.addBalance(1500);
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddBalance3() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 800);
        Integer expected = 5200;
        account.addBalance(4400);
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWithdrawBalance() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 1500);
        Integer expected = 1000;
        account.withdrawBalance(500);
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWithdrawBalance2() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 1500);
        Integer expected = 500;
        account.withdrawBalance(1000);
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWithdrawBalance3() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 2800);
        Integer expected = 2200;
        account.withdrawBalance(600);
        Integer actual = account.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCheckBalance() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 1500);
        Integer bet = 1000;

        Assert.assertTrue(account.checkBalance(bet));
    }

    @Test
    public void testCheckBalance2() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 1500);
        Integer bet = 1500;

        Assert.assertTrue(account.checkBalance(bet));
    }

    @Test
    public void testCheckBalance3() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 1500);
        Integer bet = 2000;

        Assert.assertFalse(account.checkBalance(bet));
    }

    @Test
    public void testCheckBalance4() throws IOException {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount account = cam.createAccount("Bob", "pw", 1500);
        Integer bet = 1501;

        Assert.assertFalse(account.checkBalance(bet));
    }

}
