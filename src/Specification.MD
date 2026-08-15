# Bank Account Management System — Project Spec

## What you're building
A console app that simulates a small bank. A user interacts through a text menu to create accounts, move money around, and check balances. The system keeps running until the user chooses to exit.

---

## Functional Requirements

### Accounts
- The system supports **two account types**: Savings and Current (checking).
- Every account has: an account number, the holder's name, and a balance.
- Account numbers must be unique — the system should reject a duplicate.

### Savings Account rules
- Has a **minimum balance of $100**. Any withdrawal that would drop the balance below $100 must be refused with a clear message.

### Current Account rules
- Allows an **overdraft up to -$500**. Any withdrawal that would push the balance below -$500 must be refused with a clear message.

### Operations the user can perform (menu)
1. **Create Account** — choose Savings or Current, provide a name, account number, and initial deposit. Confirm creation.
2. **Deposit Money** — enter an account number and amount. Balance increases. Refuse if account not found or amount is invalid (zero/negative).
3. **Withdraw Money** — enter an account number and amount. Balance decreases, subject to the rules above. Refuse if account not found or amount is invalid.
4. **Check Balance** — enter an account number, see the current balance. Refuse if account not found.
5. **Exit** — end the program gracefully.

### Input handling
- The system must handle bad input without crashing (letters when a number is expected, empty strings, etc.).
- Prompt the user again if input is invalid — don't just crash or silently skip.

### Optional stretch goals (do these only after the core works)
- **Transaction history** — every deposit and withdrawal is recorded per account, and the user can view the history for any account (add a menu option).
- **Transfer money** between two accounts (your own idea — nice one).
- **Delete an account** from the system.

---

## OOP Requirements
These are the design constraints — the project must demonstrate each of these:

| Principle | What it means for this project |
|---|---|
| **Abstraction** | You need a base type that cannot be created directly — it only serves as a template for the real account types. |
| **Inheritance** | Your two account types share most of their behaviour but differ in withdrawal rules. Don't duplicate the shared stuff. |
| **Polymorphism** | The system should be able to handle any account type through one common reference — the withdrawal logic picks the right rule at runtime. |
| **Encapsulation** | No field should be directly accessible from outside its class. Control access through methods. |

---

## Design checklist (think through these before coding)

Before you open IntelliJ, answer these questions for yourself:

- [ ] What are the "things" (classes) in this system?
- [ ] Which class is the abstract base? What fields and methods does it define?
- [ ] Which method needs to behave differently per account type? Should it be abstract?
- [ ] Where do you store all the accounts? Which class is responsible for that?
- [ ] Where does user input happen? Is it mixed into your business logic, or separated?
- [ ] How does your main method stay clean and readable?

---

## "It works" checklist (test these when you're done)

- [ ] Create a Savings account with $200 initial deposit
    - Deposit $50 → balance should be $250
    - Withdraw $120 → allowed, balance becomes $130
    - Withdraw $50 → **refused** (would drop below $100)
- [ ] Create a Current account with $0 initial deposit
    - Withdraw $400 → allowed, balance becomes -$400
    - Withdraw $200 → **refused** (would exceed -$500 overdraft)
- [ ] Check Balance shows the correct value for each account
- [ ] Try creating two accounts with the same number → **refused**
- [ ] Type "abc" when asked for a number → re-prompts, doesn't crash
- [ ] Exit option ends the program cleanly

---

## Suggested build order
1. Start with your abstract base — fields, constructor, the methods every account shares.
2. Build the two account subclasses — just the withdrawal logic that differs.
3. Build the class that manages all accounts (creating, finding, depositing, withdrawing).
4. Build input handling so bad input doesn't crash the app.
5. Build the main menu that ties it all together.
6. Test with the checklist above.
7. Optional: transaction history, transfers, account deletion.

---

Good luck. Build it piece by piece, test as you go.