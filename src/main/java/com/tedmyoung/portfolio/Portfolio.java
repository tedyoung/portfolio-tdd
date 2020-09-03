package com.tedmyoung.portfolio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Portfolio {
  private int balance = 0;
  private final List<Holding> holdings = new ArrayList<>();
  private Holding cashHolding = new Holding(0, "CASH", 1, LocalDate.now());

  public int value() {
    return balance;
  }

  public void deposit(int amount) {
    cashHolding = new Holding(amount, "CASH", 1, LocalDate.now());
    balance += cashHolding.value();
  }

  public void buy(int shares, String symbol, int price, LocalDate dateOfPurchase) {
    Holding holding = new Holding(shares, symbol, price, dateOfPurchase);
    holdings.add(holding);

    int cashValue = cashHolding.value();
    cashHolding = new Holding(cashValue - holding.value(), "CASH", 1, LocalDate.now());
  }

  public List<String> holdings() {
    List<Holding> displayList = new ArrayList<>();
    displayList.add(cashHolding);
    displayList.addAll(holdings);
    return displayList.stream()
                      .map(Holding::holdingString)
                      .collect(Collectors.toUnmodifiableList());
  }

  public int cash() {
    return cashHolding.value();
  }
}
