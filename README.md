# library-management-using-springBoot

### chahier de charge de l'application
On souhaite créer une application spring boot qui permet de gérer les
adhérents et les documents d’une bibliothèque. Chaque adhérent se caractérise par son
identificateur, nom, prénom, adresse, CIN et sa date de naissance. Il existe trois types de
documents, livre, revue, et dictionnaire. Chaque livre est définie par son identificateur, son
auteur, nombre des pages et le prix de vente. Une revue est définie par sa référence, année de
publication, prix de vente. Chaque dictionnaire est caractérisé par son identificateur, langue, et
prix de vente. L’emprunt d’un document par un adhérent est défini par un identificateur, la date
d’emprunt et la date de retour. L’application doit permettre de :
1 Page d’accueil permettre l’accès au trois volets de gestion d’adhérent, document, et des
emprunts,
2 Ajouter, modifier, supprimer, rechercher (par CIN) un adhérent,  
3 Ajouter, modifier, supprimer, rechercher (par Id) un document,  
4 Enregistrer, modifier, supprimer un emprunt,  
5 Consulter le profil d’un adhérent,  
6 Consulter la liste des documents existants pour chaque catégorie des documents,  
7 Consulter tous les documents,  
8 Consulter la liste des emprunts.  
Les données de l’application sont stockées dans une base de données MySQL. L’application  
est basée sur Spring Boot. Elle se compose de trois couches :  
1- La couche Model,  
2- La couche Controller,  
3- La couche Service,  
4- Une application web basée sur HTML, CSS, JS, …  
