READMI:

1) Creare database con DOCKER (Esempio):
    - docker run -d -p 5432:5432 --name my-postgres2 -e POSTGRES_PASSWORD=mysecretpassword postgres
    - per riattivarlo dopo averlo creato: docker restart 41ce91c8dc9e
2) su DBEVER effettuare la connessione con parametri:

    - localhost
    - porta: 5432
    - database: postgres
    - username: postgres
    - password: mysecretpassword
   
MAVEN COPY RESOURCE:
- da terminale: mvn process-resources