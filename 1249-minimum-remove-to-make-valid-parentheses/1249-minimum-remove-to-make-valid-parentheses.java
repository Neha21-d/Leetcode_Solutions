class Solution {
    public String minRemoveToMakeValid(String s) {
        List<Character> list = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetter(ch)) {
                list.add(ch);
            }
            else if (ch == '(') {
                list.add(ch);
                cnt++;
            }
            else if (ch == ')') {
                if (cnt == 0) {
                    continue;
                }
                else {
                    cnt--;
                    list.add(ch);
                }
            }
        }

        for (int i = list.size() - 1; i >= 0 && cnt > 0; i--) {
            if (list.get(i) == '(') {
                list.remove(i);
                cnt--;
            }
        }

        StringBuilder result = new StringBuilder();

        for (char ch : list) {
            result.append(ch);
        }

        return result.toString();
    }
}