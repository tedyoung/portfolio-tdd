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
  }

  @Test
  public void buy200SharesAt125ValueIs25_000() throws Exception {
    Portfolio portfolio = new Portfolio();

    portfolio.buy(200, "AAPL", 125, LocalDate.of(2020, 8, 28));

    assertThat(portfolio.value())
        .isEqualTo(200 * 125);
  }

  @Test
  public void buyTwoHoldingsIsValuedAtSumOfBothHoldings() throws Exception {
    Portfolio portfolio = new Portfolio();

    portfolio.buy(200, "AAPL", 125, LocalDate.of(2020, 8, 28));
    portfolio.buy(100, "AMD", 90, LocalDate.of(2020, 8, 29));

    assertThat(portfolio.value())
        .isEqualTo(200 * 125 + 100 * 90);
  }

}