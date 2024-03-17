package 신규아이디추천;

public class kakao_신규아이디추천 {

    public String solution(String new_id) {
        String answer = "";

        // (1)
        new_id = new_id.toLowerCase();
        System.out.println("(1) " + new_id);

        // (2)
        // StringBuffer sb = new StringBuffer();
        // for (char ch : new_id.toCharArray()) {
        //     if ((ch >= 'a' && ch <= 'z') || (ch >='0' && ch <= '9')
        //         || ch == '-' || ch == '_' || ch == '.') {
        //         sb.append(ch);
        //     }
        // }
        // new_id = sb.toString();
        // --
        new_id = new_id.replaceAll("[^0-9a-z-_.]", "");
        System.out.println("(2) " + new_id);

        // (3)
        // new_id = new_id.replaceAll("\\.{2,}", ".");
        new_id = new_id.replaceAll("[.]{2,}", ".");
        System.out.println("(3) " + new_id);

        // (4)
        //new_id = new_id.replaceAll("^\\.|\\.$", "");
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        System.out.println("(4) " + new_id);

        // (5)
        if (new_id.isEmpty())
            new_id = "a";
        //System.out.println("(5) " + new_id);

        // (6)
        if (new_id.length() >= 16)
            new_id = new_id.substring(0, 15);
        //new_id = new_id.replaceAll("^\\.|\\.$", "");
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        System.out.println("(6) " + new_id);

        // (7)
        while (new_id.length() <= 2) {
            new_id += new_id.charAt(new_id.length() - 1);
        }
        //System.out.println(new_id);

        answer = new_id;

        return answer;
    }
}
