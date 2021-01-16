public class Java2HomeWork5 {
    static int size = 1000000;
    static int n = 8;

    public static long oneStream() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
        }
        return (System.currentTimeMillis() - a);
    }

    public static long twoStreams() {
        final int h = size / 2;
        final float[] arr = new float[size];
        final float[] arr1 = new float[h];
        final float[] arr2 = new float[h];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < h; i++) {
                    arr1[i] = (float) (arr1[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < h; i++) {
                    arr2[i] = (float) (arr2[i] * Math.sin(0.2f + (float) (i + h) / 5) * Math.cos(0.2f + (float) (i + h) / 5) * Math.cos(0.4f + (float) (i + h) / 2));
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return (System.currentTimeMillis() - a);
    }


    public static long severalStreams(int n, int size) {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        if (size % n == 0) {
            final int sizeArr1 = size / n;
            final float[][] arr1 = new float[n][sizeArr1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < sizeArr1; j++) {
                    arr1[i][j] = arr[j + (i * sizeArr1)];
                }
            }

            Thread[] threads = new Thread[n];
            for (int i = 0; i < n; i++) {
                final int finalI = i;
                threads[i] = new Thread(new Runnable() {
                    public void run() {
                        for (int j = 0; j < sizeArr1; j++) {
                            arr1[finalI][j] = (float) (arr1[finalI][j] * Math.sin(0.2f + (float) (j + (finalI * sizeArr1)) / 5) * Math.cos(0.2f + (float) (j + (finalI * sizeArr1)) / 5) * Math.cos(0.4f + (float) (j + (finalI * sizeArr1)) / 2));
                        }
                    }
                });
                threads[i].start();
            }

            for (int i = 0; i < threads.length; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < sizeArr1; j++) {
                    arr[j + (i * sizeArr1)] = arr1[i][j];
                }
            }

        } else System.out.println("Количество элементов нацело не делится на количество потоков");

        return System.currentTimeMillis() - a;
    }

    public static void main(String[] args) {

        System.out.printf("Операция в один поток для %d элементов занимает: " + oneStream() + " мс\n", size);
        System.out.printf("Операция в два потока для %d элементов занимает: " + twoStreams() + " мс\n", size);
        System.out.printf("Операция в два %d потока для %d элементов занимает: " + severalStreams(n, size) + " мс\n", n, size);

    }

}
