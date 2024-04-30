class MyTestingClass {
    private String id;

    public MyTestingClass(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int h = 17;
        for(int i = 0;i<id.length();i++) {
            h = h* 17 + id.charAt(i);
        }

        return h;

    }

}