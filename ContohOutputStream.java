import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ContohOutputStream {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            outputStream = new FileOutputStream("output.txt");
            outputStreamWriter = new OutputStreamWriter(outputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            System.out.println("Masukkan teks yang ingin ditulis ke file:");
            String inputText = bufferedReader.readLine();

            bufferedWriter.write(inputText);

            System.out.println("Teks berhasil ditulis ke file output.txt");
        } catch (IOException e) {
            // Tangani pengecualian jika terjadi kesalahan input/output
            System.err.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            try {
                // Tutup stream yang dibuka
                if (bufferedWriter != null) bufferedWriter.close();
                if (outputStreamWriter != null) outputStreamWriter.close();
                if (outputStream != null) outputStream.close();
                if (bufferedReader != null) bufferedReader.close();
                if (inputStreamReader != null) inputStreamReader.close();
                if (inputStream != null) inputStream.close();
            } catch (IOException e) {
                System.err.println("Gagal menutup stream: " + e.getMessage());
            }
        }
    }
}
