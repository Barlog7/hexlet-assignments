package exercise;

// BEGIN
class ReversedSequence implements CharSequence {
    String text;
    public ReversedSequence(String text) {
        StringBuilder input1 = new StringBuilder(text);
        this.text = input1.reverse().toString();
    }

    @Override
    public int length() {
        return this.text.length();
    }

    @Override
    public char charAt(int index) {
        return this.text.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.text.substring(start, end);
    }
    @Override
    public String toString() {
        return this.text;
    }
}
// END
