package com.tedmyoung.portfolio;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class HoldingValueTest {

  @Test
  public void holdingOfStockUsesPresentValueForHoldingValue() throws Exception {
    Holding holding = new Holding(1, "AAPL", 125, LocalDate.now());

    assertThat(holding.valueAtPriceOf(130))
        .isEqualTo(130);
  }

}
