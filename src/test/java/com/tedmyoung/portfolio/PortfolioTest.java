package com.tedmyoung.portfolio;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PortfolioTest {
  @Test
  public void newPortfolioHasZeroValue() throws Exception {
    Portfolio portfolio = new Portfolio();

    assertThat(portfolio.value())
        .isZero();
  }
}