//Сравнить время выполнения замены символа "а" на "А" любой строки содержащей >1000 символов средствами String и StringBuilder.
public class Task3 {
    public static void main(String[] args) {
      String s = "a".repeat(10000);
      StringBuilder sb = new StringBuilder(s);
      long start = System.currentTimeMillis();
      s = s.replace('a', 'A');
      long elapsedTimeMillis = System.currentTimeMillis() - start;
      System.out.printf("Для String операция заняла %d%n", elapsedTimeMillis);
      start = System.currentTimeMillis();
      for (int i = 0; i < sb.length(); i++) {
        if (sb.charAt(i) == 'a') {
          sb.setCharAt(i, 'A');
        }
      }
      elapsedTimeMillis = System.currentTimeMillis() - start;
      System.out.printf("Для StringBuilder операция заняла %d%n", elapsedTimeMillis);
    }
  }