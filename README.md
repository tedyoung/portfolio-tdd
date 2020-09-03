# Getting Started

Test-driving the development of a simple stock portfolio tracking system.

## Simplifying Assumptions

* USA stock symbols for sample data
* Pricing in whole dollars (stored as an int)
* Currency is in $
* Equities
* Transactions have date without time
* Console (terminal) based interface to start with

## Features

* Open portfolio with initial deposit

* View total value of portfolio
    * Cash
    * Stock holdings current value

* Buy a stock, enter:
    * Symbol
    * Quantity
    * Share price
    * Date

* Sell a stock, enter:
    * Symbol
    * Quantity
    * Share price
    * Date

### Optional

* Close a position, enter:
    * Symbol
    * Price sold
    * (uses today's date)

* View transactions

* Obtain pricing data from https://iexcloud.io/docs/api/#rest-how-to
    * https://iexcloud.io/docs/api/#quote
    * Sample: https://sandbox.iexapis.com/stable/stock/AAPL/quote?token=Tpk_c8187b42b499474fafb1cb44c3175c87

## Concrete Examples

* Open a portfolio and deposit $10,000 -- G/W/T
    Given a new portfolio
    When I deposit 10,000
    Then its value is 10,000

* Purchase 200 shares of AAPL at $125 on 2020/08/28 -- G/W/T
    Given a new portfolio
    When I purchase 200 shares of AAPL at $125 on 2020/08/28
    Then its value is 200*125

* View Portfolio shows 200 shares of aapl valued at $25,000

* View portfolio:
    Given a portfolio with cash balance and a stock holding
    When we ask it to be displayed
    Then it displays two items: one for the cash and one for the stock holding

* Sell 200 shares of AAPL at $131 on 2020/09/01
    Given a portfolio with 200 shares of AAPL
    When we sell 200 shares at $131
    Then increases cash by 200*131
    And removes holding from portfolio
    
* View portfolio shows present value of stock holdings based on current prices

