public class EditDistance {
    public static int editDistance(String word1, String word2) {
        int w1 = word1.length();
        int w2 = word2.length();
        int temp[][] = new int[w1+1][w2+1];

        for(int i = 0; i <= w1; i++)
        {
            for(int j = 0; j <= w2; j++) {
                if (i == 0) {
                    temp[i][j] = j;
                } else if (j == 0) {
                    temp[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    temp[i][j] = temp[i - 1][j - 1];
                } else {
                    temp[i][j] = 1 + minimum(temp[i][j - 1], temp[i - 1][j], temp[i - 1][j - 1]);
                }
            }
        }
        return temp[w1][w2];
    }

    static int minimum(int insert, int delete, int replace){
        if (insert <= delete && insert <= replace){
            return insert;
        }
        else if (delete <= insert && delete <= replace){
            return delete;
        }
        else{
            return replace;
        }
    }
}