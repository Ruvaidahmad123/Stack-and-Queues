public class QueueWithFixedArray {
    private int fixedSize;
    private int cnt;
    private int head;
    private int tail;
    private Object[] headArr;
    private Object[] tailArr;

    public QueueWithFixedArray(int fixedSize) {
      this.fixedSize = fixedSize;
      this.cnt = 0;
      this.head = 0;
      this.tail = 0;
      this.headArr = new Object[fixedSize];
      this.tailArr = headArr;
    }

    public void offer(int num) {
      if (tail == fixedSize - 1) {
        Object[] newArr = new Object[fixedSize];
        newArr[0] = num;
        tailArr[fixedSize - 1] = newArr;
        tailArr = newArr;
        tail = 0;
      } else {
        tailArr[tail] = num;
      }
      tail++;
      cnt++;
    }

    public int poll() {
      if (cnt == 0) return -1;
      int num = (int) headArr[head];
      head++;
      cnt--;

      if (head == fixedSize - 1) {
        headArr = (Object[]) headArr[fixedSize - 1];
        head = 0;
      }
      return num;
    }

    public int size() {
      return cnt;
    }
  }
