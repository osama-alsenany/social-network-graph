import java.util.*;

public class SocialNetGraph {

    private final Map<String, Set<String>> graph = new HashMap<>();

    public void addUser(String user) {
        graph.putIfAbsent(user, new HashSet<>());
    }

    public void removeUser(String user) {
        if (graph.containsKey(user)) {

            for (String friend : graph.get(user)) {
                graph.get(friend).remove(user);
            }

            graph.remove(user);
        }
    }

    public void addFriend(String u1, String u2) {
        addUser(u1);
        addUser(u2);

        graph.get(u1).add(u2);
        graph.get(u2).add(u1);
    }

    public void removeFriend(String u1, String u2) {
        Optional.ofNullable(graph.get(u1)).ifPresent(f -> f.remove(u2));
        Optional.ofNullable(graph.get(u2)).ifPresent(f -> f.remove(u1));
    }

    public Set<String> getFriends(String user) {
        return graph.getOrDefault(user, Collections.emptySet());
    }

    public List<String> shortestPath(String start, String goal) {
        if (!graph.containsKey(start) || !graph.containsKey(goal)) {
            return List.of();
        }

        Queue<List<String>> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        q.add(List.of(start));
        visited.add(start);

        while (!q.isEmpty()) {
            List<String> path = q.remove();
            String last = path.get(path.size() - 1);

            if (last.equals(goal)) {
                return path;
            }

            for (String nbr : graph.get(last)) {
                if (!visited.contains(nbr)) {
                    visited.add(nbr);

                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(nbr);

                    q.add(newPath);
                }
            }
        }

        return List.of();
    }

    public Set<String> suggestFriends(String user) {
        Set<String> suggestions = new HashSet<>();
        Set<String> direct = getFriends(user);

        for (String friend : direct) {
            for (String friendOfFriend : getFriends(friend)) {
                if (!friendOfFriend.equals(user) && !direct.contains(friendOfFriend)) {
                    suggestions.add(friendOfFriend);
                }
            }
        }

        return suggestions;
    }

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Student ID: 444802199 | Name: Osama Mohammed Al-Senani | Section: 521");

        SocialNetGraph sn = new SocialNetGraph();

        while (true) {
            System.out.println("""
                    
                    === SocialNet Menu ===
                    1. Add User
                    2. Add Friendship
                    3. Remove User
                    4. Remove Friendship
                    5. Show Friends
                    6. Shortest Path
                    7. Suggest Friends
                    0. Exit
                    Choice? """);

            int ch = Integer.parseInt(in.nextLine().trim());

            switch (ch) {
                case 1 -> {
                    System.out.print("User name: ");
                    sn.addUser(in.nextLine().trim());
                }

                case 2 -> {
                    System.out.print("User A: ");
                    String a = in.nextLine().trim();

                    System.out.print("User B: ");
                    String b = in.nextLine().trim();

                    sn.addFriend(a, b);
                }

                case 3 -> {
                    System.out.print("User to delete: ");
                    sn.removeUser(in.nextLine().trim());
                }

                case 4 -> {
                    System.out.print("User A: ");
                    String a = in.nextLine().trim();

                    System.out.print("User B: ");
                    String b = in.nextLine().trim();

                    sn.removeFriend(a, b);
                }

                case 5 -> {
                    System.out.print("User name: ");
                    String u = in.nextLine().trim();

                    System.out.println("Friends: " + sn.getFriends(u));
                }

                case 6 -> {
                    System.out.print("Start user: ");
                    String s = in.nextLine().trim();

                    System.out.print("Goal user: ");
                    String g = in.nextLine().trim();

                    System.out.println("Path: " + sn.shortestPath(s, g));
                }

                case 7 -> {
                    System.out.print("User name: ");
                    String u = in.nextLine().trim();

                    System.out.println("Suggestions: " + sn.suggestFriends(u));
                }

                case 0 -> {
                    System.out.println("Bye!");
                    return;
                }

                default -> System.out.println("Invalid option.");
            }
        }
    }
}