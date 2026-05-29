# quiz8Datos

Este documento contiene el funcionamiento de los algoritmos implementadas y como ejecutarlos usando grafos de prueba.

---
# Estructura del proyecto:
-src:
--DemoMST.java
--Graph.java
--MSTSolver.java
-Quiz 8 Algoritmos a mano.pdf

El archivo `DemoMST`es el correspondiente para uso de pruebas, en este se pueden inicializar objetos de tipo `Graph` así como la clase estática `MSTSolver` para ejecutar los algoritmos de Prim y Kruskal.
Por otra parte el pdf `Quiz 8 Algoritmos a manoQuiz 8 Algoritmos a mano` corresponde al cálculo hecho a mano de los algoritmos, en todo caso sea ejecutado el caso de prueba pre-cargado debería tener los mismos resultados que se encuentran en este archivo.

# Cargar pruebas:
En caso de querer crear casos de prueba se deben seguir los siguientes pasos:
1.Crear un arreglo con el valor de los vértices.
2.Inicializar un nuevo objeto Graph con la cantidad de vértices.
3.Agregar los pesos entre los vértices utilizando la siguiente notación (Vorigen,Vdestino,peso)
**Example**
```java
String[] vertex = {"A", "B", "C", "D"}; //Creación del arreglo
Graph graph = new Graph(vertex.length); //Inicialización del objeto
//Agregar aristas.
graph.addEdge(0,1,2)
graph.addEdge(0,2,3)
graph.addEdge(2,3,1)
graph.addEdge(1,3,2)
```
Una vez tengamos el o los nodos listos utilizamos el objeto de `MSTSolver` previamente instanciado, y podemos ejecutar el algoritmo de Prim, Kruskal o ambos; pasando como argumento el grafo previamente creado.
**Example**
```java
MSTSolver solver = new MSTSolver();  //Instanciamos MSTSolver
solver.krustal(graph);
solver.prim(graph);
```
Ambos algoritmos se encargaran de evaluar el MST y de imprimir valores como el grafo resultante, el peso total y la cantidad de aristas.


