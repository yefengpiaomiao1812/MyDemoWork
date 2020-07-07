package com.example.cg.java;

public class JavaTest implements JieKou{
    private int a = 0;
    protected String b = "1";
    public static final String c = "2";


    private void gotoShow(){

        String aaa = aa;

        Test test = new Test();
        test.gotoShow();
    }


    public Test getIntense(){
        return new Test();
    }

    @Override
    public void getA() {

    }

    @Override
    public void getBBB() {

    }


    protected class Test{
        private int a = 0;
        protected String b = "1";
        public static final String c = "2";


        public void show(){
            System.out.println(JavaTest.this.a);
            System.out.println(this.b);
            System.out.println(c);

            JavaTest.this.gotoShow();
        }

        private void gotoShow(){

        }
    }


    public static void main(String[] args) {
        CategoryDao categoryDao = new CategoryDao();

        String aa = "aaa";
        Integer bb = Integer.parseInt(aa);

    }
}
