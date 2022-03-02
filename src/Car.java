import java.util.Random;

public class Car implements Runnable{
    public static final int DISTANCE = 100;
    public static final int STEP = 2 ;

    private String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // Khởi tạo điểm start(hay km ban đầu)
        int runDistance = 0;
        // Khởi tạo time bắt đầu cuộc đua
        long startTime = System.currentTimeMillis();

        // Kiểm tra chừng nào còn xe chưa kết thúc quãng đường đua thì xe vẫn tiếp tục chạy
        while (runDistance < DISTANCE) {
            try {
                // Random Speed KM/H
                int speed = (new Random()).nextInt(20);
                // Calculate traveled distance
                runDistance += speed;
                // Build result graphic
                String log = "|";
                int percentTravel = (runDistance * 100) / DISTANCE;// tính phần trăm quãng đường hiển thị lên
                for (int i = 0; i < DISTANCE; i += STEP) {
                    if (percentTravel >= i + STEP) {
                        log += "=";// Đoạn từ điểm xuất phát đến quãng đường đi được đc bieuet hị bằng dấu =
                    } else if (percentTravel >= i && percentTravel < i + STEP) {
                        log += "o"; // đánh dấu vị trí đang dừng lại
                    } else {
                        log += "-"; //còn lại là quãng đường chưa đi được.
                    }
                }
                log += "|";
                System.out.println("Car" + this.name + ": " + log + " " + Math.min(DISTANCE, runDistance) + "KM");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Car" + this.name + " broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
    }
}


