
# Social Network Graph Analyzer

A graph-based social network simulation built in Java, implementing core graph algorithms including **Breadth-First Search (BFS)** for shortest path computation and mutual-connection-based **friend suggestions**.

---

# Features

| Feature | Description |
|---|---|
| Add / Remove User | Dynamically manage nodes in the graph |
| Add / Remove Friendship | Manage bidirectional edges |
| Show Friends | List direct connections for any user |
| Shortest Path (BFS) | Find the minimum-hop path between two users |
| Friend Suggestions | Recommend users based on mutual connections |

---

# How It Works

The network is modeled as an **undirected, unweighted graph** using a `HashMap<String, Set<String>>` adjacency structure.

```
Alice ── Bob ── David
  \           /
   Charlie ──
       \
        Eva
```

- **BFS** explores the graph level by level to guarantee the shortest path.
- **Friend Suggestions** scan 2nd-degree neighbors (friends-of-friends) not already connected.

---

# Project Structure

```
SocialNetGraph/
├── SocialNetGraph.java   # Main class: graph logic + CLI menu
```

---

# How to Run

```bash
# Compile
javac SocialNetGraph.java

# Run
java SocialNetGraph
```

Then use the interactive menu:

```
=== SocialNet Menu ===
1. Add User
2. Add Friendship
3. Remove User
4. Remove Friendship
5. Show Friends
6. Shortest Path
7. Suggest Friends
0. Exit
```

---

# Complexity

| Operation | Time Complexity |
|---|---|
| Add User / Friendship | O(1) |
| Remove User | O(degree(u)) |
| Show Friends | O(1) |
| Shortest Path (BFS) | O(V + E) |
| Friend Suggestions | O(degree²) |

---

# Tech Stack

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=openjdk)
![Data Structures](https://img.shields.io/badge/Data%20Structures-Graph-blue?style=flat-square)
![Algorithm](https://img.shields.io/badge/Algorithm-BFS-green?style=flat-square)

- **Language:** Java 21  
- **Data Structures:** HashMap, HashSet, Queue (ArrayDeque), ArrayList  
- **Algorithm:** Breadth-First Search (BFS)  
- **Paradigm:** Object-Oriented Programming  

---

# Academic Context

> **Course:** 231-CCS-4 — Data Structures and Algorithms  
> **Institution:** King Khalid University — College of Computer Science  
> **Year:** 2024–2025

---

## 👤 Author

**Osama Mohammed Al-Senany**  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-osama--mohammed--alsenani-blue?style=flat-square&logo=linkedin)](https://linkedin.com/in/osama-mohammed-alsenani)
[![GitHub](https://github.com/osama-alsenany/social-network-graph)](github.com/osama-alsenany)
