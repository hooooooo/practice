class Solution {
    class Item {
        public int digit;
        public char ch;
        public int[] letter;
        public Item(char ch, int digit, String letter){
            this.ch = ch;
            this.digit = digit;
            this.letter = new int[letter.length()];
            char arr[] = letter.toCharArray();
            for(int i = 0; i<this.letter.length; i++){
                this.letter[i] = arr[i] - 'a';
            }
        }
        public void run(int map[], int[] digits) {
             int index = ch - 'a';
             while(map[index] > 0){
                 for(int i = 0; i<this.letter.length; i++){
                    map[this.letter[i]] --;
                 }
                 digits[digit]++;
             }
        }
    }
    public String originalDigits(String s) {
        // zero, one, two, three, four, five, six, seven, eight, nine
        // z --> 0
        // w --> 2
        // x --> 6
        // u --> 4
        // s --> 7
        // o --> 1
        // v --> 5
        // g --> 8
        // i --> 9
        // t --> 3
        
        StringBuilder sb = new StringBuilder();
        // a --> z
        int digits[] = new int[10];
        int map[] = new int[26];
        char [] arr = s.toCharArray();
        for(char ch : arr){
            map[ch-'a'] ++;
        }
        List<Item> rules = new ArrayList<>(10);
        rules.add(new Item('z', 0, "zero"));
        rules.add(new Item('w', 2, "two"));
        rules.add(new Item('x', 6, "six"));
        rules.add(new Item('u', 4, "four"));
        rules.add(new Item('s', 7, "seven"));
        rules.add(new Item('o', 1, "one"));
        rules.add(new Item('v', 5, "five"));
        rules.add(new Item('g', 8, "eight"));
        rules.add(new Item('i', 9, "nine"));
        rules.add(new Item('t', 3, "three"));
        
        for(Item item : rules){
            item.run(map, digits);
        }
        
        for(int i = 0 ; i<digits.length; i++){
            while(digits[i]-- > 0){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
