package com.tedmyoung.portfolio;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class PortfolioDisplayTest {

  @Test
  public void portfolioWith200SharesAt125DisplayedWithSymbolAndValue() throws Exception {
    Portfolio portfolio = new Portfolio();

    portfolio.buy(200, "AAPL", 125, LocalDate.of(2020, 8, 28));

    assertThat(portfolio.holdings())
        .containsExactlyInAnyOrder("2020-08-28 AAPL 200 125 25000");
  }

  @Test
  public void portfolioWithTwoHoldingsIsDisplayedProperly() throws Exception {
    Portfolio portfolio = new Portfolio();

    portfolio.buy(200, "AAPL", 125, LocalDate.of(2020, 8, 28));
    portfolio.buy(100, "AMD", 90, LocalDate.of(2020, 8, 29));

    assertThat(portfolio.holdings())
        .containsExactlyInAnyOrder("2020-08-28 AAPL 200 125 25000",
                                   "2020-08-29 AMD 100 90 9000");
  }

}
