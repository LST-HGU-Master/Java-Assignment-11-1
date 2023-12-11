import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import java.io.*;

public class ProgB1Test {

    @Test
    public void testMain()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        // action
        // in.inputln("2"); // 標準入力をテストする場合
        // Hello.main(new String[]{"1", "2", "3"}); // 実行時引数をテストする場合
        ProgB1.main(null);
        // undo the binding in System
        System.setOut(originalOut);
        // assertion
        String[] prints = bos.toString().split("\r\n|\n", -1);
        try {
            assertEquals("勇者太郎 (HP:100) が誕生した！",prints[0], "main()メソッドのprint文の１行目が実行例と異なっています!");
        } catch (ArrayIndexOutOfBoundsException er) {
            fail("print文の改行が実行例よりも不足しています!");
        }
        assertEquals(2, prints.length, "改行数が２つ以上あります!");
    }
}
