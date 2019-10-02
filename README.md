# small

Écrivez une fonction « partition » qui prend un paramètre « liste » et un paramètre
« taille » et retourne une liste de sous liste, où chaque sous liste a au maximum
« taille » éléments.
Exemples d&#39;entrées et sorties : 
  
  * partition([1,2,3,4,5], 2) retourne: [ [1,2], [3,4], [5] ]
  * partition([1,2,3,4,5], 3) retourne: [ [1,2,3], [4,5] ]
  * partition([1,2,3,4,5], 1) retourne: [ [1], [2], [3], [4], [5] ]


1. Source code: /src/main/java/algo/ListUtil
2. Unit Test    /src/test/java/algo/ListUtilTest (6 test cases)
3. To Run tests:  mvn clean test 
