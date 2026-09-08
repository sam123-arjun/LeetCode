class Solution {
public:
    int maximumWealth(vector<vector<int>>& accounts) {
            int ans = INT_MIN;

        for (int person = 0; person < accounts.size(); person++) {
            int sum = 0;

            for (int account = 0; account < accounts[person].size(); account++) {
                sum += accounts[person][account];
            }

            if (sum > ans) {
                ans = sum;
            }
        }

        return ans;
        
    }
};