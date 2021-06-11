public class SeamCarving {
    static int[] carve_seam(int disruption[][]) {
        int[] seam = new int[disruption.length];
        int h = disruption.length;
        int w = disruption[0].length;

        int d[][]  = new int[h][w];
        int cost[][]  = new int[h][w];

        cost[h -1] = disruption[h -1];

        for(int i=h-1; i>=0; --i)
        {
            for(int j = 0; j <= w-1; j++) {
                cost[i][j] = disruption[i][j] + min(cost[i-1][j-1], cost[i-1][j], cost[i-1][j+1]);

                if(min(cost[i-1][j-1], cost[i-1][j], cost[i-1][j+1]) == cost[i-1][j-1]){
                    d[i][j] = -1;
                }
                else if(min(cost[i-1][j-1], cost[i-1][j], cost[i-1][j+1]) == cost[i-1][j]){
                    d[i][j] = 0;
                }
                else {
                    d[i][j] = 1;
                }
            }
        }

        int min_col = mini(cost[0]);

        seam[0] = min_col;

        for(int r=0; r<=h-2; r++){
            seam[r+1] = seam[r] + d[r][seam[r]];
        }

        return seam;
    }

    static int min(int c1, int c2, int c3){
        if (c1 <= c2 && c1 <= c3){
            return c1;
        }
        else if (c2 <= c1 && c2 <= c3){
            return c2;
        }
        else{
            return c3;
        }
    }

    static int mini(int[] c){
        int index = 0;
        int min = c[index];

        for (int i = 1; i < c.length; i++){
            if (c[i] <= min){
                min = c[i];
                index = i;
            }
        }
        return index;
    }
}
