package com.tedmyoung.portfolio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Portfolio {
  private final List<Holding> holdings = new ArrayList<>();
  private Holding cashHolding = new Holding(0, "CASH", 1, LocalDate.now());

  public int value() {
    return allStockHoldingsPlusCash().stream()
                                     .mapToInt(Holding::value)
                                     .sum();
  }

  public void deposit(int amount) {
    updateCashHoldingTo(amount);
  }

  private void updateCashHoldingTo(int amount) {
    cashHolding = new Holding(amount, "CASH", 1, LocalDate.now());
  }

  public void buy(int shares, String symbol, int price, LocalDate dateOfPurchase) {
    addHolding(shares, symbol, price, dateOfPurchase);
    updateCashHoldingTo(cashHolding.value() - shares * price);
  }

  private void addHolding(int shares, String symbol, int price, LocalDate dateOfPurchase) {
    Holding holding = new Holding(shares, symbol, price, dateOfPurchase);
    holdings.add(holding);
  }

  public List<String> holdings() {
    return allStockHoldingsPlusCash().stream()
                                     .map(Holding::holdingString)
                                     .collect(Collectors.toUnmodifiableList());
  }

  private List<Holding> allStockHoldingsPlusCash() {
    List<Holding> displayList = new ArrayList<>(holdings);
    displayList.add(cashHolding);
    return displayList;
  }

  public int cash() {
    return cashHolding.value();
  }
}
