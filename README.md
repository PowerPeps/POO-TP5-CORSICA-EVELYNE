# Gestion d'une régate

Ce projet est une application Java permettant l'organisation d'une régate (course de voiliers). 
Il permet de gérer les inscriptions des bateaux et équipages, d'enregistrer les temps réalisés, et d'afficher les résultats. 
L'application respecte les principes de la Programmation Orientée Objet (POO) et met en œuvre des concepts tels que l'héritage et l'abstraction.

## Fonctionnalités

- **Gestion des équipiers et équipages** :
  - Création d'équipiers avec leurs spécialités.
  - Gestion des équipages, avec un capitaine et des marins.

- **Gestion des bateaux** :
  - Différents types de bateaux : Monocoques et Multicoques.
  - Calcul des temps pondérés en fonction du type de bateau.

- **Gestion des courses** :
  - Inscription de bateaux avec leurs équipages.
  - Enregistrement des temps réalisés par chaque bateau.
  - Détermination et affichage des gagnants.

- **Interface console (IHM)** :
  - Saisie interactive des équipages, bateaux, et temps via la console.

## Structure du projet

Le projet est organisé en plusieurs classes pour représenter les différents éléments :

| Classe          | Rôle                                                                      |
|------------------|--------------------------------------------------------------------------|
| `Equipier`      | Représente un membre d'équipage, avec un nom et une spécialité.           |
| `Equipage`      | Représente un équipage avec un capitaine et une liste de marins.          |
| `Bateau`        | Classe abstraite représentant un bateau participant.                      |
| `MonoCoque`     | Hérite de `Bateau` pour les bateaux monocoques.                           |
| `MultiCoque`    | Hérite de `Bateau` pour les bateaux multicoques.                          |
| `Course`        | Gère l'inscription des bateaux, le calcul des gagnants, et les résultats. |
| `GestionCourse` | Contient le `main` pour tester les fonctionnalités principales.           |
| `IHMCourse`     | Permet la saisie utilisateur des informations pour configurer une course. |

## Diagrammes UML

Les diagrammes UML des classes principales et de l'IHM sont inclus dans le projet au format PlantUML. 
Vous pouvez les visualiser avec un outil compatible.

## Prérequis

- **Java** : Version 8 ou supérieure.
- **Compilateur** : Compatible avec les projets Java (ex. `javac`).
- **Outils facultatifs** : Un éditeur supportant PlantUML pour visualiser les diagrammes.

## Installation et Exécution

1. **Clonez le dépôt** :
   ```bash
   git clone https://github.com/PowerPeps/POO-TP5-CORSICA-EVELYNE.git
   cd gestion-regate
   ```

2. **Compilez les fichiers Java** :
   ```bash
   javac *.java
   ```

3. **Exécutez la classe principale `GestionCourse`** :
   ```bash
   java GestionCourse
   ```

4. **Pour tester l'IHM** :
   - Modifiez le `main` dans `GestionCourse` pour utiliser `IHMCourse`.
   - Exécutez comme suit :
     ```bash
     java GestionCourse
     ```

## Exemple de Résultat

Voici un exemple de sortie pour une course :

```
Résultats de la régate : Course du Vent
Le grand gagnant est Java de Jean(barreur)(monocoque)
Il y avait 2 participants
Le bateau Java de Jean(barreur) a réalisé un temps pondéré de 240.00 mn
Le bateau Tango de Pierre(barreur) a réalisé un temps pondéré de 750.00 mn
```

## Auteurs

- **Enseignant** : Evelyne V., Ghinevra C.
- **Étudiant** : Papillon

## Licence

Ce projet est sous licence académique. Toute reproduction ou redistribution non autorisée est interdite. L'auteur vous informe que toute reproduction est autorisé.

---

Si vous avez des questions ou souhaitez contribuer, n'hésitez pas à contacter l'auteur.
