package leetcode.hard;

import java.util.*;

public class ReconstructItinerary {

    public static void main(String args[]) {
        ReconstructItinerary r = new ReconstructItinerary();
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));

        tickets.add(Arrays.asList("JFK", "XYZ"));
        tickets.add(Arrays.asList("XYZ", "JFK"));

        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("SFO", "JFK"));

        tickets.add(Arrays.asList("SFO", "AAA"));
        tickets.add(Arrays.asList("AAA", "SFO"));
        tickets.add(Arrays.asList("SFO", "BBB"));
        tickets.add(Arrays.asList("BBB", "SFO"));
//        tickets.add(Arrays.asList("ATL", "DDD"));
//        tickets.add(Arrays.asList("DDD", "ATL"));
//        tickets.add(Arrays.asList("ATL", "EEE"));
//        tickets.add(Arrays.asList("EEE", "ATL"));
//        tickets.add(Arrays.asList("ATL", "FFF"));
//        tickets.add(Arrays.asList("FFF", "ATL"));
//        tickets.add(Arrays.asList("ATL", "GGG"));
//        tickets.add(Arrays.asList("GGG", "ATL"));
//        tickets.add(Arrays.asList("ATL", "HHH"));
//        tickets.add(Arrays.asList("HHH", "ATL"));
//        tickets.add(Arrays.asList("ATL", "III"));
//        tickets.add(Arrays.asList("III", "ATL"));
//        tickets.add(Arrays.asList("ATL", "JJJ"));
//        tickets.add(Arrays.asList("JJJ", "ATL"));
//        tickets.add(Arrays.asList("ATL", "KKK"));
//        tickets.add(Arrays.asList("KKK", "ATL"));
//        tickets.add(Arrays.asList("ATL","LLL"));
//        tickets.add(Arrays.asList("LLL","ATL"));
//        tickets.add(Arrays.asList("ATL","MMM"));
//        tickets.add(Arrays.asList("MMM","ATL"));
//        tickets.add(Arrays.asList("ATL","NNN"));
//        tickets.add(Arrays.asList("NNN","ATL"));


//        List<List<String>> tickets = new ArrayList<>();
//        tickets.add(Arrays.asList("JFK","SFO"));
//        tickets.add(Arrays.asList("JFK","ALT"));
//        tickets.add(Arrays.asList("SFO","JFK"));
//        tickets.add(Arrays.asList("ALT","AAA"));
//        tickets.add(Arrays.asList("AAA","ALT"));
//        tickets.add(Arrays.asList("BBB","ALT"));
//        tickets.add(Arrays.asList("ALT","BBB"));

        System.out.println(r.findItinerary(tickets));

    }

    //This algorithm explores the path based on the smallest lexical order.
    //when we encounter the vertex which has not more paths to explore algorithm adds the vertex in reverse order (Bottom up approach)
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        List<String> res = new ArrayList<>();

        for(List<String> t : tickets){
            if(!graph.containsKey(t.getFirst()))
                graph.put(t.getFirst(), new PriorityQueue<>());

            graph.get(t.getFirst()).add(t.get(1));
        }

        createItinerary("JFK", graph, res);

        return res;
    }

    public void createItinerary(String src, Map<String, PriorityQueue<String>> graph, List<String> res) {
        PriorityQueue<String> nextAirport = graph.get(src);
        while (nextAirport !=null && !nextAirport.isEmpty()) {
            createItinerary(nextAirport.poll(), graph, res);
        }
        res.addFirst(src);
    }
}

