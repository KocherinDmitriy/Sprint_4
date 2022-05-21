public class Account {

    private final String name;


    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        if (name == null) {
            return false;
        } else {
            if (name.length() < 3 || name.length() > 19) {
                return false;
            } else {
                if (checkNameToSpace() > 1) {
                    return false;
                } else {
                    if (name.startsWith(" ") || name.endsWith(" ")) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }
    }


    public int checkNameToSpace() {
        char[] ch = name.toCharArray();
        int count = 0;
        for (char temp : name.toCharArray()) {
            if (Character.isWhitespace(temp)) {
                count++;
            }
        }
        return count;
    }
}
