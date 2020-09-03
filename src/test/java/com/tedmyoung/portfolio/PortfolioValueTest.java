package com.tedmyoung.portfolio;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class PortfolioValueTest {
  @Test
  public void newPortfolioHasZeroValue() throws Exception {
    Portfolio portfolio = new Portfolio();

    assertThat(portfolio.value())
        .isZero();
  }

  @Test
  public void newPortfolioWhenDeposit10_000ValueIs10_000() throws Exception {
    Portfolio portfolio = new Portfolio();

    portfolio.deposit(10_000);

    assertThat(portfolio.value())
        .isEqualTo(10_000);
    assertThat(portfolio.cash())
        .isEqualTo(10_000);
  }

  @Test
  public void buy25_000DollarsInSharesThenPortfolioIsValuedAt25_000() throws Exception {
    Portfolio portfolio = new Portfolio();
    portfolio.deposit(25_000);

    portfolio.buy(200, "AAPL", 125, LocalDate.of(2020, 8, 28));

    assertThat(portfolio.value())
        .isEqualTo(25_000);
    assertThat(portfolio.cash())
        .isEqualTo(0);
  }

  @Test
  public void buyTwoHoldingsIsValuedAtSumOfBothHoldings() throws Exception {
    Portfolio portfolio = new Portfolio();
    portfolio.deposit(200 * 125 + 100 * 90);

    portfolio.buy(200, "AAPL", 125, LocalDate.of(2020, 8, 28));
    portfolio.buy(100, "AMD", 90, LocalDate.of(2020, 8, 29));

    assertThat(portfolio.value())
        .isEqualTo(200 * 125 + 100 * 90);
  }

  @Test
  public void buySharesShouldReduceCash() throws Exception {
    Portfolio portfolio = new Portfolio();
    portfolio.deposit(10_000);

    portfolio.buy(10, "ZZZ", 100, LocalDate.now());

    assertThat(portfolio.cash())
        .isEqualTo(10_000 - 10 * 100);
  }

//  @Test
//  public void sellSharesRemovesHoldingAndIncreasesCashBalance() throws Exception {
//    Portfolio portfolio = new Portfolio();
//    portfolio.buy(200, "AAPL", 125, LocalDate.of(2020, 8, 28));
//
//    portfolio.sell(200, "AAPL", 131, LocalDate.of(2020, 9, 1));
//
//    assertThat(portfolio.value())
//        .isEqualTo(200 * 131);
//  }

}