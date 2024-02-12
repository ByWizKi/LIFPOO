# LIFPOO

## Note TP1

### Somme des n entiers avec le passage en parametre

```
public class premier_prog {
  public static void main (String args []){
    String maChaine = args [0];
    int monEntier = Integer.parseInt(maChaine);
    int res = 0;
    for(int i = 0; i <= monEntier; i++){
      res += i;
    };
    System.out.println(res);
  };
};
```

###Somme des n entiers sous la forme de 1/n

```
  public static void main (String args []){
    String maChaine = args[0];
    int monEntier = 0;
    monEntier = Integer.parseInt(maChaine);
    double res = 1.0;
    for(int i = 1; i <= monEntier; i++){
     res += 1/i;
    }
    System.out.println(res);
  };
```

## Partie 2 : Premier objet composite
Rien a note 

## Partie 3 : J'utilise VsCode

## Partie 4 Petit Test
1. Pour cahque cas le code est-t'il correct ?
  ```
  String s = "j'ai mange" + 4 + "pommes";
  ```
  Fonctionne car java parse l'entier en une string
  ```
  int somme = "quatre" + 2;
  Fonctinne pas car on peut pas parser un string
2. Que vaut b **b vaut 2**
```
int a = 2;
int b = a;
a += 1;
```
3. Que vaut b **b vaut 2**
```
Integer a  = new Interger(2);
Integer b = a;
a =null;
```