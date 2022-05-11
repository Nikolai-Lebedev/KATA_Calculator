public enum ConvertToArabic {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);
    public int value;
    ConvertToArabic(int value) {
        this.value = value;
    }
    public int toInt() {
        return value;
    }
    static boolean itsRoman(String num) {
        boolean result = false;
        for (ConvertToArabic direction : values()) {
            if (direction.name().equals(num)) {
                result = true;
                break;
            }
        }
        return result;
    }
    static boolean itsArabic(String numx) {
        boolean result = false;
        int num;
        try {
            num = Integer.parseInt(numx);
        } catch (NumberFormatException e) {
            return false;
        }
        for (ConvertToArabic direction : values()) {
            if (direction.value == num) {
                result = true;
                break;
            }
        }
        return result;
    }
}
