### 📚 Estudo sobre Collections em Java
Este repositório contém exemplos práticos e conceitos fundamentais sobre Collections em Java, incluindo Comparable, Comparator, Generics e as principais interfaces: List, Set e Map.

## 📌 Conceitos Abordados
### 1. Comparable e Comparator
Comparable: Interface usada para definir a ordenação natural de objetos.

Comparator: Interface para definir ordenações customizadas.

Diferenças: Comparable define "como" um objeto é comparado (ordenação natural), enquanto Comparator permite múltiplas formas de comparação.

Exemplo prático: Livro.java e Main.java demonstram ordenação por título (Comparable), autor, ano e combinações (Comparator).

### 2. Generics
Permitem criar classes, interfaces e métodos com tipos parametrizados.

Vantagens: Segurança de tipo em tempo de compilação e eliminação de casts.

Exemplos:

- GenericsExempleList.java

 - GenericsExempleSet.java

 - GenericsExempleMap.java

### 3. Principais Interfaces de Collections
📋 List
Coleção ordenada que permite elementos duplicados.

Implementações comuns: ArrayList, LinkedList.

Exemplo prático: CarrinhoDeCompras.java e Item.java mostram operações básicas com listas.

🎯 Set
Coleção que não permite elementos duplicados.

Implementações comuns: HashSet, TreeSet.

Exemplo: GenericsExempleSet.java

🗺️ Map
Armazena pares chave-valor, onde cada chave é única.

Implementações comuns: HashMap, TreeMap.

Exemplo: GenericsExempleMap.java

### 4. Ordenação
Métodos úteis: Collections.sort(), List.sort()

Exemplo: OrdenacaoNumeros.java mostra ordenação ascendente e descendente.

# 🚀 Como Executar os Exemplos
Clone o repositório

Importe os projetos em sua IDE Java favorita

Execute os métodos main das classes de exemplo

# 💡 Aprendizados Chave
- Como implementar ordenação natural com Comparable e compareTo

- Como criar ordenações customizadas com Comparator

- Benefícios do uso de Generics em Collections

- Diferenças fundamentais entre List, Set e Map

- Operações básicas com coleções (adição, remoção, iteração, ordenação)

# 📚 Recursos Adicionais
Documentação oficial Java Collections

Java Generics Tutorial

<h3 style="color:green">Este projeto serve como um guia prático para entender os conceitos fundamentais de Collections em Java, essenciais para qualquer desenvolvedor Java.<h3>