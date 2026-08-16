# Bank Account Management System

A console-based banking application built in Java as a Day 20 OOP capstone project. The system lets users create accounts, deposit, withdraw, transfer money between accounts, and view full transaction history — all through a text menu interface.

## Features

- **Two account types** with different rules:
  - Saving Account — minimum balance of £100
  - Current Account — overdraft allowed up to -£500
- **Account operations** — create, login, deposit, withdraw, transfer, delete
- **Transaction history** — every deposit, withdrawal, and transfer is recorded per account
- **Transfer between accounts** — validates sender's balance rules before transferring, records correctly in both accounts' histories
- **Input validation** — handles invalid input without crashing, re-prompts the user

## OOP Principles

| Principle | Implementation |
|---|---|
| Abstraction | `Account` is an abstract class that cannot be instantiated directly |
| Inheritance | `SavingAccount` and `CurrentAccount` extend `Account`, sharing deposit/transfer/history logic |
| Polymorphism | `withdraw()` is overridden per account type — runtime dispatch picks the correct rule |
| Encapsulation | `protected` fields, `private` Scanner and validators, access controlled through methods |

## Class Structure

```
Account (abstract)
├── SavingAccount — enforces £100 minimum balance on withdrawals
├── CurrentAccount — allows overdraft up to -£500
Menu — handles all user-facing menus and input validation
BankAccountManagementSystem — main class, application loop, business logic
```

## How to Run

1. Clone the repository
2. Open in IntelliJ IDEA (or any Java IDE)
3. Run `BankAccountManagementSystem.java`

## What I Learned

- Designing a class hierarchy from a specification before writing code
- Separating UI (Menu) from business logic (main class) from domain rules (Account subclasses)
- Refactoring method return types (`void` → `boolean`) when callers need to check outcomes
- Handling `null` returns from search methods to avoid `NullPointerException`
- Recording transactions correctly across both sides of a transfer
