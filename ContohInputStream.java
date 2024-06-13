import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ContohInputStream {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    try {
      System.out.println("Masukan deretan angka yang dipisahkan oleh spasi: ");
      String input = bufferedReader.readLine();

      String[] numbers = input.split(" ");

      int sum = 0;
      for (String number : numbers) {
        sum += Integer.parseInt(number);
      }

      System.out.println("Jumlah total angka adalah: " + sum);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (NumberFormatException e) {
      System.out.println("Input tidak valid. Pastikan anda hanya memasukan angka!");
    } finally {
      try {
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}