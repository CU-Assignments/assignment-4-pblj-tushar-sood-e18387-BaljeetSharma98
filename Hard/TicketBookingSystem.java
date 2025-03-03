import java.util.*;

class TicketBookingSystem {
    private static final int TOTAL_SEATS = 10;
    private static boolean[] seats = new boolean[TOTAL_SEATS];
    private static final Object lock = new Object();

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            threads.add(new Thread(new BookingTask("VIP", i), "VIP" + i));
        }
        for (int i = 5; i < 10; i++) {
            threads.add(new Thread(new BookingTask("Regular", i), "Regular" + i));
        }
        
        for (Thread t : threads) {
            if (t.getName().startsWith("VIP")) {
                t.setPriority(Thread.MAX_PRIORITY);
            } else {
                t.setPriority(Thread.MIN_PRIORITY);
            }
            t.start();
        }
    }

    static class BookingTask implements Runnable {
        private String type;
        private int userId;

        BookingTask(String type, int userId) {
            this.type = type;
            this.userId = userId;
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < TOTAL_SEATS; i++) {
                    if (!seats[i]) {
                        seats[i] = true;
                        System.out.println(type + " User " + userId + " booked Seat " + (i + 1));
                        return;
                    }
                }
                System.out.println(type + " User " + userId + " could not book a seat");
            }
        }
    }
}
