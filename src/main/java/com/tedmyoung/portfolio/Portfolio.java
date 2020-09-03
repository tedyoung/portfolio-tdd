package com.tedmyoung.portfolio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Portfolio {
  private int balance = 0;
  private final List<Holding> holdings = new ArrayList<>();

  public int value() {
    return balance;
  }

  public void deposit(int amount) {
    addHolding(amount, "CASH", 1, LocalDate.now());
  }

  public void buy(int shares, String symbol, int price, LocalDate dateOfPurchase) {
    addHolding(shares, symbol, price, dateOfPurchase);
  }

  private void addHolding(int shares, String symbol, int price, LocalDate dateOfPurchase) {
    Holding holding = new Holding(shares, symbol, price, dateOfPurchase);
    holdings.add(holding);
    balance += holding.value();
  }

  public List<String> holdings() {
    return holdings.stream()
                   .map(Holding::holdingString)
                   .collect(Collectors.toUnmodifiableList());
  }

}
