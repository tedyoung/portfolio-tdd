package com.tedmyoung.portfolio;

import java.time.LocalDate;

public class Holding {
  private final LocalDate dateOfPurchase;
  private final String symbol;
  private final int shares;
  private final int price;
  private final int holdingValue;

  public Holding(int shares, String symbol, int price, LocalDate dateOfPurchase) {
    this.dateOfPurchase = dateOfPurchase;
    this.symbol = symbol;
    this.shares = shares;
    this.price = price;
    this.holdingValue = shares * price;
  }

  public String holdingString() {
    return dateOfPurchase.toString() + " " + symbol + " " + shares + " " + price + " " + holdingValue;
  }

  public int value() {
    return holdingValue;
  }

  public int valueAtPriceOf(int presentPrice) {
    return shares * presentPrice;
  }
}
