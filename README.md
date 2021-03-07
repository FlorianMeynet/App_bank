# App_bank
This repository is my Bank App using the API : 
- https://60102f166c21e10017050128.mockapi.io/labbbank/accounts/
- https://60102f166c21e10017050128.mockapi.io/labbbank/config/

Every think had been code in Java using Android studio

We have 2 activities in this app, the first one is for the page of loging where we put our bank_id and the second one is for looking into our bank account.

When we have been log one time the app remembers us and after we dont need to log anymore, to do this I use a shared preferences where i save my ID after the first connexion and where i find the ID for all other connexion.

In the second page we have a spiner with the list of all our bank accounts. For each you can find the Iban, the amount and the currency and you can also switch between account.
