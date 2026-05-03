package leetcode.medium;

public class GasStation {

    public static void main(String args[]) {

    GasStation g = new GasStation();
    g.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2});
}

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int idx = 0;
        int totalCost = 0;

        for(int i =0 ;i<gas.length; i++){
            total+=gas[i] - cost[i];
            totalCost+=gas[i] - cost[i];
            if(total<0){
                total = 0;
                idx = i+1;
            }
        }

        if(totalCost<0) return -1;

        return idx;
    }

}
