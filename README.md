#TP 7 — Hibernate : Cache et optimisation des performances
##1. Structure du projet

Cette capture présente l’organisation du projet Java utilisant Hibernate, JPA et H2.

<img width="436" height="385" alt="Screenshot 2026-10-17 234239" src="https://github.com/user-attachments/assets/97e9a04a-6771-4615-b5c6-655878d24a80" />
##2. Test sans cache

Dans ce test, nous mesurons le temps d’exécution de la récupération des auteurs sans utiliser JOIN FETCH.

Résultat obtenu : 101 ms

<img width="494" height="633" alt="Screenshot 2026-10-17 234517" src="https://github.com/user-attachments/assets/b6880d82-9c69-4dcb-87c5-3bb4a721fd9d" />

##3. Test avec JOIN FETCH

JOIN FETCH permet de récupérer les auteurs et leurs livres dans une seule requête SQL, afin de limiter les requêtes supplémentaires liées au chargement des associations.

Résultat obtenu : 17 ms

<img width="499" height="724" alt="Screenshot 2026-10-17 234543" src="https://github.com/user-attachments/assets/35d80f44-c9d4-45b9-9061-cb10ed0cdc13" />


##4. Test avec Entity Graph

Entity Graph permet de préciser les associations à charger avec les entités. Dans ce test, nous demandons le chargement des livres associés aux auteurs.

Résultat obtenu : 10 ms
<img width="458" height="369" alt="Screenshot 2026-10-17 234611" src="https://github.com/user-attachments/assets/b2a3ef43-d2c5-485e-908b-0c100f305a54" />



##5. Test avec le cache de second niveau

Ce test mesure le temps de la deuxième lecture après une première lecture utilisant JOIN FETCH.

Résultat obtenu : 3 ms
<img width="530" height="723" alt="Screenshot 2026-10-17 234652" src="https://github.com/user-attachments/assets/d4ab344c-c80a-42ea-9420-5222b3a723da" />


Conclusion

Les tests montrent une amélioration du temps d’exécution avec les différentes méthodes d’optimisation. JOIN FETCH permet de récupérer les associations dans une même requête, tandis que Entity Graph permet de contrôler les associations à charger. La deuxième lecture affiche le temps le plus faible, avec 3 ms.

Ces résultats correspondent aux mesures obtenues lors de cette exécution et peuvent varier selon les conditions d’exécution.
