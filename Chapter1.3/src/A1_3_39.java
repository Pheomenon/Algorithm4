/**
 * @Author:Gao
 * @Date:2019-08-16 11:34
 */
/*
环形缓冲区。环形缓冲区，又称环形队列，是一种定长为N的先进先出的数据结构。
它在进程间的异步数据传输或记录日志文件时十分有用。当缓冲区为空时，消费者会在数据存入缓冲区
前等待，当缓冲区满时，生产者会等待将数据存入缓冲区。为RingBuffer设计一份API并用(回环）数组
将其实现
 */
public class A1_3_39 {
    public static void main(String[] args) {
        RingBuffer<Integer> producer = new RingBuffer<>();
        RingBuffer<Integer> consumer = new RingBuffer<>();
        producer.put(1);
        producer.put(2);
        producer.put(3);
        producer.put(4);
        producer.put(5);
        producer.put(6);
        producer.put(7);
        producer.put(8);
        producer.put(9);
        producer.put(10);
        producer.put(11);
        consumer.put(producer.take());
        consumer.put(producer.take());
        producer.put(11);
    }
}

class RingBuffer<Item> {
    int Size = 10;
    int N = 0;
    Item[] items = (Item[]) new Object[Size];

    public void put(Item item) {
        if (N == Size) {
            System.out.println("Wait for consumer");
            return;
        }
        items[N++] = item;

    }

    public Item take() {
        if (isEmpty()) {
            System.out.println("Wait for producer");
            return items[0];
        }
        Item item = items[0];
        for (int i = 0; i < N - 1; i++) {
            items[i] = items[i + 1];
        }
        N--;
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
