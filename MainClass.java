public class MainClass {
    static final int size = 10000000;
    static final int h = size / 2;
    public static void main(String[] args) {
        MainClass e1 = new MainClass();
        System.out.println("Start");
        new Thread(() -> e1.method1()).start();
        new Thread(() -> e1.method2()).start();
    }
    public synchronized void method1() {

        float[] arr = new float[size];
        for (int i = 0 ; i < size ; i ++) {
            arr[i] = 1 ;
        }
        long a = System.currentTimeMillis();
        calc(arr);
        System.out.println(System.currentTimeMillis() - a + " метод 1");

    }
    public synchronized void method2() {
        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        for (int i = 0 ; i < size ; i ++) {
            arr[i] = 1 ;
        }

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        new Thread() {
            public void run() {
                float[] a1 = calc(arr1);
                System.arraycopy(a1, 0, arr1, 0, a1.length);
            }
        }.start();

        new Thread() {
            public void run() {
                float[] a2 = calc(arr2);
                System.arraycopy(a2, 0, arr2, 0, a2.length);
            }
        }.start();

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println((System.currentTimeMillis() - a)+ " метод 2");
    }
    public float[] calc(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }
}


