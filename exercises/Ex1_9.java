class Ex1_9 {
    public static void main(String[] args) {
        String s = "Hello";
        String t = "Hel";
        String u = "lo";
        String v = t + u;
        System.out.printf("%s.equals(%s)? %s\n", s, v, s.equals(v));
        System.out.printf("%s == %s? %s\n", s, v, s == v);
    }
}
