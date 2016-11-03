public class Solution {
    public String frequencySort(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] arrS = s.split("");
        for(String str : arrS) {
            if(!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                int totalCount = map.get(str) + 1;
                map.put(str, totalCount);
            }
        }
        Iterator it = map.entrySet().iterator();
        
        Comparator<words> comparator = new Comparator<words>() {
            @Override
            public int compare(words o1, words o2) {
                if(o1.getCount() <= o2.getCount()) {
                    return 0;    
                } else {
                    return 1;
                }
            }
        };
        
        PriorityQueue<words> prio = new PriorityQueue<>(10, comparator);
        
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            words word = new words(pair.getKey().toString(), Integer.parseInt(pair.getValue().toString()));
            prio.add(word);
            it.remove(); 
        }
        StringBuilder builder = new StringBuilder();
        while(!prio.isEmpty()) {
            words word = prio.poll();
            for(int i = 0; i < word.getCount(); i++) {
                builder.append(word.getWord());
            }
        }
        return builder.toString();
    }
    
    class words { 
        String word;
        int count;
        public words(String word, int count) {
            this.word = word;
            this.count = count;
        }
        
        public String getWord() {
            return this.word;
        }
        
        public int getCount() {
            return this.count;
        }

    }
}