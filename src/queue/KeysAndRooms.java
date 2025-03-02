package queue;


import java.util.*;

public class KeysAndRooms {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms){
        Set<Integer> roomsVisited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        roomsVisited.add(0);
        for (int nextRoom: rooms.getFirst()){
            queue.add(nextRoom);
            roomsVisited.add(nextRoom);
        }
        while (!queue.isEmpty()){
            int room = queue.poll();
            for (int nextRoom: rooms.get(room)){
                if (roomsVisited.contains(nextRoom)){
                    continue;
                }
                queue.add(nextRoom);
                roomsVisited.add(nextRoom);
            }
        }
        return roomsVisited.size() == rooms.size();
    }


    public static void main(String[] args) {
        List<List<Integer>> rooms = List.of(
                List.of(1), List.of(2), List.of(3), List.of()
                );
        System.out.println(canVisitAllRooms(rooms));

        List<List<Integer>> rooms1 = List.of(
                List.of(1,3), List.of(3,0,1), List.of(2), List.of(0)
        );
        System.out.println(canVisitAllRooms(rooms1));
    }
}
